/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import client.TrialClient;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author root
 */
@Named(value = "clientBean")
@Dependent
public class ClientBean {

    Collection<String> unames;
    GenericType<Collection<String>> gnames;
    TrialClient cl;
    Response rs;
    String hello;
    String greet;

    public Collection<String> getUnames() {
        Collection<String> temp = new ArrayList<>();
        temp.add("sita");temp.add("payal");temp.add("saina");
      rs = cl.unames(temp, Response.class);
      unames = rs.readEntity(gnames);
        
        return unames;
    }

    public void setUnames(Collection<String> unames) {
        this.unames = unames;
    }

    public String getHello() {
       hello = cl.sayHello("Kamlendu");
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    public String getGreet() {
       greet= cl.sayGreeting("Rohit");
        return greet;
    }

    public void setGreet(String greet) {
        this.greet = greet;
    }
    
    
    /**
     * Creates a new instance of ClientBean
     */
    public ClientBean() {
        
     unames = new ArrayList<>();
     gnames = new GenericType<Collection<String>>(){};
        cl = new TrialClient();
    }
    
}
