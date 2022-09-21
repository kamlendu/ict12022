/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import client.RestClient;
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
@Named(value = "resultBean")
@Dependent
public class ResultBean {
   RestClient client;
   Response rs;
   String hello;
   String greet;
   Collection<String> names;
   GenericType<Collection<String>> gnames;

    /**
     * Creates a new instance of ResultBean
     */
    public ResultBean() {
        client = new RestClient();
        names = new ArrayList<>();
        gnames = new GenericType<Collection<String>>(){};
    }

    public String getHello() {
        return client.sayHello("Rahul");
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    public String getGreet() {
        return client.sayGreeting("Sameer");
    }

    public void setGreet(String greet) {
        this.greet = greet;
    }

    public Collection<String> getNames() {
        
        Collection<String> temp = new ArrayList<>();
        temp.add("arvind");
        temp.add("ramesh");
        temp.add("rajesh");
        
        rs = client.unames(temp, Response.class);
        
        
        return rs.readEntity(gnames);
    }

    public void setNames(Collection<String> names) {
        this.names = names;
    }
    
    
    
}
