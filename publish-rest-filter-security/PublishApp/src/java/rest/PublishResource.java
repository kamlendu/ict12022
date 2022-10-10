/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import ejb.PublishBeanLocal;
import entity.Address;
import entity.Customer;
import entity.Subscription;
import java.util.Collection;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author root
 */
@DeclareRoles({"Admin","Supervisor"})

@Path("publish")
public class PublishResource {
    
    @EJB PublishBeanLocal pbl;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PublishResource
     */
    public PublishResource() {
    }

  @RolesAllowed("Admin")
    @POST
    @Path("addcust/{fname}/{lname}")
    public void addCustomer(@PathParam("fname") String firstName, @PathParam("lname") String lastName) {
   
        pbl.addCustomer(firstName, lastName);
    }
@RolesAllowed("Admin")
    @PUT
    @Path("updatecust/{id}/{fname}/{lname}")
    public void updateCustomer(@PathParam("id") Integer custId, @PathParam("fname") String firstName, @PathParam("lname") String lastName) {
   
      pbl.updateCustomer(custId, firstName, lastName);
    }
@RolesAllowed("Admin")
    @DELETE
    @Path("delcust/{id}")
    public void removeCustomer(@PathParam("id") Integer custId) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
        pbl.removeCustomer(custId);
    }
@RolesAllowed("Admin")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Customer> getAllCustomers() {
        
        return pbl.getAllCustomers();
         }
@RolesAllowed("Admin")
    @GET
    @Path("custbyfname/{fname}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Customer> getCustomersByFirstName(@PathParam("fname") String fname) {
    
        return pbl.getCustomersByFirstName(fname);
    }

    
    @RolesAllowed("Admin")
     @GET
    @Path("custbyid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer findCustomerById(@PathParam("id") Integer custId) {
     
        return pbl.findCustomerById(custId);
    }
    
@RolesAllowed("Admin")
    @POST
    @Path("addaddress/{street}/{city}/{state}/{zip}/{cid}")
    public void addAddressToCustomer(@PathParam("street") String street, @PathParam("city") String city,@PathParam("state") String state,@PathParam("zip") String zip, @PathParam("cid") Integer custId) {
     
      
        pbl.addAddressToCustomer(street, city, state, zip, custId);
    }
      
@RolesAllowed("Admin")
    @DELETE
    @Path("deladdress/{cid}/{aid}")
    public void removeAddressToCustomers(@PathParam("cid") Integer custId, @PathParam("aid") Integer addressId) {
      pbl.removeAddressToCustomers(custId, addressId);
    }
@RolesAllowed("Admin")
    @GET
    @Path("custaddress/{cid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Address> getAddressOfCustomer( @PathParam("cid") Integer custId) {
     return pbl.getAddressOfCustomer(custId);
    }

    @RolesAllowed("Admin")
    @POST
    @Path("addsub/{title}/{type}")
    public void addSubscription(@PathParam("title") String title,@PathParam("type") String type) {
        pbl.addSubscription(title, type);
   
    }
@RolesAllowed("Admin")
    @DELETE
    @Path("delsub/{sid}")
    public void removeSubscription(@PathParam("sid")Integer subId) {
    pbl.removeSubscription(subId);
    
    }

    
  @RolesAllowed("Admin")
    @GET
    @Path("getcustsubs/{cid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Subscription> getSubscriptionsofCustomer(@PathParam("cid") Integer custId) {
    
        return pbl.getSubscriptionsofCustomer(custId);
    }

    
    @RolesAllowed("Admin")
    @POST
    @Path("addsubtocust/{cid}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addSubscriptionsToCustomer(@PathParam("cid") Integer custId, Collection<Integer> subIds) {
      
        pbl.addSubscriptionsToCustomer(custId, subIds);
    }
@RolesAllowed("Admin")
    @POST
    @Path("remsubtocust/{cid}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void removeSubscriptionsToCustomer(@PathParam("cid") Integer custId, Collection<Integer> subIds) {
     
        pbl.removeSubscriptionsToCustomer(custId, subIds);
    }
}
