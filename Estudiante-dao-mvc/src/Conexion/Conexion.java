package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class Conexion {
    public static Connection con = null;
     
    public Conexion() {}
    
    public static Connection conectar(){
        
    String driver = "com.mysql.jdbc.Driver";
    //String password = "Er1uska493"; //"Srl29041995";
    String password = "123456";
    String usuario = "admin";
    String url = "jdbc:mysql://localhost:3306/estudiantesbd";
//    String url = "jdbc-url-connection";
//    String usuario = "jdbc-user";
//    String password = "jdbc-password";
		try{
                    Class.forName(driver);
                    con = DriverManager.getConnection(url, usuario, password );
                    if(con != null){
                        System.out.println("conexion estavblecida perrroooo");
                    }
                }catch(ClassNotFoundException | SQLException e){
                    System.out.println("error al conectar en la conexion  "+ e);
                }
                return con;
                
    }
    
    //retorna la conexion a la base datos 
     public Connection getConection(){           
    	 return con;	
     }
     
     //metodo que desconecta  de la base de datos
     public void desconectar(){
         con = null;
         if(con == null){
             System.out.println("conexcion terminada");
         }
     }
     
}