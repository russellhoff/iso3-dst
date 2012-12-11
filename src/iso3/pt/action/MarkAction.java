package iso3.pt.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import iso3.pt.model.Alumno;
import iso3.pt.model.Asignatura;
import iso3.pt.model.Evaluacion;
import iso3.pt.model.Profesor;
import iso3.pt.model.Unidad;
import iso3.pt.service.PtDaoService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class MarkAction extends ActionSupport implements Preparable {

	/*
	 * Atributos
	 */
	private static final long serialVersionUID = 1L;
	private Asignatura subject = null;
	private Profesor lecturer = null;
	private Alumno student = null;
	private int studentDni;
	private int subjectID;
	private String concept;
	private float mark;
	private List<Evaluacion> listaEvaluaciones = null;

	
	/*
	 * Metodos
	 */
	
	public List<Evaluacion> getListaEvaluaciones() {
		return listaEvaluaciones;
	}

	public void setListaEvaluacion(List<Evaluacion> listaEvaluaciones) {
		this.listaEvaluaciones = listaEvaluaciones;
	}

	public String getSubjectLecturerName(){
		return this.subject.getProfesor().getNombre();
	}
	
	public int getSubjectUnitNr(){
		return this.subject.getUnidades().size();
	}



	public int getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(int subjectId) {
		this.subjectID = subjectId;
	}

	
	public Asignatura getSubject(){
		return this.subject;
	}
	
	public void setSubject(Asignatura value){
		this.subject = value;
	}
		
	
	
	public Profesor getLecturer() {
		return lecturer;
	}

	public void setLecturer(Profesor lecturer) {
		this.lecturer = lecturer;
	}
	
	public String getLecturerName(){
		return this.getLecturer().getNombre();
	}
	
	public int getLecturerDni(){
		return this.getLecturer().getDni();
	}

	public Alumno getStudent() {
		return student;
	}

	public void setStudent(Alumno student) {
		this.student = student;
	}

	
	
	public int getStudentDni() {
		return studentDni;
	}

	public void setStudentDni(int studentDni) {
		this.studentDni = studentDni;
	}

	
	public String getConcept() {
		return concept;
	}

	public void setConcept(String concept) {
		this.concept = concept;
	}

	public float getMark() {
		return mark;
	}

	public void setMark(float mark) {
		this.mark = mark;
	}

	public String doAddMark(){
		
		System.out.println("Añadiendo nota");
		PtDaoService ptd = new PtDaoService();
		this.setSubject(ptd.getAsignatura(subjectID));
		this.setStudent(ptd.getAlumno(studentDni));
		System.out.println(this.getSubject().toString());
		System.out.println(this.getStudent().toString());
		
		
		return SUCCESS;
	}
	
	public String doSaveMark(){
		
		PtDaoService ptd = new PtDaoService();
		ptd.addEvaluacion(concept, mark, subjectID, studentDni);
		
		this.listaEvaluaciones = new ArrayList<Evaluacion>();
		Set<Evaluacion> eval = ptd.getEvaluaciones(subjectID, studentDni);
		Iterator<Evaluacion> it = eval.iterator();
        Evaluacion aux = null;
        while(it.hasNext()){
			aux = it.next();
			this.listaEvaluaciones.add(aux);
		}
        
		this.setSubject(ptd.getAsignatura(subjectID));
		this.setStudent(ptd.getAlumno(studentDni));
        
		return "saveMark";
	}
	
	/**
	 * <h1>Método para volver atrás, desde el botón de cancelar</h1>
	 * @return
	 */
	public String doReturnFromEvaluationListing(){
		return "return";
	}
	
	public String execute(){
		return SUCCESS;
	}
	
	@Override
	public void prepare() throws Exception {
		
		this.setLecturer((Profesor) ActionContext.getContext().getSession().get("user"));
		

		
	}

}
