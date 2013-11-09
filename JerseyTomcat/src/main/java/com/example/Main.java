package com.example;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.iciql.Db;
import com.iciql.Iciql;
import com.iciql.Iciql.IQIgnore;

import java.sql.Date;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Services services = new Services();
		services.initServices();
		
		Member m = services.doLogin("yasmas@gmail.com", "1234");
		System.out.println("Member name="+m.name);
		
		
//		m.birthday = Date.valueOf("1970-04-02");
//		m.avatar = "some_avatar.jpg";
//		m.city = "West Hills";
//		m.country = "USA";
//		m.gender = "M";
//		m.name = "Yossi2";
//		db.insert(m);
//		
//		List<Member> members =
//			db.from(m).
//			where(m.memberId).
//			atLeast(0).
//			orderBy(m.memberId).select();
//		
//		for(Member mm: members) {
//			System.out.println("Id=" + mm.memberId + ", name=" + mm.name + ", birthdate=" + (mm.birthday==null ? "NULL" : mm.birthday.toString()));
//		}
//
//		m.memberId=13;
//		db.delete(m);
		
/*				
		for (Product product : restock) {
			db.from(p).
			set(p.unitsInStock).to(25).
			where(p.productId).is(product.productId).update();
		}
*/
	}

}
