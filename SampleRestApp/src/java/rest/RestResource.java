/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package rest;

import java.util.ArrayList;
import java.util.Collection;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author root
 */
@Path("mscict")
public class RestResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RestResource
     */
    public RestResource() {
    }

    /**
     * Retrieves representation of an instance of rest.RestResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{pname}")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello(@PathParam("pname") String pname) {
        //TODO return proper representation object
       // throw new UnsupportedOperationException();
       
       return "Hello World of Rest  " + pname + " !!";
    }

    @GET
    @Path("greet/{pname}")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayGreeting(@PathParam("pname") String pname) {
        //TODO return proper representation object
       // throw new UnsupportedOperationException();
       
       return "Welcome Mr.  " + pname + " to the occassion !!";
    }
    
    @POST
    @Path("caps")
    @Produces("application/json")
    @Consumes("application/json")
    public Collection<String> unames(Collection<String> lnames)
    {
        Collection<String> uppers = new ArrayList<>();
        
        for(String str : lnames)
        {
            uppers.add(str.toUpperCase());
        }
        
        return uppers;
    }
    
}
