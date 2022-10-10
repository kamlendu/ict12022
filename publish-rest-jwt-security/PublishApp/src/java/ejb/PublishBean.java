/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Address;
import entity.Customer;
import entity.Subscription;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class PublishBean implements PublishBeanLocal {
    @PersistenceContext(unitName = "PublishAppPU")
    EntityManager em;
    
    

    @Override
    public void addCustomer(String firstName, String lastName) {
   //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
    Customer c = new Customer();
    c.setFirstName(firstName);
    c.setLastName(lastName);
    em.persist(c);
    
    }

    @Override
    public void updateCustomer(Integer custId, String firstName, String lastName) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     Customer c = em.find(Customer.class, custId);
     c.setFirstName(firstName);
     c.setLastName(lastName);
     em.merge(c);
     
    }

    @Override
    public void removeCustomer(Integer custId) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Customer c = em.find(Customer.class, custId);
    em.remove(c);
    
    }

    @Override
    public Collection<Customer> getAllCustomers() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
     return em.createNamedQuery("Customer.findAll").getResultList();
    }

    @Override
    public Collection<Customer> getCustomersByFirstName(String fname) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    Collection<Customer> custs = em.createNamedQuery("Customer.findByFirstName")
                                    .setParameter("firstName", fname)
                                    .getResultList();
    
    return custs;
    }

    @Override
    public Collection<Customer> getCustomersByLastName(String lname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer findCustomerById(Integer custId) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    return em.find(Customer.class, custId);
    }
    

    @Override
    public void addAddressToCustomer(String street, String city, String state, String zip, Integer custId) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      
      Customer cust = em.find(Customer.class, custId);
      Collection<Address> addresses = cust.getAddressCollection();
      
      Address address = new Address();
      address.setStreet(street);
      address.setCity(city);
      address.setState(state);
      address.setZip(zip);
      address.setCustomer(cust);
      
      addresses.add(address);
      cust.setAddressCollection(addresses);
      
      em.persist(address);
      em.merge(cust);
      
      
      
        
    }
      

    @Override
    public void removeAddressToCustomers(Integer custId, Integer addressId) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
     Customer cust = em.find(Customer.class, custId);
     Address address = em.find(Address.class , addressId);
     Collection<Address> addresses = cust.getAddressCollection();
     
     if(addresses.contains(address))
     {
         addresses.remove(address);
         cust.setAddressCollection(addresses);
         em.remove(address);
         em.merge(cust);
     }
     
     
    }

    @Override
    public Collection<Address> getAddressOfCustomer(Integer custId) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     Customer cust = em.find(Customer.class, custId);
     return cust.getAddressCollection();
    }

    @Override
    public Collection<Address> getAddressesByCity(String city) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Address> getAddressesByZip(String zip) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addSubscription(String title, String type) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        Subscription sub = new Subscription();
        sub.setTitle(title);
        sub.setType(type);
        em.persist(sub);
    }

    @Override
    public void updateSubscription(Integer subId, String title, String type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeSubscription(Integer subId) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Subscription sub = em.find(Subscription.class, subId);
    em.remove(sub);
    
    }

    @Override
    public Collection<Subscription> getSubscriptionsByType(String type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Subscription> getSubscriptionsofCustomer(Integer custId) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     Customer cust = em.find(Customer.class, custId);
    
       return cust.getSubscriptionCollection();
    }

    
    
    @Override
    public void addSubscriptionsToCustomer(Integer custId, Collection<Integer> subIds) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
     Customer cust = em.find(Customer.class, custId);
     Collection<Subscription> subs = cust.getSubscriptionCollection();
     
     for(Integer subId : subIds)
     {
        Subscription sub = em.find(Subscription.class, subId);
        
        if(!subs.contains(sub))
        {
         
            Collection<Customer> custs = sub.getCustomerCollection();
            custs.add(cust);
            subs.add(sub);
            
            cust.setSubscriptionCollection(subs);
            sub.setCustomerCollection(custs);
            
            // Merge any one entity not both
            em.merge(cust);
            
            
        }
         
         
         
     }
  
    }

    @Override
    public void removeSubscriptionsToCustomer(Integer custId, Collection<Integer> subIds) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
    Customer cust = em.find(Customer.class, custId);
     Collection<Subscription> subs = cust.getSubscriptionCollection();
     
     for(Integer subId : subIds)
     {
        Subscription sub = em.find(Subscription.class, subId);
        
        if(subs.contains(sub))
        {
         
            Collection<Customer> custs = sub.getCustomerCollection();
            custs.remove(cust);
            subs.remove(sub);
            
            cust.setSubscriptionCollection(subs);
            sub.setCustomerCollection(custs);
            
            // Merge any one entity not both
            em.merge(cust);
            
            
        }
         
         
         
     }
    
    
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")


}
