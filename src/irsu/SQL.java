package irsu;

import java.sql.*;
import java.io.*;
import javax.swing.JOptionPane;


public class SQL{
   
    private String pass = "inforsu";
   
  public void CrearBDD(){  
      Connection con = null;
      ResultSet rs = null;
      Statement st = null;
      String valida = "SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = 'rsu_inventario'";
    try{
         Class.forName("com.mysql.jdbc.Driver").newInstance();
       
         con = DriverManager.getConnection
         ("jdbc:mysql://localhost/","root",pass);
      try{
        st = con.createStatement();
        rs = st.executeQuery(valida);
       // CARGA INFORMACION SI BASE DE DATOS EXSITE 
      if(!rs.next()){  
        
        st.executeUpdate("CREATE DATABASE rsu_inventario");
        JOptionPane.showMessageDialog(null,"Base De Datos Creada Exitosamente", 
                "alert", JOptionPane.OK_OPTION);
           // CARGA INFORMACION A LA BASE DE DATOS
         CrearTablas();
         CrearTrashTablas();
         carga_default();
         }  
   
      }
      catch (SQLException s){

          SQL_FORM error = new SQL_FORM();
      JOptionPane.showMessageDialog(error,"error");

        //SQL_FORM error = new SQL_FORM();
      JOptionPane.showMessageDialog(error,s, "alert", JOptionPane.ERROR_MESSAGE);

    }
      finally{
          rs.close();
          con.close();
          st.close();
      }
  }
        catch (Exception e){
        e.printStackTrace();
    }
   }

  public void CrearTablas(){
    Connection con = null;
    Statement st = null;
    String USER = "CREATE TABLE USUARIO (run_usuario VARCHAR(20) NOT NULL PRIMARY KEY, nombre VARCHAR(45)," +
          "apellido VARCHAR(45),actividad varchar(20),comuna varchar(30),carrera varchar(10) ,"+
          "telefono varchar(15),celular varchar(20),direccion VARCHAR(45),email varchar(50));";
    
    String ADMIN = "CREATE TABLE ADMIN (run_admin VARCHAR(20) NOT NULL PRIMARY KEY, nombre VARCHAR(45)," +
          "apellido VARCHAR(45),actividad varchar(20),comuna varchar(30),carrera varchar(10) ,"+
          "telefono varchar(15),celular varchar(20),direccion VARCHAR(45),email varchar(50),contraseña varchar(50));";
    
    String ARTICULO = "CREATE TABLE ARTICULO (codigo VARCHAR(40) NOT NULL PRIMARY KEY, categoria VARCHAR(45)," +
          "producto VARCHAR(50), descripcion varchar(50),estado VARCHAR(12));";
    
    String PEDIDO = "CREATE TABLE PEDIDO (id_pedido VARCHAR(40) NOT NULL PRIMARY KEY,"
            + "id_producto VARCHAR(20),id_usuario varchar (20), "
            + "FOREIGN KEY (id_producto) REFERENCES ARTICULO(codigo)," 
            +  "FOREIGN KEY(id_usuario) REFERENCES USUARIO(run_usuario)"
        + ",fecha_pedido varchar(15) ,fecha_entrega varchar(15));";
    try{
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         con = DriverManager.getConnection
         ("jdbc:mysql://localhost/rsu_inventario","root",pass);
      try{
        st = con.createStatement();
        st.executeUpdate(USER);
        
         st.executeUpdate(ADMIN);
        
        st.executeUpdate(ARTICULO);
        
        st.executeUpdate(PEDIDO);
        
        
        JOptionPane.showMessageDialog(null,"tablas Creadas Exitosamente", 
                "alert", JOptionPane.OK_OPTION);
         }  
      catch (SQLException s){

          SQL_FORM error = new SQL_FORM();
      JOptionPane.showMessageDialog(error,"error al crear tablas");

        //SQL_FORM error = new SQL_FORM();
      JOptionPane.showMessageDialog(error,s, "alert", JOptionPane.ERROR_MESSAGE);

    }
       finally{
          con.close();
          st.close();
         
      }
  }
        catch (Exception e){
        e.printStackTrace();
    }
  
  }
  
