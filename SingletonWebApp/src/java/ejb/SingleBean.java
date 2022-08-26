/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB31/SingletonEjbClass.java to edit this template
 */
package ejb;

import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.AccessTimeout;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.DependsOn;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 *
 * @author root
 */

@TransactionManagement(TransactionManagementType.BEAN)
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
@AccessTimeout(value = 20, unit = TimeUnit.SECONDS)
@Startup
@Singleton
@DependsOn({"FirstBean","SecondBean"})
public class SingleBean {
    
    @Resource UserTransaction utx;

    String firstName;
    String lastName;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
@PostConstruct
public void initialize()
{
    firstName="M.Sc.";
    lastName= "ICT";
  System.out.println("Singleton Bean is initialized in "+ firstName+" "+lastName);  
}

@Lock(LockType.READ)
    public String getFirstName() {
        return firstName;
    }
    
@Lock(LockType.WRITE)
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
@Lock(LockType.READ)
    public String getLastName() {
        return lastName;
    }
    
@Lock(LockType.WRITE)
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getFullName()
    {
        String fullname="";
        try{
            
            utx.begin();
            
            fullname = firstName + " " + lastName;
            
            utx.commit();
        }
        catch(IllegalStateException | SecurityException | HeuristicMixedException | HeuristicRollbackException | NotSupportedException | RollbackException | SystemException ex)
        {
            
            try{
                
                utx.rollback();
                
            }
            catch(IllegalStateException | SecurityException | SystemException e)
            {
                
            }
            
        }
        
    
    return fullname;
    }

}
