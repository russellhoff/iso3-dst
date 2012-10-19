/**
 * 
 */
package iso3.pt.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jon_Inazio
 * @author Lucia
 * @author Eztizen
 */
public class Alumno {

	/*
	 * Atributos
	 */
	private Integer dni;
	private String password;
	private String nombre;
	private String telefono;
	private Set<Evaluacion> evaluaciones;
	private Set<Asignatura> asignaturas;
	
	/*
	 * Metodos
	 */
	/**
	 * <h1>Constructora de Alumno solo con las listas</h1>
	 */
	public Alumno(){
		evaluaciones = new HashSet<Evaluacion>();
		asignaturas = new HashSet<Asignatura>();
	}
	
	/**
	 * <h1>Constructora de Alumno con atributos</h1>
	 */
	public Alumno(Integer dni, String password, String nombre, String telefono){
		evaluaciones = new HashSet<Evaluacion>();
		asignaturas = new HashSet<Asignatura>();
		
		this.dni = dni;
		this.password = password;
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
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

	public Set<Evaluacion> getEvaluaciones() {
		return evaluaciones;
	}

	public void setEvaluaciones(Set<Evaluacion> evaluaciones) {
		this.evaluaciones = evaluaciones;
	}
	
	public void addEvaluacion(Evaluacion evaluacion){
		this.evaluaciones.add(evaluacion);
	}
	
	public void removeEvaluacion(Evaluacion evaluacion){
		this.evaluaciones.remove(evaluacion);
	}

	public Set<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(Set<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}
	
	public void addAsignatura(Asignatura asignatura){
		this.asignaturas.add(asignatura);
	}
	
	public void removeAsignatura(Asignatura asignatura){
		this.asignaturas.remove(asignatura);
	}
	
	@Override
	public String toString(){
		return this.getNombre() + " (dni " + this.getDni() +")";
	}
	
}
