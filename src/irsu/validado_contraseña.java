/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package irsu;

/**
 *
 * @author MarcoAntonio
 */
public class validado_contraseña {
    
    public boolean ctr (String a, String b)
    {
      if (a.equals(b)|| !a.equals("")|| !b.equals("")) 
          return false;
      else 
          return true;
    }
}
