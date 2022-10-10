/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auth;

import java.io.Serializable;
import java.util.Set;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationException;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.CallerPrincipal;
import javax.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
import javax.security.enterprise.authentication.mechanism.http.HttpMessageContext;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
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
public class CustomAuthentication implements HttpAuthenticationMechanism,Serializable {

    private static long SerialVersionUID = 1L;
    
    @Inject private IdentityStoreHandler handler;
    private CredentialValidationResult result;
    private AuthenticationStatus status;
   
    @Override
    public AuthenticationStatus validateRequest(HttpServletRequest request, HttpServletResponse response, HttpMessageContext httpMessageContext) throws AuthenticationException {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    try{
      //  System.out.println("In Auth");
        
        if(request.getParameter("username")!=null)
        {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            Credential credential = new UsernamePasswordCredential(username, new Password(password));
            result = handler.validate(credential);
            if(result.getStatus()== CredentialValidationResult.Status.VALID)
            {
               // System.out.println("User Name : "+username + "Password : "+ password);
                // System.out.println("Group : "+ result.getCallerGroups().toString());
                
                request.getSession().setAttribute("username", username);
                request.getSession().setAttribute("password", password);
                request.getSession().setAttribute("principal", result.getCallerPrincipal());
                request.getSession().setAttribute("groups", result.getCallerGroups());
                      
                status = httpMessageContext.notifyContainerAboutLogin(result.getCallerPrincipal(), result.getCallerGroups());
             KeepRecord.setPrincipal(result.getCallerPrincipal());
              KeepRecord.setRoles(result.getCallerGroups());
                if(request.getRequestURI().contains("index.jsp"))
                {
                    if(result.getCallerGroups().contains("Admin"))
                    {
                       request.getServletContext().getRequestDispatcher("/admin.jsp").forward(request, response);
                       return status;
                    }
                    else if(result.getCallerGroups().contains("Supervisor"))
                    {
                            request.getServletContext().getRequestDispatcher("/users.jsp").forward(request, response);
                      return status;
                    }
                }
            
            }
            else
            {
                request.setAttribute("error", "Username or Password may be wrong !!!");
                 return httpMessageContext.doNothing();
            }
       
        

        }
     if(KeepRecord.getPrincipal()!=null)
     {
        httpMessageContext.notifyContainerAboutLogin(KeepRecord.getPrincipal(), KeepRecord.getRoles());
     }
    }
    catch(Exception e)
    {
       e.printStackTrace();
    }
    
    
    return httpMessageContext.doNothing();
    }
    



}
