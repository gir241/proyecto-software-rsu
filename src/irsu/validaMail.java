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
    public void validar(String dato){
        Pattern pat = Pattern.compile("^[a-zA-Z0-9]*[._-w]{2,}@[a-zA-Z0-9_-]{2,}\\.[a-zA-Z]{2,4}(\\.[a-zA-Z]{2,4})?$");
        Matcher mat = pat.matcher(dato);
        if(mat.find()){
            
        }else{
            JOptionPane.showMessageDialog(null, "Correo invalido");
        }
    }
    
    }