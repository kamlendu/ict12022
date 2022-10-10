/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package record;

import java.util.Set;
import javax.security.enterprise.CallerPrincipal;

/**
 *
 * @author root
 */
public class KeepRecord {
    
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
