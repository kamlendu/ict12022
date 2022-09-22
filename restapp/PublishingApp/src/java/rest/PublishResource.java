/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package rest;

import ejb.PublishBeanLocal;
import entity.Address;
import entity.Customer;
import entity.Subscription;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 *
 * @author root
 */
@Path("publish")
@RequestScoped
public class PublishResource {
@EJB PublishBeanLocal pb;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PublishResource
     */
    public PublishResource() {
    }

    /**
     * Retrieves representation of an instance of rest.PublishResource
     * @return an instance of java.lang.String
     */
    
    
    @POST
    @Path("addcust/{fname}/{lname}")
    public void addCustomer(@PathParam("fname") String fname, @PathParam("lname") String lname) {
    
     pb.addCustomer(fname, lname);
    }

    @PUT
    @Path("updatecust/{cid}/{fname}/{lname}")
    public void updateCustomer(@PathParam("cid") Integer cid, @PathParam("fname") String fname, @PathParam("lname") String lname) {
     
    pb.updateCustomer(cid, fname, lname);
    }

    @DELETE
    @Path("removecust/{cid}")
    public void removeCustomer(@PathParam("cid") Integer cid) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     pb.removeCustomer(cid);
    }

   @POST
   @Path("addaddress/{street}/{city}/{state}/{zip}/{cid}")
    public void addAddressOfCustomer(@PathParam("street") String street,@PathParam("city") String city, @PathParam("state") String state, @PathParam("zip") String zip, @PathParam("cid") Integer cid) {
   
        pb.addAddressOfCustomer(street, city, state, zip, cid);
    }

    @DELETE
    @Path("deleteaddress/{aid}/{cid}")
    public void removeAddressOfCustomer(@PathParam("aid") Integer aid, @PathParam("cid") Integer cid) {
        
        pb.removeAddressOfCustomer(aid, cid);
   
    }
     
    @POST
    @Path("addsubscust/{cid}")
    @Consumes("application/json")
    public void addSubscriptionsToCustomers(@PathParam("cid") Integer cid, Collection<Integer> ids) {
    
        pb.addSubscriptionsToCustomers(cid, ids);
    }

    @POST
    @Path("removesubscust/{cid}")
    @Consumes("application/json")
    public void removeSubscriptionsToCustomers(@PathParam("cid") Integer cid, Collection<Integer> ids) {
      
        pb.removeSubscriptionsToCustomers(cid, ids);
    }

    
    @GET
    @Produces("application/json")
    public Collection<Customer> getAllCustomers() {
    
    return pb.getAllCustomers();
    }

     @GET
     @Path("findbyfirst/{fname}")
    @Produces("application/json")
    public Collection<Customer> getCustomersByFirstName(@PathParam("fname") String fname) {
    
      return  pb.getCustomersByFirstName(fname);
    }

     @GET
     @Path("findbylast/{lname}")
    @Produces("application/json")
    public Collection<Customer> getCustomersByLastName(@PathParam("lname") String lname) {
        return pb.getCustomersByLastName(lname);
    }

     @GET
     @Path("getaddresscust/{cid}")
    @Produces("application/json")
    public Collection<Address> getAddressesOfCustomer(@PathParam("cid") Integer cid) {
    
            return pb.getAddressesOfCustomer(cid);
    }

    

    @GET
     @Path("getallsubs")
    @Produces("application/json")
    public Collection<Subscription> getAllSubscription() {
        return pb.getAllSubscription();
    }

 @GET
     @Path("getsubsofcust/{cid}")
    @Produces("application/json")
    public Collection<Subscription> getAllSubscriptionsOfCustomer(@PathParam("cid") Integer cid) {
    
    return pb.getAllSubscriptionsOfCustomer(cid);
    }

}
