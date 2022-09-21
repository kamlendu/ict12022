/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionRemote.java to edit this template
 */
package ejb;

import java.util.Collection;
import javax.ejb.Remote;
import model.BookMaster1;

/**
 *
 * @author root
 */
@Remote
public interface NewSessionBeanRemote {
    Collection<BookMaster1> getAllBooks();
}
