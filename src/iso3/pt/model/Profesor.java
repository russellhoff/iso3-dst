/**
 * 
 */
package iso3.pt.model;

/**
 * @author Jon_Inazio
 * @author Lucia
 * @author Eztizen
 */
public class Profesor {

	/*
	 * Atributos
	 */
	private Integer id;
	private Integer dni;
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
	public Profesor(Integer dni, String password, String nombre, String telefono, String email, String despacho){
		
		
		this.dni = dni;
		this.password = password;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.despacho = despacho;
		
	}
	
	/**
	 * <h1>Constructora vac�a</h1>
	 * <p></p>
	 */
	public Profesor(){
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDespacho() {
		return despacho;
	}

	public void setDespacho(String despacho) {
		this.despacho = despacho;
	}
	

	public String toString(){
		return "Profesor: " + this.getNombre();
	}
	
}
