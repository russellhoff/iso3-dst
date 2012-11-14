package iso3.pt.action;

import iso3.pt.model.Alumno;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class StudentAction extends ActionSupport implements Preparable {

	/*
	 * Atributos
	 */
	private static final long serialVersionUID = 1L;
	private Alumno student;
	
	/*
	 * Metodos
	 */
	
	public Alumno getStudent() {
		return student;
	}

	public void setStudent(Alumno student) {
		this.student = student;
	}

	public String getStudentName(){
		return "Pedrete";//this.getStudent().getNombre();
	}
	
	public Integer getStudentDni(){
		return 78935432;//this.getStudent().getDni();
	}
	
	public String execute(){
		
	}
	
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}

}
