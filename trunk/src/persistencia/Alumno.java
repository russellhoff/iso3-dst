/**
 * 
 */
package persistencia;

import soporte_persistencia.ListaAsignaturas;
import soporte_persistencia.ListaEvaluaciones;

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
	private ListaEvaluaciones susEvaluaciones;
	private ListaAsignaturas susAsignaturas;
	
	/*
	 * Metodos
	 */
	/**
	 * <h1>Constructora de Alumno</h1>
	 */
	public Alumno(){
		
	}
	
}
