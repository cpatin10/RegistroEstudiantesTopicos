package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class Conexion {
    public static Connection con = null;
     
    public Conexion() {}
    
    public static Connection conectar(){
        
    String driver = "com.mysql.jdbc.Driver";
    String password = "Srl29041995";
    String usuario = "root";
    String url = "jdbc:mysql://localhost:3306/estudiantesbd";
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