package iso3.pt.action;


import iso3.pt.dao.IncorrectPasswordException;
import iso3.pt.dao.UserNotFoundException;
import iso3.pt.model.*;
import iso3.pt.service.PtDaoService;

import com.opensymphony.xwork2.ActionSupport;
//import com.opensymphony.xwork2.Preparable;
//import com.opensymphony.xwork2.ActionContext;


public class LoginAction extends ActionSupport {

	/*
	 * Atributos
	 */
	private static final long serialVersionUID = 1L;
	private Integer username = null;
	private String password = null;
	private static Alumno student = null;
	private static Profesor lecturer = null;
	private static String type = null;

	
	/*
	 * Metodos
	 */
		
	public int getUsername() {
		return username;
	}

	public void setUsername(int username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public static Alumno getStudent() {
		return student;
	}

	public static Profesor getLecturer() {
		return lecturer;
	}

	public static String getType() {
		return type;
	}

	public static void setType(String type) {
		LoginAction.type = type;
	}

	public String execute(){
		System.out.println("Executing execute method");
		return SUCCESS;
		
	}
	
	public String login(){
		
		System.out.println("Validating login");
		
		Integer usr = getUsername();
		String psswd = getPassword();
		String type = getType();
		System.out.println("Fetching data: " + usr + " - " + psswd + " - " + type);
		
		if ( usr == null || psswd == null) {
			addActionError("It is necessary to type username and password!");
			return INPUT;
		}else{
			PtDaoService pt = new PtDaoService();
			if( type.equals("1") ){
				
				try {
					lecturer = pt.loginProfesor(usr, psswd);
					return "listLecturerSubjects";
				} catch (UserNotFoundException e) {
					addActionError(getText("errors.invalid.login.details.userlecturernotfound"));
		            return ERROR;
				} catch (IncorrectPasswordException e) {
					addActionError(getText("errors.invalid.login.details.password"));
		            return ERROR;
				}
				
				
				
			}else{
				//type == 2
				
				try {
					student = pt.loginAlumno(usr, psswd);
					return "listStudentSubjects";
				} catch (UserNotFoundException e) {
					addActionError(getText("errors.invalid.login.details.userstudentnotfound"));
		            return ERROR;
				} catch (IncorrectPasswordException e) {
					addActionError(getText("errors.invalid.login.details.password"));
		            return ERROR;
				}
				
				
				
			}
			
			
		}
	}

}
