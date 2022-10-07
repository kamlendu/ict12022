/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationException;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.authentication.mechanism.http.HttpMessageContext;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.CredentialValidationResult.Status;
import javax.security.enterprise.identitystore.IdentityStoreHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import record.KeepRecord;

/**
 *
 * @author root
 */
@Named
@RequestScoped
public class SecureAuthentication implements HttpAuthenticationMechanism, Serializable {
@Inject IdentityStoreHandler handler;
private CredentialValidationResult result;
private AuthenticationStatus status;
     
    @Override
    public AuthenticationStatus validateRequest(HttpServletRequest request, HttpServletResponse response, HttpMessageContext ctx) throws AuthenticationException {
     //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    try{
         if(request.getRequestURI().contains("logout"))
        {
            request.logout();
            KeepRecord.reset();
//            KeepRecord.setPrincipal(null);
//            KeepRecord.setRoles(null);
            response.sendRedirect("index.jsp");
            return ctx.doNothing();
        }
        
        
         if(request.getRequestURI().contains("index.jsp"))
        {
     if(request.getParameter("username") !=null)
     {
         String username = request.getParameter("username");
         String password = request.getParameter("password");
         
         Credential credential = new UsernamePasswordCredential(username, new Password(password));
         result = handler.validate(credential);
         if(result.getStatus()== Status.VALID)
         {
          status=   ctx.notifyContainerAboutLogin(result);
             request.setAttribute("user", username);
             KeepRecord.setPrincipal(result.getCallerPrincipal());
             KeepRecord.setRoles(result.getCallerGroups());
          
             
             
             if(result.getCallerGroups().contains("Admin"))
             {
                  request.getRequestDispatcher("/admin/admin.jsp").forward(request, response);
                  return status;
             }
             
             else  if(result.getCallerGroups().contains("Supervisor"))
             {
                     request.getRequestDispatcher("/user/users.jsp").forward(request, response);
                  return status;
             }
             
            
             
             
             
         }
         else
         {
             request.setAttribute("error", "Username or Password may be wrong !!!");
             request.getRequestDispatcher("/index.jsp").forward(request, response);
             return ctx.doNothing();
         }
         
         
         
         
         
     }
    }
        
        if(KeepRecord.getPrincipal()!=null)
        {
            
           status= ctx.notifyContainerAboutLogin(KeepRecord.getPrincipal(), KeepRecord.getRoles());
           
           if(request.getRequestURI().contains("admin") && KeepRecord.getRoles().contains("Supervisor"))
           ctx.responseUnauthorized();
            if(request.getRequestURI().contains("user") && KeepRecord.getRoles().contains("Admin"))
           ctx.responseUnauthorized();
               
           return status;
        }
        
        
    }
    catch(Exception e)
    {
        ctx.doNothing();
    }
    
    return ctx.doNothing();
    }
    
}
