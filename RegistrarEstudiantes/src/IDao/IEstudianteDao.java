/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IDao;
import Modelo.Estudiante;
import java.util.List;
/**
 *
 * @author sebastian
 */
public interface IEstudianteDao {
    //metodos del CRUD
    public boolean Agregar(Estudiante es);
    public List<Estudiante> Obtener();
    public boolean Actualizar(Estudiante es);
    public boolean Eliminar(Estudiante es);
}
