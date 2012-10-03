/**
 * 
 */
package persistencia;

import soporte_persistencia.ListaAlumnos;
import soporte_persistencia.ListaProfesores;
import soporte_persistencia.ListaUnidades;

/**
 * @author Jon_Inazio
 * @author Lucia
 *
 */
public class Asignatura {

	/*
	 * Atributos
	 */
	private int id;
	private int codigo;
	private String nombre;
	private float creditos;
	private ListaAlumnos laClase;
	private ListaUnidades lasUnidades;
	private ListaProfesores losProfesores;
	
	/*
	 * Metodos
	 */
	public Asignatura(){
		
	}
	
}
