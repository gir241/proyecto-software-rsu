/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package irsu;
import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 *
 * @author joel
 */
public class Fecha {
    
    public  static String fechaActual(){
    
        
        
        
      GregorianCalendar cal = new GregorianCalendar();
      String fecha=Integer.toString(cal.get(Calendar.DATE))+"/"+Integer.toString(cal.get(Calendar.MONTH))+"/"+Integer.toString(cal.get(Calendar.YEAR));
      return fecha;
   //Calendar cal=Calendar.getInstance();
       // String fecha=(cal.get(cal.DATE)+"/"+cal.get(cal.MONTH)+"/"+cal.get(cal.YEAR)); 
        //return fecha;
        
    }
    
}
