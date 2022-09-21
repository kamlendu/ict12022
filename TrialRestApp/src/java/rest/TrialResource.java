/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package rest;

import ejb.LogicBean;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
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
@Path("trial")
public class TrialResource {

    @EJB LogicBean lb;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RestResource
     */
    public TrialResource() {
    }

    /**
     * Retrieves representation of an instance of rest.RestResource
     * @param pname
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{pname}")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello( @PathParam("pname") String pname) {
      
       return lb.sayHello(pname);
    }

    @GET
    @Path("greet/{pname}")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayGreeting(@PathParam("pname") String pname) {
        //TODO return proper representation object
       // throw new UnsupportedOperationException();
       
       return lb.sayGreeting(pname);
    }
    
    @POST
    @Path("uppers")
    @Produces("application/json")
    @Consumes("application/json")
    public Collection<String> unames(Collection<String> lnames)
    {
        
        
        return lb.unames(lnames);
    }
    
}
