package com.example;

import java.sql.Date;
import java.sql.Timestamp;

import com.iciql.Iciql;

public class Tag implements Iciql {
	public Integer tagId;
	public String tag;
	
	public Tag() {
		
	}
	
	@Override
	public void defineIQ() {
		com.iciql.Define.primaryKey(tagId);
		com.iciql.Define.autoIncrement(tagId);
		com.iciql.Define.nullable(tag,false);
	}
}
