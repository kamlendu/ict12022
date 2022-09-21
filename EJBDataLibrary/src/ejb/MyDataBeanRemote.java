/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionRemote.java to edit this template
 */
package ejb;

import java.util.Collection;
import javax.ejb.Remote;
import model.BookMaster;

/**
 *
 * @author root
 */
@Remote
public interface MyDataBeanRemote {
    
    Collection<BookMaster> getAllBooks();
    
}
