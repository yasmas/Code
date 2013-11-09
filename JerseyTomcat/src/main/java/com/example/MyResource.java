
package com.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/** Example resource class hosted at the URI path "/myresource"
 */
@Path("/myresource")
public class MyResource {
    
    /** Method processing HTTP GET requests, producing "text/plain" MIME media
     * type.
     * @return String that will be send back as a response of type "text/plain".
     */
	
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
