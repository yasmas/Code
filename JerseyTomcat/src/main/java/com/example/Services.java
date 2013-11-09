package com.example;

import java.util.List;

import com.iciql.Db;

public class Services {

	protected Db db;
	
	public Services() {
	}
	
	public void initServices() {
		db = Db.open("jdbc:postgresql://localhost:5432/postgres", "postgres", "Humus99");
		db.setSkipCreate(true);
	}
	
	public void endServices() {
		db.close();
	}
	
	public void cleanupTests() {
		// Delete all test members
		Member m = new Member();
		db.from(m).where(m.test).is("Y").delete();
	}
	
	public boolean createMember(Member m) {
		boolean result = false;
		try {
			db.insert(m);
			result = true;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}
	
	public Member doLogin(String email, String password) {
		Member m = new Member();
		
		//String sql = db.from(m).where(m.email).is(email).and(m.password).is(password).toSQL();
		m = db.from(m).where(m.email).is(email).and(m.password).is(password).selectFirst();
		return m;
	}
	
	public boolean deleteMember(Member m) {
		boolean result = false;
		try {
			result = db.delete(m) > 0;
		} catch (Exception e) {
			System.out.println(e.toString());			
		}
		return result;
	}

	public List<Expert> searchExperts(String tagsWithCommas, String name) {
		List<Expert> experts;
		Expert e = new Expert();
		
		String[] tags = tagsWithCommas.split(",");
		String tagStr = "";
		for(int i=0; i<tags.length; i++) {
			if(i>0) tagStr+=",";
			tagStr += "'"+tags[i].trim()+"'";
		}
		String SQL = 
			"SELECT Expert.* " + 
			"FROM Expert, ExpertTag " +
			"WHERE ";
//		if(name.length()>0)
//			SQL += "Expert.name like '%" + name + "%' OR ";
		SQL +=
			"Expert.expertId=ExpertTag.expertId AND ExpertTag.tagid in " +
			"(SELECT Tag.tagId FROM Tag WHERE Tag.tag in (" + tagStr +")) " +
			"GROUP by Expert.expertId";

		experts = db.executeQuery(Expert.class, SQL);
		return experts;
	}
	
	/* 
	 * Page1 is the start
	 */
	public List<Expert> getTopExperts(long count, long page) {
		List<Expert> experts;
		Expert e = new Expert();
		
		if(page<1) page=1;
		if(count>100) count=100;
		if(count<1) count=1;
		
		experts = db.from(e).orderByDesc(e.score).limit(count).offset((page-1)*count).select();
		return experts;
	}
}
	
