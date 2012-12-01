/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package irsu;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;

/**
 *
 * @author joel
 */
public class Fecha {
    
    public  static String fechaActual(){
 
      Calendar c1 = GregorianCalendar.getInstance();
      SimpleDateFormat fechas = new SimpleDateFormat("dd/MM/yyyy");  
      String fecha= (fechas.format(c1.getTime()));
      return fecha;   
    }
}
