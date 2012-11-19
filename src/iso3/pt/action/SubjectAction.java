package iso3.pt.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import iso3.pt.model.Alumno;
import iso3.pt.model.Asignatura;
import iso3.pt.model.Evaluacion;
import iso3.pt.service.PtDaoService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class SubjectAction extends ActionSupport implements Preparable {

	/*
	 * Atributos
	 */
	private static final long serialVersionUID = 1L;
	private Alumno student = null;
	private Asignatura subject = null;
	private Integer subjectId = null;
	private Integer studentDNI = null;
	private List<Asignatura> listaAsignaturasMatriculadas = null;
	private List<Evaluacion> listaEvaluaciones = null;
	private String concept = null;
	private float mark;
	
	/*
	 * Metodos
	 */

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

	public List<Evaluacion> getListaEvaluaciones() {
		return listaEvaluaciones;
	}

	public void setListaEvaluaciones(List<Evaluacion> listaEvaluaciones) {
		this.listaEvaluaciones = listaEvaluaciones;
	}

	public Integer getStudentDNI() {
		return studentDNI;
	}

	public void setStudentDNI(Integer studentDNI) {
		this.studentDNI = studentDNI;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public List<Asignatura> getListaAsignaturasMatriculadas() {
		return listaAsignaturasMatriculadas;
	}

	public void setListaAsignaturasMatriculadas(
			List<Asignatura> listaAsignaturasMatriculadas) {
		this.listaAsignaturasMatriculadas = listaAsignaturasMatriculadas;
	}
	
	public Asignatura getSubject(){
		return this.subject;
	}
	
	public void setSubject(Asignatura value){
		this.subject = value;
	}
	
	public Alumno getStudent(){
		return this.student;
	}
	
	public void setStudent(Alumno value){
		this.student = value;
	}
	
	public String getStudentName(){
		return this.student.getNombre();
	}
	
	public Integer getStudentDni(){
		return this.student.getDni();
	}
	
	public String getStudentTel(){
		return this.student.getTelefono();
	}
	
	public String execute(){
		
		this.listaEvaluaciones = new ArrayList<Evaluacion>();
		PtDaoService pt = new PtDaoService();
		Set<Evaluacion> lp = pt.getEvaluaciones(subjectId, studentDNI);
		Iterator<Evaluacion> it = lp.iterator();
		while(it.hasNext()){
			this.listaEvaluaciones.add(it.next());
		}
		
		return SUCCESS;
	}
	
	@Override
	public void prepare() throws Exception {
		this.student = (Alumno) ActionContext.getContext().getSession().get("user");
		System.out.println("Usuario pillado para mostrar todas las notas: " + this.student);
		
		PtDaoService pt = new PtDaoService();
		this.subject = pt.getAsignatura(subjectId);
		System.out.println("Asignatura pillada para mostrar todas las notas: " + this.subject);
		
	}

}
