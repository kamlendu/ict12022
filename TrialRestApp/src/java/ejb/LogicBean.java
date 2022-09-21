/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.Stateless;


/**
 *
 * @author root
 */
@Stateless
public class LogicBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
public String sayHello(String pname) {
        //TODO return proper representation object
       // throw new UnsupportedOperationException();
       
       return "Hello World of Rest  " + pname + " !!";
    }

 public String sayGreeting( String pname) {
        //TODO return proper representation object
       // throw new UnsupportedOperationException();
       
       return "Welcome Mr.  " + pname + " to the occassion !!";
    }


  public Collection<String> unames(Collection<String> lnames)
    {
        Collection<String> uppers = new ArrayList<>();
        
        for(String str : lnames)
        {
            uppers.add(str.toUpperCase());
        }
        
        return uppers;
    }
 
}
