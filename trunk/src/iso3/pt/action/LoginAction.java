package iso3.pt.action;


import java.util.Map;

import iso3.pt.dao.IncorrectPasswordException;
import iso3.pt.dao.UserNotFoundException;
import iso3.pt.model.*;
import iso3.pt.service.PtDaoService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;


public class LoginAction extends ActionSupport implements Preparable{

	/*
	 * Atributos
	 */
	private static final long serialVersionUID = 1L;
	private String username = null;
	private String password = null;
	private Alumno student = null;
	private Profesor lecturer = null;
	private String userType = null;
	
	
	/*
	 * Metodos
	 */
		
	public String getUsername() {
		return username;
	}

	public void setUsername(String value) {
		username = value;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String value) {
		password = value;
	}

	public void setStudent(Alumno value) {
		student = value;
	}
	
	public Alumno getStudent() {
		return student;
	}

	public void setLecturer(Profesor value) {
		lecturer = value;
	}
	
	public Profesor getLecturer() {
		return lecturer;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String value) {
		userType = value;
	}

		
	public String login(){
		
		System.out.println("Validating login");
		
		Integer usr = Integer.parseInt(getUsername());
		String psswd = getPassword();
		String type = getUserType();
		System.out.println("Fetching data: " + usr + " - " + psswd + " - " + type);
		
		if ( usr == null || psswd == null) {
			System.out.println("No has metido user o/y pass");
			addActionError("It is necessary to type username and password!");
			return INPUT;
			
		}else{
			
			PtDaoService pt = new PtDaoService();
			
			if( type.equals(getText("label.login.lecturer")) ){
				
				try {
					lecturer = pt.loginProfesor(usr, psswd);
					this.setLecturer(lecturer);
					@SuppressWarnings("unchecked")
					Map<String, Profesor> session = ActionContext.getContext().getSession();
					session.put("user", lecturer);
					return "listLecturerSubjects";
				} catch (UserNotFoundException e) {
					addActionError(getText("errors.invalid.login.details.userlecturernotfound"));
		            return SUCCESS;
				} catch (IncorrectPasswordException e) {
					addActionError(getText("errors.invalid.login.details.password"));
		            return SUCCESS;
				} catch (Exception e) {
					addActionError(getText("errors.invalid.login.details"));
		            return ERROR;
				}
				
				
				
			}else{
				//getText("label.login.student") == student
				
				try {
					student = pt.loginAlumno(usr, psswd);
					this.setStudent(student);
					@SuppressWarnings("unchecked")
					Map<String, Alumno> session = ActionContext.getContext().getSession();
					session.put("user", student);
					return "listStudentSubjects";
				} catch (UserNotFoundException e) {
					addActionError(getText("errors.invalid.login.details.userstudentnotfound"));
		            return SUCCESS;
				} catch (IncorrectPasswordException e) {
					addActionError(getText("errors.invalid.login.details.password"));
		            return SUCCESS;
				} catch (Exception e) {
					addActionError(getText("errors.invalid.login.details"));
		            return ERROR;
				}
				
				
				
			}
			
			
		}
		
	}
	
	@SuppressWarnings("rawtypes")
	public String logout(){
		Map session = ActionContext.getContext().getSession();
		session.remove("user");
		return SUCCESS;
	}

	@Override
	public void prepare() throws Exception {
		//
	}

}
