/**
 * 
 */
package iso3.pt.model;

/**
 * @author Jon_Inazio
 * @author Lucia
 * @author Eztizen
 */
public class Unidad {

	/*
	 * Atributos
	 */
	private int id;
	private String acronimo;
	private String titulo;
	private String contenido;
	
	/*
	 * Metodos
	 */
	/**
	 * <h1>Constructora de Unidad</h1>
	 * <p></p>
	 */
	public Unidad(){
		
	}
	
	/**
	 * <h1>Constructora de Unidad con atributos</h1>
	 * <p></p>
	 */
	public Unidad(String acronimo, String titulo, String contenido){
		this.acronimo = acronimo;
		this.titulo = titulo;
		this.contenido = contenido;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAcronimo() {
		return acronimo;
	}

	public void setAcronimo(String acronimo) {
		this.acronimo = acronimo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	
	
	
}
