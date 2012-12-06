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
      JOptionPane.showMessageDialog(error,"error");

        //SQL_FORM error = new SQL_FORM();
      JOptionPane.showMessageDialog(error,s, "alert", JOptionPane.ERROR_MESSAGE);

    }
  }
        catch (Exception e){
        e.printStackTrace();
    }
   }

  public void CrearTablas(){
    Connection con = null;
    try{
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         con = DriverManager.getConnection
         ("jdbc:mysql://localhost/rsu_inventario","root","inforsu");
      try{
        Statement st = con.createStatement();
        st.executeUpdate("CREATE TABLE USUARIO (run_usuario VARCHAR(20) NOT NULL PRIMARY KEY, nombre VARCHAR(45)," +
          "apellido VARCHAR(45),actividad varchar(20),comuna varchar(30),carrera varchar(10) ,"+
          "telefono varchar(15),celular varchar(20),direccion VARCHAR(45),email varchar(50));");
        
         st.executeUpdate("CREATE TABLE ADMIN (run_admin VARCHAR(20) NOT NULL PRIMARY KEY, nombre VARCHAR(45)," +
          "apellido VARCHAR(45),actividad varchar(20),comuna varchar(30),carrera varchar(10) ,"+
          "telefono varchar(15),celular varchar(20),direccion VARCHAR(45),email varchar(50),contraseña varchar(50));");
        
        st.executeUpdate("CREATE TABLE ARTICULO (codigo VARCHAR(40) NOT NULL PRIMARY KEY, categoria VARCHAR(45)," +
          "producto VARCHAR(50), descripcion varchar(50),estado VARCHAR(2));");
        
        st.executeUpdate("CREATE TABLE PEDIDO (id_pedido VARCHAR(40) NOT NULL PRIMARY KEY,id_producto VARCHAR(40)"+
                "NOT NULL REFERENCES ARTICULO (codigo)  ON DELETE CASCADE ON UPDATE CASCADE," +
          "apellido VARCHAR(45), telefono VARCHAR(15),direccion VARCHAR(50), estado VARCHAR(10));");
        
        
  
        JOptionPane.showMessageDialog(null,"tablas Creadas Exitosamente", 
                "alert", JOptionPane.OK_OPTION);
         }  
      catch (SQLException s){

          SQL_FORM error = new SQL_FORM();
      JOptionPane.showMessageDialog(error,"error al crear tablas");

        //SQL_FORM error = new SQL_FORM();
      JOptionPane.showMessageDialog(error,s, "alert", JOptionPane.ERROR_MESSAGE);

    }
  }
        catch (Exception e){
        e.printStackTrace();
    }
  
  }

  //EJEMPLO NO USAR
  public void Agregar_datos(){
    Connection con = null;
    try{
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         con = DriverManager.getConnection
         ("jdbc:mysql://localhost/rsu_inventario","root","inforsu");
      try{
        Statement st = con.createStatement();
        st.executeUpdate("INSERT INTO ADMIN VALUES ('174183767','marco','molina','estudiante','santiago',"+
                "'2130','3030303','30303030','los valdios 1030','marcotutu@hotmail.com',contraseña);");
        
         
        JOptionPane.showMessageDialog(null,"Datos agregados Exitosamente", 
                "alert", JOptionPane.OK_OPTION);
         }  
      catch (SQLException s){

          SQL_FORM error = new SQL_FORM();
      JOptionPane.showMessageDialog(error,"error al ingresar datos");

        //SQL_FORM error = new SQL_FORM();
      JOptionPane.showMessageDialog(error,s, "alert", JOptionPane.ERROR_MESSAGE);

    }
  }
        catch (Exception e){
        e.printStackTrace();
    }
  }
//EJEMPLO NO USAR
    public void Eliminar_datos(){
    Connection con = null;
    try{
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         con = DriverManager.getConnection
         ("jdbc:mysql://localhost/rsu_inventario","root","inforsu");
      try{
        Statement st = con.createStatement();
        st.executeUpdate("DELETE FROM ADMIN WHERE nombre = 'marco';");
        
         
        JOptionPane.showMessageDialog(null,"Datos eliminados Exitosamente", 
                "alert", JOptionPane.OK_OPTION);
         }  
      catch (SQLException s){

          SQL_FORM error = new SQL_FORM();
      JOptionPane.showMessageDialog(error,"error al eliminar datos");

        //SQL_FORM error = new SQL_FORM();
      JOptionPane.showMessageDialog(error,s, "alert", JOptionPane.ERROR_MESSAGE);

    }
  }
        catch (Exception e){
        e.printStackTrace();
    }
  }
}
    
    


/*
 *
 * 
 * @author Gonzalo Pradena
*/

    

