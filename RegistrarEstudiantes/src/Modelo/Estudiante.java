/*
 * modelo del estudiante posee los elementos de la base de datos y loq eu se ba a guardar
 */
package Modelo;

/**
 *
 * @author sebastian
 */
public class Estudiante {
    private int id;
    private String nombre;
    private String codigo;
    private String semestre;
    private String telefono;
    
    
    public Estudiante(){}
    
    public Estudiante(int id, String nombre,String codigo, String telefono, String semestre ){
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.semestre = semestre;
        this.telefono = telefono;
    }
    
    //metodos triviales de la clase
    
    public int getId(){
        return id;
    }
    
   
    public String getNombre(){
        return nombre;
    }
    
    public String getCodigo(){
        return codigo;
    }
    
    public String getSemestre(){
        return semestre;
    }
    
    public String getTelefono(){
        return telefono;
    }
   
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setNombre(String newName){
        this.nombre = newName;
    }
    
    public void setSemestre(String newSemestre){
        this.semestre = newSemestre;
    }
    
    public void setCodigo(String newCodigo){
        this.codigo = newCodigo;
    }
    
    public void setTelefono(String newTelefono){
        this.telefono = newTelefono;
    }
    
    @Override
	public String toString() {
		return this.nombre+", "+this.codigo+", "+this.telefono+", "+this.semestre;
	}
}
