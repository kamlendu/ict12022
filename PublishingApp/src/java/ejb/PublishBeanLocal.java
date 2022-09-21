/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import entity.Address;
import entity.Customer;
import entity.Subscription;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface PublishBeanLocal {
    
    
    //= == CRUD Operations for customer table
    
    void addCustomer(String fname, String lname);
    void updateCustomer(Integer cid, String fname, String lname);
    void removeCustomer(Integer cid);
    //== for Address Table
    void addAddressOfCustomer(String street, String city, String state, String zip, Integer cid);
    void removeAddressOfCustomer(Integer aid, Integer cid);
    void updateAddressOfCustomer(Integer aid, String street, String city, String state, String zip, Integer cid);
    //== Subscription table
    
    void addSubscription(String title, String type);
    void updateSubscription(Integer sid, String title, String type);
    void removeSubscription(Integer sid);
    
    void addSubscriptionsToCustomers(Integer cid, Collection<Integer> ids);
    void removeSubscriptionsToCustomers(Integer cid, Collection<Integer> ids);
    
    //==== Query and finder methods
    
    Collection<Customer> getAllCustomers();
    Collection<Customer> getCustomersByFirstName(String fname);
    Collection<Customer> getCustomersByLastName(String lname);
    Collection<Address> getAddressesOfCustomer(Integer cid);
    Collection<Address> getAddressesByCity(String city);
    Collection<Subscription> getAllSubscription();
    Collection<Subscription> getSubscriptionsByType(String type);
    Subscription getSubscriptionByTitle(String title);
    Collection<Subscription> getAllSubscriptionsOfCustomer(Integer cid);
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
