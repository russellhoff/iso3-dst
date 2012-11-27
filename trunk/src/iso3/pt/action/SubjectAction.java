package iso3.pt.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import iso3.pt.model.Alumno;
import iso3.pt.model.Asignatura;
import iso3.pt.model.Evaluacion;
import iso3.pt.model.Unidad;
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
	private String subjectID = null;
	private String studentDNI = null;
	private List<Asignatura> listaAsignaturasMatriculadas = null;
	private List<Evaluacion> listaEvaluaciones = null;
	private List<Unidad> listaUnidades = null;
	private String concept = null;
	private float mark;
	
	/*
	 * Metodos
	 */
	
	public List<Unidad> getListaUnidades() {
		return listaUnidades;
	}

	public void setListaUnidades(List<Unidad> listaUnidades) {
		this.listaUnidades = listaUnidades;
	}

	public String getSubjectLecturerName(){
		return this.subject.getProfesor().getNombre();
	}
	
	public int getSubjectUnitNr(){
		return this.subject.getUnidades().size();
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

	public List<Evaluacion> getListaEvaluaciones() {
		return listaEvaluaciones;
	}

	public void setListaEvaluaciones(List<Evaluacion> listaEvaluaciones) {
		this.listaEvaluaciones = listaEvaluaciones;
	}

	/**
	 * <h1>Devuelve el DNI de la instancia de estudiante.</h1>
	 * @return
	 */
	public Integer getStudentDni() {
		return this.student.getDni();
	}
	
	/**
	 * <h1>Parámetro studentDni</h1>
	 * @return
	 */
	public String getStudentDNI(){
		return this.studentDNI;
	}

	/**
	 * <h1>Parámetro studentDni</h1>
	 * @param studentDni
	 */
	public void setStudentDNI(String studentDni) {
		this.studentDNI = studentDni;
	}

	public String getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(String subjectId) {
		this.subjectID = subjectId;
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
		
	public String getStudentTel(){
		return this.student.getTelefono();
	}
		
	/**
	 * <h1>Para todas las notas de todas las asignaturas.</h1>
	 * @return
	 */
	public String doShowSubjectsMarkList(){
		
		this.student = (Alumno) ActionContext.getContext().getSession().get("user");
		this.listaEvaluaciones = new ArrayList<Evaluacion>();
		System.out.println("Pillando evaluaciones."); 
		Set<Evaluacion> lp = this.student.getEvaluaciones();
		System.out.println("Evaluaciones pilladas.");
		Iterator<Evaluacion> it = lp.iterator();
		Evaluacion aux = null;
		while(it.hasNext()){
			aux = it.next();
			System.out.println("Evaluacion mostrada: " + aux.toString());
			this.listaEvaluaciones.add(aux);
		}
		
		return "showSubjectMarkList";
	}
	
	/**
	 * <h1>El método que prepara para mostrar las notas de una asignatura</h1>
	 * @return
	 */
	public String doStudentSubjectMarks(){
		
		this.student = (Alumno) ActionContext.getContext().getSession().get("user");
		
		PtDaoService pt = new PtDaoService();
		this.subject = pt.getAsignatura(Integer.parseInt(subjectID));
		
		this.listaEvaluaciones = new ArrayList<Evaluacion>();
		
		Set<Evaluacion> evs = pt.getEvaluaciones(Integer.parseInt(subjectID), Integer.parseInt(studentDNI));
		Iterator<Evaluacion> it = evs.iterator();
		
		while( it.hasNext() ){
			this.listaEvaluaciones.add((Evaluacion) it.next());
		}
		
		return SUCCESS;
	}
	
	public String doShowUnitList(){
		System.out.println("Asignatura para mostrar sus unidades: " + this.subjectID);
		
		PtDaoService pt = new PtDaoService();
		
		this.subject = pt.getAsignatura(Integer.parseInt(this.subjectID));
		System.out.println("Asignatura: " + this.subject.getNombre());
		Iterator<Unidad> it = this.subject.getUnidades().iterator();
		
		this.listaUnidades = new ArrayList<Unidad>();
		
		while( it.hasNext() ){
			this.listaUnidades.add( (Unidad) it.next() );	
		}
		
		return "showUnitList";
	}
	
	/**
	 * <h1>Método para volver atrás, desde el botón de cancelar</h1>
	 * @return
	 */
	public String doReturnFromEvaluationListing(){
		return "returnToShowAllSubjects";
	}
	
	public String execute(){
		return SUCCESS;
	}
	
	@Override
	public void prepare() throws Exception {
		
		this.student = (Alumno) ActionContext.getContext().getSession().get("user");
		System.out.println("Usuario pillado para mostrar todas las notas: " + this.student.toString());
		
	}

}
