package iso3.pt.dao;

public class IncorrectPasswordException extends Exception {

	/*
	 * Atributos
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * Metodos
	 */
	public IncorrectPasswordException(){
		super();
	}
	
	@Override
	public String getMessage() {
		return "La contraseña es incorrecta.\n";
	}
	
}
