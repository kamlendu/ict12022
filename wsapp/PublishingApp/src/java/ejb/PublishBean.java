/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.Address;
import entity.Customer;
import entity.Subscription;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@WebService
@Stateless
public class PublishBean implements PublishBeanLocal {
    @PersistenceContext(unitName = "pubpu")
    EntityManager em;

    @Override
    public void addCustomer(String fname, String lname) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    Customer c = new Customer();
    c.setFirstName(fname);
    c.setLastName(lname);
    em.persist(c);
    
    }

    @Override
    public void updateCustomer(Integer cid, String fname, String lname) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    Customer c = (Customer) em.find(Customer.class, cid);
    c.setFirstName(fname);
    c.setLastName(lname);
    
    em.merge(c);
    
    
    }

    @Override
    public void removeCustomer(Integer cid) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     Customer c = (Customer) em.find(Customer.class, cid);
    
    em.remove(c);
    
    }

    @Override
    public void addAddressOfCustomer(String street, String city, String state, String zip, Integer cid) {
   //     throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     Customer c = (Customer) em.find(Customer.class, cid);
     Collection<Address> addresses = c.getAddressCollection();
     Address a = new Address();
     a.setStreet(street);
     a.setCity(city);
     a.setState(state);
     a.setZip(zip);
     a.setCustomer(c);  
     
     addresses.add(a);
     c.setAddressCollection(addresses);
     
     em.persist(a);
     em.merge(c);
  
    }

    @Override
    public void removeAddressOfCustomer(Integer aid, Integer cid) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     Customer c = (Customer) em.find(Customer.class, cid);
     Address a = (Address) em.find(Address.class, aid);
     Collection<Address> addresses = c.getAddressCollection();
     
     if(addresses.contains(a))
     {
         addresses.remove(a);
         c.setAddressCollection(addresses);
         em.remove(a);
         em.merge(c);
     }
     
    
    }

    @Override
    public void updateAddressOfCustomer(Integer aid, String street, String city, String state, String zip, Integer cid) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addSubscription(String title, String type) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateSubscription(Integer sid, String title, String type) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removeSubscription(Integer sid) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addSubscriptionsToCustomers(Integer cid, Collection<Integer> ids) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    Customer c = (Customer) em.find(Customer.class, cid);
    Collection<Subscription> subs = c.getSubscriptionCollection();
    
    
    for(Integer sid : ids)
    {
       Subscription s = (Subscription) em.find(Subscription.class, sid);
       
       if(!subs.contains(s))
       {
           Collection<Customer> custs = s.getCustomerCollection();
           custs.add(c);
           subs.add(s);
           c.setSubscriptionCollection(subs);
           s.setCustomerCollection(custs);
           
           em.merge(s);
           
           
       }
  
    }
    
    
    
    
    }

    @Override
    public void removeSubscriptionsToCustomers(Integer cid, Collection<Integer> ids) {
   Customer c = (Customer) em.find(Customer.class, cid);
    Collection<Subscription> subs = c.getSubscriptionCollection();
    
    
    for(Integer sid : ids)
    {
       Subscription s = (Subscription) em.find(Subscription.class, sid);
       
       if(subs.contains(s))
       {
           Collection<Customer> custs = s.getCustomerCollection();
           custs.remove(c);
           subs.remove(s);
           c.setSubscriptionCollection(subs);
           s.setCustomerCollection(custs);
           
           em.merge(s);
           
           
       }
  
    }
    
      }

    @Override
    public Collection<Customer> getAllCustomers() {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    return em.createNamedQuery("Customer.findAll").getResultList();
    }

    @Override
    public Collection<Customer> getCustomersByFirstName(String fname) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   
    return em.createNamedQuery("Customer.findByFirstName")
            .setParameter("firstName", fname)
            .getResultList();
    }

    @Override
    public Collection<Customer> getCustomersByLastName(String lname) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    return em.createNamedQuery("Customer.findByFirstName")
            .setParameter("lastName", lname)
            .getResultList();
    }

    @Override
    public Collection<Address> getAddressesOfCustomer(Integer cid) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    Customer c = (Customer) em.find(Customer.class, cid);
    return c.getAddressCollection();
    }

    @Override
    public Collection<Address> getAddressesByCity(String city) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Subscription> getAllSubscription() {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    return em.createNamedQuery("Subscription.findAll").getResultList();
    }

    @Override
    public Collection<Subscription> getSubscriptionsByType(String type) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Subscription getSubscriptionByTitle(String title) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Subscription> getAllSubscriptionsOfCustomer(Integer cid) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    Customer c = (Customer) em.find(Customer.class, cid);
    return c.getSubscriptionCollection();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")



}
