package com.example;

import java.sql.Date;
import java.sql.Timestamp;

import com.iciql.Iciql;

public class ExpertTag implements Iciql {
	public Integer tagId;
	public Integer expertId;
	
	public ExpertTag() {		
	}
	
	@Override
	public void defineIQ() {
		com.iciql.Define.primaryKey(tagId, expertId);
	}

}
