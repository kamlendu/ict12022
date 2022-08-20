/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import model.BookMaster1;

/**
 *
 * @author root
 */
@Stateless(mappedName = "ejb/master")
public class NewSessionBean implements NewSessionBeanRemote {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
Connection con;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
@PostConstruct
public void connect()
{
    try{
    Class.forName("com.mysql.jdbc.Driver");
    
    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false","root", "ompandey");
    
    }
    catch(ClassNotFoundException | SQLException e)
    {
        e.printStackTrace();
    }
}

    @Override
    public Collection<BookMaster1> getAllBooks() {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    Collection<BookMaster1> books;
    books = new ArrayList<>();
       try{
       Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from BookMaster");
      
      while(rs.next())
      {
          System.out.println("name="+ rs.getString(1));
          BookMaster1 b = new BookMaster1(rs.getInt("BookID"),rs.getString("BookName"),rs.getString("AuthorName"), rs.getString("PublisherName"), rs.getString("Synopsis"));
          books.add(b);
      }
      
    
    }
       catch(SQLException e)
       {
           e.printStackTrace();
       }
      
       return books;

}
}