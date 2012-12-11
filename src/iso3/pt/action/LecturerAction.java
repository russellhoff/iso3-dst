package iso3.pt.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


import iso3.pt.model.Alumno;
import iso3.pt.model.Asignatura;
import iso3.pt.model.Profesor;
import iso3.pt.service.PtDaoService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class LecturerAction extends ActionSupport implements Preparable {

	/*
	 * Atributos
	 */
	
	private static final long serialVersionUID = 1L;
    private int subjectID;
    private String subjectName;
    private Profesor lecturer;
    private Asignatura subject;
    private int estudianteDni;
    private List<Asignatura> listaAsignaturas;
    private List<Alumno> listaAlumnos;


	
	/*
	 * Metodos
	 */



    public Profesor getLecturer() {
		return lecturer;
	}

	public void setLecturer(Profesor lecturer) {
		this.lecturer = lecturer;
	}
	
	public Asignatura getSubject() {
		return subject;
	}

	public void setSubject(Asignatura subject) {
		this.subject = subject;
	}

	
	public String getLecturerName(){
		return this.getLecturer().getNombre();
	}
	
	public int getLecturerDni(){
		return this.getLecturer().getDni();
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getEstudianteDni() {
		return estudianteDni;
	}

	public void setEstudianteDni(int estudianteDni) {
		this.estudianteDni = estudianteDni;
	}

	public List<Asignatura> getListaAsignaturas() {
		return listaAsignaturas;
	}

	public void setListaAsignaturas(List<Asignatura> listaAsignaturas) {
		this.listaAsignaturas = listaAsignaturas;
	}

	public List<Alumno> getListaAlumnos() {
		return listaAlumnos;
	}

	public void setListaAlumnos(List<Alumno> listaAlumnos) {
		this.listaAlumnos = listaAlumnos;
	}
	
	
	
	public int getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
	}

	private void cargarAsignaturas(){
		PtDaoService ptd = new PtDaoService();
		Set<Asignatura> asigns = ptd.getAsignaturasProfesor((int)lecturer.getDni());
		this.listaAsignaturas = new ArrayList<Asignatura>();
		Iterator<Asignatura> it = asigns.iterator();
		Asignatura aux = null;
		System.out.println("A cargar asignaturas");
		if(asigns.isEmpty()) System.out.println("vacía la lista de asignaturas...");
		while(it.hasNext()){
			aux = it.next();
			System.out.println("Asignatura: " + aux.getNombre());
			this.listaAsignaturas.add(aux);
		}
	}
	

	
	public String doShowStudents(){
		
		PtDaoService ptd = new PtDaoService();
		this.setSubjectName(ptd.getAsignatura(subjectID).getNombre());
		Set<Alumno> asigns = ptd.getAlumnos(this.getSubjectID());
		this.listaAlumnos = new ArrayList<Alumno>();
        Iterator<Alumno> it = asigns.iterator();
        Alumno aux = null;
        while(it.hasNext()){
			aux = it.next();
			this.listaAlumnos.add(aux);
		}
        
       
		return "showStudents";
	}
	
	public String doAddMark(){
		
		System.out.println("Añadiendo nota");
		
		return "addMark";
	}
	
	
	/**
	 * <h1>Método para volver atrás, desde el botón de cancelar</h1>
	 * @return
	 */
	public String doReturnFromEvaluationListing(){
		return "returnToShowAllSubjects";
	}
	
	public String execute(){
		/* Esto se hace en prepare:
		 * this.student = (Alumno) ActionContext.getContext().getSession().get("user");
		 */
		this.cargarAsignaturas();
		
		return SUCCESS;
	}
	
	@Override
	public void prepare() throws Exception {
		
		this.setLecturer((Profesor) ActionContext.getContext().getSession().get("user"));
		this.cargarAsignaturas();
		
	}

}
