/*
 * vista se puede usar el entorno grafico en esta seccion
 */
package vistas;
import java.util.List;

import Modelo.Estudiante;
/**
 *
 * @author sebastian
 */
public class vista{
    public void verEstudiante(Estudiante es){
        System.out.println("datos del estudiante   " + es);
    }
    public void verEstudiantes(List<Estudiante>es){
        for(Estudiante estudiante: es){
            System.out.println("datos del estudiante  "+ es);
        }
    }
}
