/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package asynch;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author root
 */
@Stateless
@LocalBean
public class SynchBean {
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
 public int compute()
{

    try{
    goLoopA();
    goLoopB();
    }
    catch(InterruptedException e){

    }
return 0;
}

   void goLoopA() throws InterruptedException
{
   for(int i=0; i<100;i++){
      Thread.sleep(1000);
       System.out.println("i= "+i);
   }
}
 void goLoopB() throws InterruptedException
{
   for(int j=0; j<100;j++){
       Thread.sleep(1000);
       System.out.println("j= "+j);
   }
}
}
