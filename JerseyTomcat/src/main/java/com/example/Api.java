
package com.example;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;

import com.example.Services;

@Path("/api")
public class Api {
    
    /** Method processing HTTP GET requests, producing "text/plain" MIME media
     * type.
     * @return String that will be send back as a response of type "text/plain".
     */
	
	@POST @Path("/login")
	@Consumes("application/x-www-form-urlencoded")
	@Produces("text/plain")
	public String doLogin(@FormParam("email") String email,
						@FormParam("password") String password) 
	{
		System.out.println("email="+email+" password="+password);
		return "Login Completed!";
	}
	
	@GET 
	@Path("/searchExperts")
	@Produces("application/json")
	public String searchExperts(@DefaultValue("") @QueryParam("name") String name ,
								@DefaultValue("") @QueryParam("tags") String tags)
	{
		System.out.println("=== searchExperts ===");
		System.out.println("name=" + name + ", tags=" + tags.toString());
		Services services = new Services();
		services.initServices();
		List<Expert> experts = services.searchExperts(tags, "Yossi Maish");
		
		for(Expert e: experts) {
			System.out.println("id: " + e.expertId + ", description: " + e.descriptionShort);
		}
		return("");
	}
	
	
    @GET 
    @Produces("text/plain")
    public String getItText() {
        return "Hello Internet!";
    }

    @GET 
    @Produces("text/html")
    public String getItHtml() {
        return "<H1>Hello Internet!</H1>";
    }

    @GET
    @Produces("application/json")
    public String getItJson() {
        return "{\"Hello Internet!\"}";
    }
}