  public void CrearTrashTablas(){
    Connection con = null;
    Statement st = null;
    String USER = "CREATE TABLE Trash_USUARIO (run_usuario VARCHAR(20) NOT NULL PRIMARY KEY, nombre VARCHAR(45)," +
          "apellido VARCHAR(45),actividad varchar(20),comuna varchar(30),carrera varchar(10) ,"+
          "telefono varchar(15),celular varchar(20),direccion VARCHAR(45),email varchar(50));";
    
    String ADMIN = "CREATE TABLE Trash_ADMIN (run_admin VARCHAR(20) NOT NULL PRIMARY KEY, nombre VARCHAR(45)," +
          "apellido VARCHAR(45),actividad varchar(20),comuna varchar(30),carrera varchar(10) ,"+
          "telefono varchar(15),celular varchar(20),direccion VARCHAR(45),email varchar(50),contraseña varchar(50));";
    
    String ARTICULO = "CREATE TABLE Trash_ARTICULO (codigo VARCHAR(40) NOT NULL PRIMARY KEY, categoria VARCHAR(45)," +
          "producto VARCHAR(50), descripcion varchar(50),estado VARCHAR(12));";
    
    try{
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         con = DriverManager.getConnection
         ("jdbc:mysql://localhost/rsu_inventario","root",pass);
      try{
        st = con.createStatement();
        st.executeUpdate(USER);
        
         st.executeUpdate(ADMIN);
        
        st.executeUpdate(ARTICULO);                
        
        JOptionPane.showMessageDialog(null,"tablas Creadas Tablas Trash Exitosamente", 
                "alert", JOptionPane.OK_OPTION);
         }  
      catch (SQLException s){

          SQL_FORM error = new SQL_FORM();
      JOptionPane.showMessageDialog(error,"error al crear tablas");

        //SQL_FORM error = new SQL_FORM();
      JOptionPane.showMessageDialog(error,s, "alert", JOptionPane.ERROR_MESSAGE);

    }
      finally{
          con.close();
          st.close();
         
      }
      
  }
        catch (Exception e){
        e.printStackTrace();
    }
  
  }
     
    public void carga_default(){
    
        Connection con = null;
        Statement st = null;
    try{
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         con = DriverManager.getConnection
         ("jdbc:mysql://localhost/rsu_inventario","root",pass);
      try{
         st = con.createStatement();
         st.executeUpdate("INSERT INTO ADMIN VALUES ('174183767','marco','molina','estudiante','santiago',"+
                "'2130','3030303','30303030','los valdios 1030','marcotutu@hotmail.com',12345);");
         st.executeUpdate("INSERT INTO USUARIO VALUES ('178350781','gonzalo','pradena','estudiante','santiago',"+
                "'2130','3030303','30303030','los holos 1313','gonzalo@gmail.com');");
         st.executeUpdate("INSERT INTO ARTICULO VALUES ('123456','PC','notebook','malo','disponible');");
         st.executeUpdate("INSERT INTO ARTICULO VALUES ('123457','PC','notebook','bueno','disponible');");
         st.executeUpdate("INSERT INTO PEDIDO VALUES ('0001','123456','178350781','11-12-12','12-12-12');");
         st.executeUpdate("UPDATE ARTICULO SET ESTADO = 'prestado' WHERE codigo ='123456';");
         
        JOptionPane.showMessageDialog(null,"Datos agregados Exitosamente", 
                "alert", JOptionPane.OK_OPTION);
         }  
      catch (SQLException s){

          SQL_FORM error = new SQL_FORM();
      JOptionPane.showMessageDialog(error,"error al ingresar datos");

        //SQL_FORM error = new SQL_FORM();
      JOptionPane.showMessageDialog(error,s, "alert", JOptionPane.ERROR_MESSAGE);

    }
      finally{
          con.close();
          st.close();
         
      }
  }
        catch (Exception e){
        e.printStackTrace();
    }
    
    
    
    }
    
    
     boolean validar(String busqueda,String Tabla,String llave_consulta,
             String llave_busqueda)  throws IOException, SQLException{
         
          Connection con = null;
          ResultSet resultadosConsulta = null;
          Statement instruccionSQL = null;
         try

        {

             

            con = DriverManager.getConnection
         ("jdbc:mysql://localhost/rsu_inventario","root","inforsu");

            // Preparamos la consulta
            
            instruccionSQL = con.createStatement();
            
            resultadosConsulta = instruccionSQL.executeQuery ("SELECT "+busqueda+
                    " FROM "+Tabla+" WHERE "+llave_consulta+" = '"+llave_busqueda+"'");
 

 

            if( resultadosConsulta.next() )    {    // si es valido el primer reg. hay una fila, tons el usuario y su pw existen
               con.close();
               resultadosConsulta.close();
               instruccionSQL.close();;
                return true;    }    //usuario validado correctamente

                else{
                   con.close();
                   resultadosConsulta.close();
                   instruccionSQL.close();
                return false;  }      //usuario validado incorrectamente

                 

        } catch (Exception e)

        {
            e.printStackTrace();
            con.close();
            resultadosConsulta.close();
            instruccionSQL.close();
            return false;
        }
     
    }
     
     
     
     public void EntregarProducto(String codigo){}
}
    
    


/*
 *
 * 
 * @author Gonzalo Pradena
*/

    

