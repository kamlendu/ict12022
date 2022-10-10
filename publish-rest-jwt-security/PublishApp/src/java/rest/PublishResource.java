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

  
    @POST
    @Path("addcust/{fname}/{lname}")
    public void addCustomer(@PathParam("fname") String firstName, @PathParam("lname") String lastName) {
   
        pbl.addCustomer(firstName, lastName);
    }

    @PUT
    @Path("updatecust/{id}/{fname}/{lname}")
    public void updateCustomer(@PathParam("id") Integer custId, @PathParam("fname") String firstName, @PathParam("lname") String lastName) {
   
      pbl.updateCustomer(custId, firstName, lastName);
    }

    @DELETE
    @Path("delcust/{id}")
    public void removeCustomer(@PathParam("id") Integer custId) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
        pbl.removeCustomer(custId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Customer> getAllCustomers() {
        
        return pbl.getAllCustomers();
         }

    @GET
    @Path("custbyfname/{fname}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Customer> getCustomersByFirstName(@PathParam("fname") String fname) {
    
        return pbl.getCustomersByFirstName(fname);
    }

    
    
     @GET
    @Path("custbyid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer findCustomerById(@PathParam("id") Integer custId) {
     
        return pbl.findCustomerById(custId);
    }
    

    @POST
    @Path("addaddress/{street}/{city}/{state}/{zip}/{cid}")
    public void addAddressToCustomer(@PathParam("street") String street, @PathParam("city") String city,@PathParam("state") String state,@PathParam("zip") String zip, @PathParam("cid") Integer custId) {
     
      
        pbl.addAddressToCustomer(street, city, state, zip, custId);
    }
      

    @DELETE
    @Path("deladdress/{cid}/{aid}")
    public void removeAddressToCustomers(@PathParam("cid") Integer custId, @PathParam("aid") Integer addressId) {
      pbl.removeAddressToCustomers(custId, addressId);
    }

    @GET
    @Path("custaddress/{cid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Address> getAddressOfCustomer( @PathParam("cid") Integer custId) {
     return pbl.getAddressOfCustomer(custId);
    }

    
    @POST
    @Path("addsub/{title}/{type}")
    public void addSubscription(@PathParam("title") String title,@PathParam("type") String type) {
        pbl.addSubscription(title, type);
   
    }

    @DELETE
    @Path("delsub/{sid}")
    public void removeSubscription(@PathParam("sid")Integer subId) {
    pbl.removeSubscription(subId);
    
    }

    
  
    @GET
    @Path("getcustsubs/{cid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Subscription> getSubscriptionsofCustomer(@PathParam("cid") Integer custId) {
    
        return pbl.getSubscriptionsofCustomer(custId);
    }

    
    
    @POST
    @Path("addsubtocust/{cid}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addSubscriptionsToCustomer(@PathParam("cid") Integer custId, Collection<Integer> subIds) {
      
        pbl.addSubscriptionsToCustomer(custId, subIds);
    }

    @POST
    @Path("remsubtocust/{cid}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void removeSubscriptionsToCustomer(@PathParam("cid") Integer custId, Collection<Integer> subIds) {
     
        pbl.removeSubscriptionsToCustomer(custId, subIds);
    }
}
