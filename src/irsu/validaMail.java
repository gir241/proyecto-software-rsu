/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package irsu;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
/**
 *
 * @author user
 */
  
 public class validaMail {
   public boolean isEmail(String correo) {
         // Establecer el patron
    Pattern p = Pattern.compile("[-\\w\\.]+@\\w+\\.\\w+");

    // Asociar el string al patron
    Matcher m = p.matcher(correo);

   // Comprobar si encaja
   return m.matches();
    }
    
    }