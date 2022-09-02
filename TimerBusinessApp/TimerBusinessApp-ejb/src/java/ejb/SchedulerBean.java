package ejb;


import java.util.Date;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TimerService;

/**
 *
 * @author root
 */
//@Startup
@Singleton
@LocalBean
public class SchedulerBean {
    @Resource TimerService ts;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
@PostConstruct
void initialize()
    {
   System.out.println("executing on my schedule "+ new Date());
    }
public void hi()
    {
    // System.out.println("executing on my schedule "+ new Date());
    return;
    }

@Schedule(dayOfWeek="*",month="*",year="*", hour="0-23", minute="43", second="*/5")
void speakOnSchedule()
    {
    System.out.println("executing on my schedule "+ new Date());
    }
}


