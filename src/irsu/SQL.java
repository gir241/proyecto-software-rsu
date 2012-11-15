/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package irsu;

import java.sql.*;
import java.util.*;
     
public class SQL {

  public static void main(String [] args) {
    String url = "jdbc:mySubprotocol:myDataSource";

        Connection con;
        Statement stmt;
        try {
      Class.forName("myDriver.ClassName");
  
    } catch(java.lang.ClassNotFoundException e) {
      System.err.print("ClassNotFoundException: "); 
      System.err.println(e.getMessage());
    }

    try {
      con = DriverManager.getConnection(url,
                  "rsu", "inforsu");

      stmt = con.createStatement();

      Vector dataTypes = getDataTypes(con);

      String tableName;
      String columnName;
      String sqlType;
      String prompt = "Enter the new table name and hit Return: ";
      tableName = getInput(prompt);
      String createTableString = "create table " + tableName + " (";
      
      String commaAndSpace = ", ";
      boolean firstTime = true;
      while (true){
        System.out.println("");
        prompt = "Enter a column name " + 
          "(or nothing when finished) \nand hit Return: ";
        columnName = getInput(prompt);
        if (firstTime) {
          if (columnName.length() == 0) {
            System.out.print("Need at least one column;");
            System.out.println(" please try again");
            continue;
          } else {
            createTableString += columnName + " ";
            firstTime = false;
          }
        } else if (columnName.length() == 0) {
            break;
        } else {
          createTableString += commaAndSpace
            + columnName + " "; 
        }
  
        String localTypeName = null;
        String paramString = "";
        while (true) {
          System.out.println("");
          System.out.println("LIST OF TYPES YOU MAY USE:  ");
          boolean firstPrinted = true;
          int length = 0;
          for (int i = 0; i < dataTypes.size(); i++) {
            DataType dataType = (DataType)dataTypes.get(i);
            if (!dataType.needsToBeSet()) {
              if (!firstPrinted)
                System.out.print(commaAndSpace);
              else
                firstPrinted = false;
              System.out.print(dataType.getSQLType());
              length += dataType.getSQLType().length();
              if ( length > 50 ) {
                System.out.println("");
                length = 0;
                firstPrinted = true;
              }
            }  
          }
          System.out.println("");
    
          int index;
          prompt = "Enter a column type " + 
            "from the list and hit Return:  ";
          sqlType = getInput(prompt);
          for (index = 0; index < dataTypes.size(); index++) {
            DataType dataType = (DataType)dataTypes.get(index);
            if (dataType.getSQLType().equalsIgnoreCase(
                            sqlType) && 
              !dataType.needsToBeSet()) {
              break;
            }
          }

          localTypeName = null;
          paramString = "";
          if (index < dataTypes.size()) { // there was a match
            String params;
            DataType dataType = (DataType)dataTypes.get(index);
            params = dataType.getParams();
            localTypeName = dataType.getLocalType();
            if (params != null) {
              prompt = "Enter " + params + ":  ";
              paramString = "(" + getInput(prompt) + ")";
            } 
            break;
          }
          else {              // use the name as given
            prompt = "Are you sure?  " +
              "Enter 'y' or 'n' and hit Return:  ";
            String check = getInput(prompt) + " ";
            check = check.toLowerCase().substring(0,1);
            if (check.equals("n")) 
              continue;
            else {
              localTypeName = sqlType;
              break;
            }
          }
        }
        
        createTableString += localTypeName + paramString;

      }
  
      createTableString += ")";
      System.out.println("");
      System.out.print("Your CREATE TABLE statement as ");
      System.out.println("sent to your DBMS:  ");
      System.out.println(createTableString);
      System.out.println("");
  
         stmt.executeUpdate(createTableString);
  
      stmt.close();
      con.close();
  
    } catch(SQLException ex) {
      System.err.println("SQLException: " + ex.getMessage());
    }  
  }

