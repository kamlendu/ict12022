/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionRemote.java to edit this template
 */
package ejb;

import javax.ejb.Remote;

/**
 *
 * @author root
 */
@Remote
public interface MathBeanRemote {
    
    int sum(int x, int y);
    
}
