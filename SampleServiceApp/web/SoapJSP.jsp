<%-- 
    Document   : SoapJSP
    Created on : 13 Sep. 2022, 12:22:14 pm
    Author     : root
--%>

<%@page contentType="text/html" import="client.*, javax.xml.ws.Service" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%!
           //@WebServiceRef(wsdlLocation = "http://localhost:8080/SampleServiceApp/Hello?WSDL")
           // Hello_Service hello;
            Hello port;
            
            %>
            <%
                //URL url = new URL("http://localhost:8080/SampleServiceApp/Hello?WSDL");
            Hello_Service hello = new Hello_Service();
                port = hello.getHelloPort();



                %>
            
        
                <h1>Web Service Says <%=port.sayhello("Madhav")%></h1>
    </body>
</html>
