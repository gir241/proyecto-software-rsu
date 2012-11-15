/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package irsu;
import java.sql.*;



/**
 *
 * @author Gonzalo Pradena
 */
public class SQL {
    
  public  void Coneccion()
          {
    try
        {
            // Se registra el Driver de MySQL
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            
            // Se obtiene una conexión con la base de datos. Hay que
            // cambiar el usuario "root" y la clave "la_clave" por las
            // adecuadas a la base de datos que estemos usando.
            Connection conexion = DriverManager.getConnection (
                "jdbc:mysql://localhost/prueba","rsu", "inforsu");
            
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();
      /*      
            // Se realiza la consulta. Los resultados se guardan en el 
            // ResultSet rs
            ResultSet rs = s.executeQuery ("select * from persona");
            
            // Se recorre el ResultSet, mostrando por pantalla los resultados.
            while (rs.next())
            {
                System.out.println (rs.getInt ("Id") + " " + rs.getString (2)+ 
                    " " + rs.getDate(3));
            }
     */
            // Se cierra la conexión con la base de datos.
            conexion.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
}
  
    
}

