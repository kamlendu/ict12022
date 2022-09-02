/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;


//import com.sun.xml.ws.api.model.CheckedException;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.ScheduleExpression;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

/**
 *
 * @author root
 */
@Startup
@Singleton
@LocalBean
//@DependsOn({"SchedulerBean"})
public class TimerEJB  {
    
    @Resource TimerService ts;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
     @PostConstruct
    void setTimer()
    {
       try{ 
        // Single Action Timer
        
      //Timer atimer= ts.createTimer(10000, null); 
        
   //  Timer timer = ts.createSingleActionTimer(10000, new TimerConfig());

//  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//       Date date = sdf.parse("30/08/2022  12:10");
//         //System.out.println(date.toString());
//      Timer timer1 = ts.createSingleActionTimer(date, new TimerConfig());

  // Timer intervalTimer= ts.createTimer(5000, 3000, null);

       ScheduleExpression se = new ScheduleExpression();
       
       se.dayOfWeek("Tue");
       se.hour("0-17,23");
       se.minute(19);
       se.second("*/5");
      Timer scheduleTimer = ts.createCalendarTimer(se);
      }
       catch(Exception e) {
           e.printStackTrace();
           }
     
      // }
    }
    
    @Timeout
     public void speakonTimeout(){

        System.out.println("My Time expired at "+new Date().toString());
        return;
}
    public void hi(){ 
        return;
    }

}
