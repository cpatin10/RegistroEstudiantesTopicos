/*
 * clase que se encarga de llamar al DAO para pedir los metodos 
 * 
 */
package Controlador;

import java.util.ArrayList;
import java.util.List;


import Dao.EstudianteDaoimpl;
import IDao.IEstudianteDao;
import Modelo.Estudiante;



/**
 *
 * @author sebastian
 */
public class Controlador {
    
  
    
    public Controlador(){}
    
    public void registrar(Estudiante es){
        IEstudianteDao dao = new EstudianteDaoimpl();
        dao.Agregar(es);
    }
    
    public void actualizar(Estudiante es){
        IEstudianteDao dao = new EstudianteDaoimpl();
        dao.Actualizar(es);
    }
    
    public void eliminar(Estudiante es){
        IEstudianteDao dao = new EstudianteDaoimpl();
        dao.Eliminar(es);
    }
    
    public String verEstudiantes(){
        List<Estudiante> es = new ArrayList<Estudiante>();
        IEstudianteDao dao = new EstudianteDaoimpl();
        es = dao.Obtener();
        String str = "";
        for(Estudiante estudiante: es){
            str = str + estudiante.getId() +", " + estudiante.getNombre() +", " +estudiante.getCodigo() +", "+ estudiante.getTelefono() + ", "+estudiante.getSemestre() + " \n";
        }
        return str;
    }
    
    public List<Estudiante> obtenerEstudiantes(){
        IEstudianteDao dao = new EstudianteDaoimpl();
        return dao.Obtener();
    }
}
