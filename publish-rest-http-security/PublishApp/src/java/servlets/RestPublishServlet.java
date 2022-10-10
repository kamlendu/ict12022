/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import client.PublishClient;
import entity.Address;
import entity.Customer;
import entity.Subscription;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author root
 */
@WebServlet(name = "RestPublishServlet", urlPatterns = {"/RestPublishServlet"})
public class RestPublishServlet extends HttpServlet {
    
    PublishClient pbl;
    Response res;
    Collection<Customer> customers;
    GenericType<Collection<Customer>> gcustomers;
    Collection<Address> addresses;
    GenericType<Collection<Address>> gaddresses;
    Collection<Subscription> subs;
    GenericType<Collection<Subscription>> gsubs;
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RestPublishServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            String username = request.getSession().getAttribute("username").toString();
            String password = request.getSession().getAttribute("password").toString();
            
            
            pbl = new PublishClient();
            customers = new ArrayList<Customer>();
            addresses  = new ArrayList<Address>();
            subs = new ArrayList<Subscription>();
            
            gcustomers = new GenericType<Collection<Customer>>(){};
            gaddresses =  new GenericType<Collection<Address>>(){};
            gsubs =  new GenericType<Collection<Subscription>>(){};
            
            
             // pbl.removeCustomer(24);
          //  pbl.addCustomer("Sudha", "Mishra");
          //pbl.addAddressToCustomer("S-143", "Bikaner", "Rajasthan", "345212", "27");
          //pbl.addAddressToCustomer("Marshal street", "Indore", "Madhya Pradesh", "512321", "27");
          //pbl.removeAddressToCustomers("27", "33");
          //pbl.removeAddressToCustomers("27","34");
          
          //  pbl.removeAddressToCustomers(24, 25);
          Collection<Integer> ids = new ArrayList<Integer>();
            ids.add(3); ids.add(4); ids.add(5);
          
        // pbl.addSubscriptionsToCustomer(ids, "27");
            
          // pbl.removeSubscriptionsToCustomer(ids, "27");
            
            
            res = pbl.getAllCustomers(Response.class);
            
            
            
            out.println("<h3>");
            
            customers = res.readEntity(gcustomers);
            
            for(Customer c : customers )
            {
               out.println("Cust Id : "+ c.getCustomerID() +" Name : "+ c.getFirstName()+" "+ c.getLastName());
            
              
               res = pbl.getAddressOfCustomer(Response.class, c.getCustomerID().toString());
               addresses = res.readEntity(gaddresses);
               
               for(Address a : addresses)
                {
                   out.println("<br/>Address Id : "+ a.getAddressId() +" City : "+ a.getCity()+" State "+ a.getState()+ " Zip : "+ a.getZip());
             
                }
                 res = pbl.getSubscriptionsofCustomer(Response.class, c.getCustomerID().toString());
                subs =  res.readEntity(gsubs);
            
                for(Subscription s : subs)
                {
                     out.println("<br/>Sub Id : "+ s.getSubscriptionId() +" Title : "+ s.getTitle()+" Type : "+ s.getType());
            
               
                }
            
             out.println("<hr/>");
            
            }
            
            out.println("</h3>");
            
            
            

            out.println("<h1>Servlet RestPublishServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
