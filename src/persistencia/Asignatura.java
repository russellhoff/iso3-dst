/**
 * 
 */
package persistencia;

import java.util.HashSet;
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
	private int id;
	private int codigo;
	private String nombre;
	private float creditos;
	private Set<Alumno> alumnos;
	private Set<Unidad> unidades;
	private Set<Profesor> profesores;
	
	/*
	 * Metodos
	 */
	public Asignatura(){
	}
	
	public Asignatura(){
		this.alumnos = new HashSet<Alumno>();
		this.unidades = new HashSet<Unidad>();
		this.profesores = new HashSet<Profesor>();
	}
	
	public Asignatura(int codigo, String nombre, float creditos){
		this.codigo = codigo;
		this.nombre = nombre;
		this.creditos = creditos;
		this.alumnos = new HashSet<Alumno>();
		this.unidades = new HashSet<Unidad>();
		this.profesores = new HashSet<Profesor>();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Set<Unidad> getUnidades() {
		return unidades;
	}

	public void setUnidades(Set<Unidad> unidades) {
		this.unidades = unidades;
	}

	public void addUnidad(Unidad unidad){
		this.unidades.add(unidad);
	}
	
	public void removeUnidad(Unidad unidad){
		this.unidades.remove(unidad);
	}

	public Set<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(Set<Profesor> profesores) {
		this.profesores = profesores;
	}
	
	public void addProfesor(Profesor profesor){
		this.profesores.add(profesor);
	}
	
	public void removeProfesor(Profesor profesor){
		this.profesores.remove(profesor);
	}
	
}
