package irsu;

import java.sql.*;
import java.io.*;
import javax.swing.JOptionPane;


public class SQL{
    
  public void CrearBDD(){  
      Connection con = null;
    try{
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         con = DriverManager.getConnection
         ("jdbc:mysql://localhost/rsu","rsu","rsu");
      try{
        Statement st = con.createStatement();
        st.executeUpdate("CREATE DATABASE rsu_inventario");
        JOptionPane.showMessageDialog(null,"Base De Datos Creada Exitosamente", 
                "alert", JOptionPane.OK_OPTION);
         }  
      catch (SQLException s){
<<<<<<< HEAD
          SQL_FORM error = new SQL_FORM();
      JOptionPane.showMessageDialog(error,"error");
=======
        SQL_FORM error = new SQL_FORM();
      JOptionPane.showMessageDialog(error,s, "alert", JOptionPane.ERROR_MESSAGE);
>>>>>>> b90528065a5a813318bc8b8c03268ec8a0f7b54e
    }
  }
        catch (Exception e){
        e.printStackTrace();
    }
   }
<<<<<<< HEAD
  
 
  
  
  
  
  }



/**
 *
 * @author Gonzalo Pradena


}
    



















/*      
    
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
            
            // Se realiza la consulta. Los resultados se guardan en el 
            // ResultSet rs
            ResultSet rs = s.executeQuery ("select * from persona");
            
            // Se recorre el ResultSet, mostrando por pantalla los resultados.
            while (rs.next())
            {
                System.out.println (rs.getInt ("Id") + " " + rs.getString (2)+ 
                    " " + rs.getDate(3));
            }
     
            // Se cierra la conexión con la base de datos.
            conexion.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
}
  */
=======
}
>>>>>>> b90528065a5a813318bc8b8c03268ec8a0f7b54e
