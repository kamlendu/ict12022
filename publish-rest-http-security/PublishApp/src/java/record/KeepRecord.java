/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package record;

import java.io.Serializable;
import java.util.Set;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.security.enterprise.CallerPrincipal;

/**
 *
 * @author root
 */
@Named
@SessionScoped
public class KeepRecord implements Serializable {
    
    private static CallerPrincipal principal;
   private static Set<String> roles;

    public static CallerPrincipal getPrincipal() {
        return principal;
    }

    public static void setPrincipal(CallerPrincipal principal) {
        KeepRecord.principal = principal;
    }

    public static Set<String> getRoles() {
        return roles;
    }

    public static void setRoles(Set<String> roles) {
        KeepRecord.roles = roles;
    }
   
    
    
    
}
