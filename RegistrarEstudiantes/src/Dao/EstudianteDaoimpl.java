/*
 * clase que posse los metodos del crud
 */

package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Conexion.Conexion;
import IDao.IEstudianteDao;
import Modelo.Estudiante;

/**
 *
 * @author sebastian
 */
public class EstudianteDaoimpl implements IEstudianteDao{

    @Override
    public boolean Agregar(Estudiante es) {
        boolean registrar = false;
        Statement Stm = null;
        Connection con = null;
        
        String sql = "INSERT INTO estudiantesbd.estudiante values ( '" + es.getId() +"','"+ es.getNombre() +"','"+ es.getCodigo()+"','"+ es.getTelefono()+"','"+es.getSemestre()+"')"; 
        try{
            con = Conexion.conectar();
            Stm = con.createStatement();
            Stm.execute(sql);
            registrar = true;
            Stm.close();
            con.close();
        } catch( SQLException e){
            System.out.println("a ocurrido un error  y es this   " + e);
        }
        return registrar;
    }

    @Override
    public List<Estudiante> Obtener() {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM estudiantesbd.estudiante ORDER BY idestudiante";
        
        List<Estudiante> listaEstudiantes = new ArrayList<Estudiante>();
        
        try{
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while(rs.next()){
                Estudiante es = new Estudiante();
                es.setId(rs.getInt(1));
                es.setNombre(rs.getString(2));
                es.setCodigo(rs.getString(3));
                es.setTelefono(rs.getString(4));
                es.setTelefono(rs.getString(5));
                listaEstudiantes.add(es);
            }
            stm.close();
            rs.close();
            con.close();
        }catch(SQLException e){
            System.out.println("error en mostrar   " + e);
        }
        return listaEstudiantes;
    }

    @Override
    public boolean Actualizar(Estudiante es) {
        Connection con = null;
        Statement stm = null;
        
        boolean actualizar = false;
        
        String sql = "UPDATE estudiantesbd.estudiante SET nombre='" + es.getNombre()+"', codigo='"+ es.getCodigo()+"',telefono='"+ es.getTelefono()+"',semestre='"+es.getSemestre()+"' WHERE idestudiante="+ es.getId();
        try {
	    con=Conexion.conectar();
	    stm=con.createStatement();
	    stm.execute(sql);
	    actualizar=true;
	} catch (SQLException e) {
	    System.out.println("error perro mira que hiciste  " + e);
	  
	}		
	return actualizar;
        
    }

    @Override
    public boolean Eliminar(Estudiante es) {
        Connection con =  null;
        Statement stm = null;
        
        boolean eliminar = false;
        
        String sql = "DELETE FROM estudiantesbd.estudiante WHERE idestudiante="+es.getId();
        
        try{
            con = Conexion.conectar();
            stm = con.createStatement();
            stm.execute(sql);
            eliminar = false;
        }catch( SQLException e){
            System.out.println("error de eliminar " + e);
        }
        return eliminar;
    }
    
}
