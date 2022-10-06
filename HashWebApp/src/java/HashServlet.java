/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;
import org.glassfish.soteria.identitystores.hash.PasswordHashCompare;


/**
 *
 * @author root
 */
@WebServlet(urlPatterns = {"/HashServlet"})
public class HashServlet extends HttpServlet {
 Pbkdf2PasswordHashImpl pb;
 PasswordHashCompare phc;
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
           
            pb = new Pbkdf2PasswordHashImpl();
            phc= new PasswordHashCompare();
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HashServlet</title>");            
            out.println("</head>");
            out.println("<body>");
         //   String test = "PBKDF2WithHmacSHA256:2048:uS4W774WdYj872LVuRSMujHdgqEVf7yPGZw6MGbgKI8=:VVT3CD1wfVvkQ7ct2eCNWUKr6GuMFztvJPOUgD1MybU=";
            String enc = pb.generate("xyzmnp".toCharArray());
            out.println("Hash = " +  enc);
          // out.println( "verify="+pb.verify("admin".toCharArray(), test));
        // out.println( "\njose header = "+  Base64.decode("eyJraWQiOiJWZjd2ZVdDMENFWldHdHBvc0czbXAxQzBNdWt3eXFRUXFOdGdTVVUySTFZIiwiYWxnIjoiUlMyNTYifQ.eyJ2ZXIiOjEsImp0aSI6IkFULk5MTnRPYUF1U1VBS0d4Z0pfc1gwZUhKUnpvZ3Q1RURvWWNqUDBnTThRQ1EiLCJpc3MiOiJodHRwczovL2Rldi05MjEwMzkub2t0YS5jb20vb2F1dGgyL2RlZmF1bHQiLCJhdWQiOiJhcGk6Ly9kZWZhdWx0IiwiaWF0IjoxNTgyMDk5MDQxLCJleHAiOjE1ODIxMDI2NDEsImNpZCI6IjBvYTJhdHlsN040OW5kWktDNHg2IiwidWlkIjoiMDB1MmF0eWV2Y3F2S0MwNXU0eDYiLCJzY3AiOlsiZW1haWwiLCJwcm9maWxlIiwib3BlbmlkIl0sInN1YiI6ImthbWxlbmR1cEBnbWFpbC5jb20ifQ.DQ2aMbMhEnPsmGHR_KTntV3mh8wNBDvYRZHmmEqyE8WEV4KwfM5lShsCtBPiV5UlW8xm7kDaFHLtxlzWJ1LFTzdeBc73Pr9Ps2mgbqt7ARUcpLWudCKlZYu08PlGY1qUx4XpPub5kYPJOcvHMIrzePpK93Vp22EdVSVWqr_bmRYD5bJQZOGNiA0wB44KflazxSYjH34hUoIvqzFw-y6_9cwemU_FcaVIjwRcQlf1iU9zOPaiYODHA16XjijzCIor1a3xY47qGrKREiEqsZQG3A3u0Kg0qow3GKc424ha_9DV1Tl79gr3F5HpvYZNjeGE5T_RYd_NhN7vbw-5T_ib4g"));
            
            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception e)
        {
            e.printStackTrace();
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
