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
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface PublishBeanLocal {
    
    void addCustomer(String firstName, String lastName);
    void updateCustomer(Integer custId, String firstName, String lastName);
    void removeCustomer(Integer custId);
    Collection<Customer> getAllCustomers();
    Collection<Customer> getCustomersByFirstName(String fname);
    Collection<Customer> getCustomersByLastName(String lname);
    Customer findCustomerById(Integer custId);
    
    void addAddressToCustomer(String street, String city, String state, String zip, Integer custId);
    void removeAddressToCustomers(Integer custId, Integer addressId);
    Collection<Address> getAddressOfCustomer(Integer custId);
    Collection<Address> getAddressesByCity(String city);
    Collection<Address> getAddressesByZip(String zip);
    
    void addSubscription(String title, String type);
    void updateSubscription(Integer subId, String title, String type);
    void removeSubscription (Integer subId);
    Collection<Subscription> getSubscriptionsByType(String type);
    Collection<Subscription> getSubscriptionsofCustomer(Integer custId);
    
    void addSubscriptionsToCustomer(Integer custId, Collection<Integer> subIds);
    void removeSubscriptionsToCustomer(Integer custId, Collection<Integer> subIds);
    
    
    
    
    
    
    
    
    
    
}
