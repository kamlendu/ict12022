/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package rest;

import ejb.HelloBeanLocal;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author root
 */
@DeclareRoles({"Admin","Supervisor"})
@Path("test")
public class HelloResource {
    
    @EJB HelloBeanLocal hbl;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HelloResource
     */
    public HelloResource() {
    }

    /**
     * Retrieves representation of an instance of rest.HelloResource
     * @return an instance of java.lang.String
     */
    @RolesAllowed("Admin")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String speakHello() {
        //TODO return proper representation object
       // throw new UnsupportedOperationException();
    
    return "Secure Rest Says :" + hbl.sayHello();
    }

    /**
     * PUT method for updating or creating an instance of HelloResource
     * @param content representation for the resource
     */
    
}
