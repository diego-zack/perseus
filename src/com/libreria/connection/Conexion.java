package com.libreria.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author fabia
 */
public class Conexion {
    
    protected Connection con;
    protected Statement stmt;
    private String serverName= "localhost";
    private String portNumber = "3306";
    private String databaseName= "perseusdb";
    private String url = "jdbc:mysql://localhost:3306/" + databaseName;
    private String userName = "root";
    private String password = ""; 
    private String errString;

      public Conexion()
      {
         
      }
        private String getConnectionUrl()
     {
         return url;
     }

    
     public Connection Conectar() {
        con=null;
         try{
              con = DriverManager.getConnection(getConnectionUrl(),userName,password);
              stmt=con.createStatement();
         }catch(Exception e){
             errString= "Error Mientras se conectaba a la Base de Datos";
             System.out.println(errString+" ==> "+e);
             return null;
         }
          return con;
     }

     /* Mostrar las propiedades del controlador y los detalles de la base de datos */

       public void Desconectar()
     {
         try{
              stmt.close();
              con.close();
         }catch(SQLException e){
             errString= "Error Mientras se Cerraba la Conexion a la Base de Datos";
         }
     }
       public Statement getStmt()
       {
          return this.stmt;
       }
       
    
}