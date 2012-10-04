/**
 * 
 */
package persistencia;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jon_Inazio
 * @author Lucia
 *
 */
public class Alumno {

	/*
	 * Atributos
	 */
	private int dni;
	private String password;
	private String nombre;
	private String telefono;
	private Set<Evaluacion> susEvaluaciones;
	private Set<Asignatura> susAsignaturas;
	
	/*
	 * Metodos
	 */
	/**
	 * <h1>Constructora de Alumno solo con las listas</h1>
	 */
	public Alumno(){
		susEvaluaciones = new HashSet<Evaluacion>();
		susAsignaturas = new HashSet<Asignatura>();
	}
	
	/**
	 * <h1>Constructora de Alumno con atributos</h1>
	 */
	public Alumno(int dni, String password, String nombre, String telefono){
		susEvaluaciones = new HashSet<Evaluacion>();
		susAsignaturas = new HashSet<Asignatura>();
		
		this.dni = dni;
		this.password = password;
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Set<Evaluacion> getSusEvaluaciones() {
		return susEvaluaciones;
	}

	public void setSusEvaluaciones(Set<Evaluacion> susEvaluaciones) {
		this.susEvaluaciones = susEvaluaciones;
	}
	
	public void addEvaluacion(Evaluacion evaluacion){
		this.susEvaluaciones.add(evaluacion);
	}
	
	public void removeEvaluacion(Evaluacion evaluacion){
		if( this.susEvaluaciones.contains(evaluacion) ){
			this.susEvaluaciones.remove(evaluacion);
		}/*else{
			hacer algo
		}*/
	}

	public Set<Asignatura> getSusAsignaturas() {
		return susAsignaturas;
	}

	public void setSusAsignaturas(Set<Asignatura> susAsignaturas) {
		this.susAsignaturas = susAsignaturas;
	}
	
	public void addAsignatura(Asignatura asignatura){
		this.susAsignaturas.add(asignatura);
	}
	
	public void removeAsignatura(Asignatura asignatura){
		if( this.susAsignaturas.contains(asignatura) ){
			this.susAsignaturas.remove(asignatura);
		}/*else{
			hacer algo
		}*/
	}
	
}
