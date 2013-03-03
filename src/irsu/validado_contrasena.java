/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package irsu;

/**
 *
 * @author MarcoAntonio
 */
public class validado_contrasena {
    
    public boolean ctr (String a, String b)
    {
      if (a.equals(b)&& !b.equals("") && !a.equals(""))
          return true;
      else 
          return false;
    }
}
