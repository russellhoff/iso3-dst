package iso3.pt.dao;

public class UserNotFoundException extends Exception {

	/*
	 * Atributos
	 */
	private static final long serialVersionUID = 1L;
	private Integer userNotfound = null;
	
	/*
	 * Metodos
	 */
	public UserNotFoundException(){
		super();
	}
	
	public UserNotFoundException(Integer usuario){
		super();
		this.userNotfound = usuario;
	}
	
	@Override
	public String getMessage() {
		return "No se ha encontrado al usuario con dni " + userNotfound + "\n";
	}
	
}
