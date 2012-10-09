/**
 * 
 */
package iso3.pt.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


/**
 * @author Jon_Inazio
 * @author Lucia
 * @author Eztizen
 */
public class Asignatura {

	/*
	 * Atributos
	 */
	private Integer id;
	private int codigo;
	private String nombre;
	private float creditos;
	private Set<Alumno> alumnos;
	private Set<Unidad> unidades;
	private Profesor profesor;
	
	/*
	 * Metodos
	 */
	public Asignatura(){
		this.alumnos = new HashSet<Alumno>();
		this.unidades = new HashSet<Unidad>();
		this.profesor = null;
	}
	
	public Asignatura(Integer codigo, String nombre, float creditos, Profesor profesor){
		this.codigo = codigo;
		this.nombre = nombre;
		this.creditos = creditos;
		this.alumnos = new HashSet<Alumno>();
		this.unidades = new HashSet<Unidad>();
		this.profesor = profesor;
	}
	
	public Asignatura(Integer codigo, String nombre, float creditos){
		this.codigo = codigo;
		this.nombre = nombre;
		this.creditos = creditos;
		this.alumnos = new HashSet<Alumno>();
		this.unidades = new HashSet<Unidad>();
		this.profesor = null;
	}
	
	private Iterator<Alumno> getIteradorAlumnos(){
		return this.alumnos.iterator();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getCreditos() {
		return creditos;
	}

	public void setCreditos(float creditos) {
		this.creditos = creditos;
	}

	public Set<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(Set<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
	public void addAlumnos(Alumno alumno){
		this.alumnos.add(alumno);
	}
	
	public void removeAlumnos(Alumno alumno){
		this.alumnos.remove(alumno);
	}

	public Set<Unidad> getUnidades() {
		return unidades;
	}

	public void setUnidades(Set<Unidad> unidades) {
		this.unidades = unidades;
	}

	public void addUnidades(Unidad unidad){
		this.unidades.add(unidad);
	}
	
	public void removeUnidades(Unidad unidad){
		this.unidades.remove(unidad);
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
		
	/**
	 * <h1>¿Está matriculado un alumno?</h1>
	 * <p>Función que dado un alumno, dice si se encuentra matriculado en la asignatura actual.</p>
	 * @param alumno
	 * @return boolean esta matriculado
	 */
	public boolean estaMatriculadoAlumno(Alumno alumno){
		
		boolean esta = false;
		Iterator<Alumno> it = this.getIteradorAlumnos();
		Alumno unAlumno = null;
		
		while (it.hasNext() && !esta){
			unAlumno = it.next();
			
			if( unAlumno.getDni() == alumno.getDni() ){
				esta = true;
			}
			
		}
		
		return esta;
		
	}
	
}
