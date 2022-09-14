/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import client.PublishBean;
import client.PublishBeanService;
import client.Address;
import client.Customer;
import client.Subscription;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author root
 */
@WebServlet(name = "PublishServlet", urlPatterns = {"/PublishServlet"})
public class PublishServlet extends HttpServlet {
    
   // @EJB PublishBeanLocal pbl;
    
    @WebServiceRef(wsdlLocation = "http://localhost:8080/PublishBeanService/PublishBean?WSDL")
    PublishBeanService ps;
    PublishBean pbl;

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PublishServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            pbl = ps.getPublishBeanPort();
            
          //  pbl.addCustomer("Arvind", "Patel");
//           pbl.addAddressOfCustomer("Downing 1", "Bhopal", "MP", "521341", 24);
//           pbl.addAddressOfCustomer("L-23", "Surat", "Gujarat", "342121", 24);
//          
          Collection<Integer> ids = new ArrayList<>();
          ids.add(4); ids.add(5);
          
        //  pbl.addSubscriptionsToCustomers(24,(List) ids);
       //  pbl.removeSubscriptionsToCustomers(24,(List) ids);
//          pbl.removeAddressOfCustomer(27, 24);
//          pbl.removeAddressOfCustomer(28, 24);
//           pbl.removeAddressOfCustomer(29, 24);
//            pbl.removeAddressOfCustomer(30, 24);
//             pbl.removeAddressOfCustomer(31, 24);
//              pbl.removeAddressOfCustomer(32, 24);
           //pbl.removeCustomer(24);
            Collection<Customer> custs = pbl.getAllCustomers();
            for(Customer c : custs)
            {
               out.println("cid = "+ c.getCustomerID()+" "+ c.getFirstName()+ "  "+ c.getLastName());
               
               Collection<Address> addresses = pbl.getAddressesOfCustomer(c.getCustomerID());
               
               for(Address a : addresses)
               {
                   out.println("<br/> aid = "+ a.getAddressId()+ " Street = "+ a.getStreet()+ " City = "+ a.getCity()+ " state = "+ a.getState());
               }
                 List<Subscription> subs =  pbl.getAllSubscriptionsOfCustomer(c.getCustomerID());
                
                 for(Subscription s : subs)
                 {
                    out.println("<br/> sid = "+ s.getSubscriptionId()+ " Title = "+ s.getType()+ " type= "+ s.getType());
                 }
                
                 out.println("<hr/>");
            }
            
            
            
            
            
            
            out.println("<h1>Servlet PublishServlet at " + request.getContextPath() + "</h1>");
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
