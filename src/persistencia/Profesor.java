/**
 * 
 */
package persistencia;

/**
 * @author Jon_Inazio
 * @author Lucia
 *
 */
public class Profesor {

	/*
	 * Atributos
	 */
	private int id;
	private int dni;
	private String password;
	private String nombre;
	private String telefono;
	private String email;
	private String despacho;
	
	/*
	 * Metodos
	 */
	/**
	 * <h1>Constructora de Profesor</h1>
	 * <p></p>
	 */
	public Profesor(int dni, String password, String nombre, String telefono, String email, String despacho){
		
		this.dni = dni;
		this.password = password;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.despacho = despacho;
		
	}
	
}
