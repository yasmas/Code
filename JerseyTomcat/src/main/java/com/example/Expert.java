package com.example;

import java.sql.Date;
import java.sql.Timestamp;

import com.iciql.Iciql;

public class Expert implements Iciql {
	public Integer expertId;
	public Integer memberId;
	public String descriptionShort;
	public String descriptionLong;
	public String facebook;
	public String homepage;
	public String twitter;	
	public Float score;
	
	public Expert() {
		
	}
	
	@Override
	public void defineIQ() {
		com.iciql.Define.primaryKey(expertId);
		com.iciql.Define.autoIncrement(expertId);
		com.iciql.Define.nullable(descriptionShort,false);
	}

}