  private static Vector getDataTypes(Connection con) throws SQLException {
    String structName = null, 
         distinctName = null, 
         javaName = null;

    // create a vector of class DataType initialized with
    // the SQL code, the SQL type name, and two null entries
    // for the local type name and the creation parameter(s)
  
    Vector dataTypes = new Vector();
    dataTypes.add(new DataType(java.sql.Types.BIT, "BIT"));
    dataTypes.add(new DataType(java.sql.Types.TINYINT, "TINYINT"));
    dataTypes.add(new DataType(java.sql.Types.SMALLINT, "SMALLINT"));
    dataTypes.add(new DataType(java.sql.Types.INTEGER, "INTEGER"));
    dataTypes.add(new DataType(java.sql.Types.BIGINT, "BIGINT"));
    dataTypes.add(new DataType(java.sql.Types.FLOAT, "FLOAT"));
    dataTypes.add(new DataType(java.sql.Types.REAL, "REAL"));
    dataTypes.add(new DataType(java.sql.Types.DOUBLE, "DOUBLE"));
    dataTypes.add(new DataType(java.sql.Types.NUMERIC, "NUMERIC"));
    dataTypes.add(new DataType(java.sql.Types.DECIMAL, "DECIMAL"));
    dataTypes.add(new DataType(java.sql.Types.CHAR, "CHAR"));
    dataTypes.add(new DataType(java.sql.Types.VARCHAR, "VARCHAR"));
    dataTypes.add(new DataType(java.sql.Types.LONGVARCHAR, "LONGVARCHAR"));
    dataTypes.add(new DataType(java.sql.Types.DATE, "DATE"));
    dataTypes.add(new DataType(java.sql.Types.TIME,"TIME"));
    dataTypes.add(new DataType(java.sql.Types.TIMESTAMP, "TIMESTAMP"));
    dataTypes.add(new DataType(java.sql.Types.BINARY, "BINARY"));
    dataTypes.add(new DataType(java.sql.Types.VARBINARY, "VARBINARY"));
    dataTypes.add(new DataType(java.sql.Types.LONGVARBINARY, 
      "LONGVARBINARY"));
    dataTypes.add(new DataType(java.sql.Types.NULL, "NULL"));
    dataTypes.add(new DataType(java.sql.Types.OTHER, "OTHER"));
    dataTypes.add(new DataType(java.sql.Types.BLOB, "BLOB"));
    dataTypes.add(new DataType(java.sql.Types.CLOB, "CLOB"));

    DatabaseMetaData dbmd = con.getMetaData();
    ResultSet rs = dbmd.getTypeInfo();
    while (rs.next()) {
      int codeNumber = rs.getInt("DATA_TYPE");
      String dbmsName = rs.getString("TYPE_NAME");
      String createParams = rs.getString("CREATE_PARAMS");

      if ( codeNumber == Types.STRUCT && structName == null )
        structName = dbmsName;
      else if ( codeNumber == Types.DISTINCT && distinctName == null ) 
        distinctName = dbmsName;
      else if ( codeNumber == Types.JAVA_OBJECT && javaName == null )  
        javaName = dbmsName;
      else { 
        for (int i = 0; i < dataTypes.size(); i++) {
          // find entry that matches the SQL code, 
          // and if local type and params are not already set,
          // set them
          DataType type = (DataType)dataTypes.get(i);
          if (type.getCode() == codeNumber) {
            type.setLocalTypeAndParams(dbmsName, createParams);
          }
        }
      }
    }

    int[] types = {Types.STRUCT, Types.DISTINCT, Types.JAVA_OBJECT}; 
    rs = dbmd.getUDTs(null, "%", "%", types); 
    while (rs.next()) {
      String typeName = null;
      DataType dataType = null;

      if ( dbmd.isCatalogAtStart() )
        typeName = rs.getString(1) + dbmd.getCatalogSeparator() +
          rs.getString(2) + "." + rs.getString(3);
      else 
        typeName = rs.getString(2) + "." + rs.getString(3) + 
          dbmd.getCatalogSeparator() + rs.getString(1);

      switch (rs.getInt(5)) {
      case Types.STRUCT:
        dataType = new DataType(Types.STRUCT, typeName);
        dataType.setLocalTypeAndParams(structName, null);
        break;
      case Types.DISTINCT:
        dataType = new DataType(Types.DISTINCT, typeName);
        dataType.setLocalTypeAndParams(distinctName, null);
        break;
      case Types.JAVA_OBJECT:
        dataType = new DataType(Types.JAVA_OBJECT, typeName);
        dataType.setLocalTypeAndParams(javaName, null);
        break;
      }
      dataTypes.add(dataType);
    }

    return dataTypes;
  }      

  private static String getInput(String prompt) throws SQLException {
 
     System.out.print(prompt);
     System.out.flush();
  
     try {
       java.io.BufferedReader bin;
       bin = new java.io.BufferedReader(
          new java.io.InputStreamReader(System.in));
                      
           String result = bin.readLine();
      return result;

    } catch(java.io.IOException ex) {
      System.out.println("Caught java.io.IOException:");
      System.out.println(ex.getMessage());
      return "";
    }
  }
}
class DataType {

  private int code;
  private String SQLType;
  private String localType = null;
  private String params = null;
  private boolean needsSetting = true; 
  
  public DataType(int code, String SQLType) {
    this.code = code;
    this.SQLType = SQLType;
  
  }
  
  public boolean needsToBeSet() {
    return needsSetting;
  }
  
  public int getCode() {
    return code;
  }
  
  public String getSQLType() {
    return SQLType;
  }
  
  public String getLocalType() {
    return localType;
  }
  
  public String getParams() {
    return params;
  }
  
  public void setLocalTypeAndParams(String local, String p) {
    if (needsSetting) {
      localType = local;
      params = p;
      needsSetting = false;
    }
  }
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