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
         ("jdbc:mysql://localhost/","root","inforsu");
      try{
        Statement st = con.createStatement();
        st.executeUpdate("CREATE DATABASE rsu_inventario");
        JOptionPane.showMessageDialog(null,"Base De Datos Creada Exitosamente", 
                "alert", JOptionPane.OK_OPTION);
         }  
      catch (SQLException s){
        SQL_FORM error = new SQL_FORM();
      JOptionPane.showMessageDialog(error,s, "alert", JOptionPane.ERROR_MESSAGE);
    }
  }
        catch (Exception e){
        e.printStackTrace();
    }
   }
}