package com.example;

import java.sql.Date;
import java.sql.Timestamp;

import com.iciql.Iciql;

public class Member implements Iciql {
	public Integer memberId;
	public String name;
	public String gender;
	public Date birthday;
	public Timestamp registeredAt;
	public String email = "";
	public String password;
	public String avatar;
	public Timestamp lastLoginTime;
	public String lastLoginIP;
	public String city;
	public String state;
	public String country;
	public String test = "N";
	
	public Member() {
		
	}
	
	@Override
	public void defineIQ() {
		com.iciql.Define.primaryKey(memberId);
		com.iciql.Define.autoIncrement(memberId);
		//com.iciql.Define.defaultValue(memberId, null);
		//com.iciql.Define.columnName(unitsInStock, "units");
		com.iciql.Define.length(name, 64);
		//com.iciql.Define.length(category, 50);
		//com.iciql.Define.index(productName, category);
		com.iciql.Define.nullable(name,false);
		com.iciql.Define.nullable(password,false);
	}
}
