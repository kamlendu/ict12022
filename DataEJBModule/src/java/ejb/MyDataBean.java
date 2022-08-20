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
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import model.BookMaster;

/**
 *
 * @author root
 */
@Stateless(mappedName = "ejb/books")
public class MyDataBean implements MyDataBeanRemote {
    
    Connection con;

    @PostConstruct
    public void InitializeConnection()
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
    public Collection<BookMaster> getAllBooks() {
        
        Collection<BookMaster> books = new ArrayList<>();
        try {
            // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            Statement stmt = con.createStatement();
            
            ResultSet rs = stmt.executeQuery("select * from BookMaster");
            
            while(rs.next())
            {
                BookMaster bm = new BookMaster(rs.getInt("BookID"), rs.getString("BookName"), rs.getString("AuthorName"), rs.getString("PublisherName"), rs.getString("Synopsis"));
            
                books.add(bm);
            }
            
            
            
        } catch (SQLException ex) {
          //  Logger.getLogger(MyDataBean.class.getName()).log(Level.SEVERE, null, ex);
        ex.printStackTrace();
        }
        con.close();
    return books;
    
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
@PreDestroy
public void cleanUp()
{
    con.close();
}




}
