//senderbase.org
//spamhaus.org


package com.example;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.Services;

public class TestServices {

	static private Services services;
	
	@BeforeClass
	static public void setUp() throws Exception {
		services = new Services();
		services.initServices();
		
		services.cleanupTests();
	}

	@AfterClass
	static public void tearDown() throws Exception {
		services.endServices();
	}

	@Test
	public void testCreateMember() {
		Member m = new Member();
		m.name = "Name Test";
		m.email = "Test@gmail.com";
		m.password = "TestTest";
		m.birthday = java.sql.Date.valueOf("1970-04-02");
		m.gender = "F";
		m.test = "Y";
		assertTrue("Must create member", services.createMember(m));
	}

	@Test
	public void testLogin() {
		Member m = services.doLogin("Test@gmail.com", "TestTest");
		if(m==null)
			fail("Can't login using Test@gmail.com");		
	}
	
	@Test
	public void testLoginWrongPass() {
		Member m = services.doLogin("Test@gmail.com", "TestWrongPass");
		if(m!=null)
			fail("Able to login to Test@gmail.com with wrong password");
	}
		
	@Test
	public void testCreateWithDuplicateMember() {
		Member m = new Member();
		m.name = "Name Test2";
		m.email = "Test@gmail.com";
		m.password = "TestTest2";
		m.test = "Y";
		if(services.createMember(m))
			fail("Was able to cretae member with same Email");
	}
	
	@Test 
	public void testSearchTags() {
		List<Expert> experts = services.searchExperts("One, Two, Three", "Yossi Maish");
		
		System.out.println("=== testSearchTags ===");
		for(Expert e: experts) {
			System.out.println("id: " + e.expertId + ", description: " + e.descriptionShort);
		}
	}
	
	@Test
	public void testTopExperts() {
		List<Expert> experts = services.getTopExperts(10, 1);
		System.out.println("=== testTopExperts ===");
		for(Expert e: experts) {
			System.out.println("id: " + e.expertId + ", description: " + e.descriptionShort);
		}		
	}
	// Delete Test Data
	@Test 
	public void testDeleteMember() {
		Member m = services.doLogin("Test@gmail.com", "TestTest");
		if(!services.deleteMember(m))
			fail("Failinig to delete test@gmail.com member");
	}
}
