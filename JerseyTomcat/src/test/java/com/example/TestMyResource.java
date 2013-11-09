package com.example;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import junit.framework.Assert;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;


public class TestMyResource {

//    private WebTarget target;
	
	static protected WebResource service;

    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost:8080/JerseyTomcat/webresources").build();
     }
    
	@BeforeClass
	static public void setUp() throws Exception {
	    ClientConfig config = new DefaultClientConfig();
	    Client client = Client.create(config);
	    
	    service = client.resource(getBaseURI());		
	}

	@AfterClass
	static public void tearDown() throws Exception {
	}

	@Test
	public void test1() {
		String result = service.path("myresource").accept(MediaType.TEXT_PLAIN).get(String.class);
	    assertEquals(result, "Hello Internet!");
	}

	@Test
	public void test2() {
		String result = service.path("myresource").accept(MediaType.APPLICATION_JSON).get(String.class);
	    assertEquals(result, "{\"Hello Internet!\"}");
	}
	
	@Test
	public void test3() {
		String result = service.path("myresource").accept(MediaType.TEXT_HTML).get(String.class);
	    assertEquals(result, "<H1>Hello Internet!</H1>");
	}
}
