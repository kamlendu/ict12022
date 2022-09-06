/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.BookMaster;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class DataLogic implements DataLogicLocal {
    
    @PersistenceContext(unitName = "JPAPU")
    EntityManager em;

    @Override
    public Collection<BookMaster> getAllBooks() {
     //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    Collection<BookMaster> books = em.createNamedQuery("BookMaster.findAll").getResultList();
    return books;
    
    }

    @Override
    public void addNewBook(String bookName, String authorName, String publisherName, String synopsis) {
        BookMaster bm = new BookMaster();
        bm.setBookName(bookName);
        bm.setAuthorName(authorName);
        bm.setPublisherName(publisherName);
        bm.setSynopsis(synopsis);
        
        em.persist(bm);
        
    
    
    }

    @Override
    public void updateBook(Integer bookId, String bookName, String authorName, String publisherName, String synopsis) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
      BookMaster bm = (BookMaster) em.find(BookMaster.class, bookId);
       bm.setBookName(bookName);
        bm.setAuthorName(authorName);
        bm.setPublisherName(publisherName);
        bm.setSynopsis(synopsis);
        
        em.merge(bm);
      
    
    }

    @Override
    public void removeBook(Integer bookId) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    BookMaster bm = (BookMaster) em.find(BookMaster.class, bookId);
    
    em.remove(bm);
    
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")


}
