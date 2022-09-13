/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package service;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author root
 */
@WebService(serviceName = "Hello")
public class Hello {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "sayhello")
    public String Sayhello(@WebParam(name = "name") String txt) {
        return "Hello world of SOAP Services to " + txt + " !";
    }
    
    
    
    
}
