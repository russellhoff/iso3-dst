package iso3.pt.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import iso3.pt.model.Alumno;
import iso3.pt.model.Asignatura;
import iso3.pt.service.PtDaoService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class StudentAction extends ActionSupport implements Preparable {

	/*
	 * Atributos
	 */
	private static final long serialVersionUID = 1L;
	private Alumno student = null;
	private Asignatura subject = null;
	private List<Asignatura> listaAsignaturasMatriculadas;
	private List<Asignatura> listaTodasAsignaturas;
	private List<Asignatura> listaAsignaturasNoMatriculadas;
	private int subjectId;
			
	/*
	 * Metodos
	 */
	
	public List<Asignatura> getListaAsignaturasNoMatriculadas() {
		return listaAsignaturasNoMatriculadas;
	}

	public void setListaAsignaturasNoMatriculadas(
			List<Asignatura> listaAsignaturasNoMatriculadas) {
		this.listaAsignaturasNoMatriculadas = listaAsignaturasNoMatriculadas;
	}

	public Asignatura getSubject(){
		return this.subject;
	}
	
	public void setSubject(Asignatura value){
		this.subject = value;
	}
	
	public int getStudentDni(){
		return this.getStudent().getDni();
	}
		
	public int getSubjectId(){
		return this.subjectId;
	}
	
	public void setSubjectId(int value){
		this.subjectId = value;
	}
	
	public Alumno getStudent() {
		return student;
	}

	public void setStudent(Alumno student) {
		this.student = student;
	}

	public String getStudentName(){
		return this.getStudent().getNombre();
	}
	
	public List<Asignatura> getListaAsignaturasMatriculadas(){
		return this.listaAsignaturasMatriculadas;
	}
	
	public void setListaAsignaturasMatriculadas(List<Asignatura> values){
		this.listaAsignaturasMatriculadas = values;
	}
	
	public List<Asignatura> getListaTodasAsignaturas(){
		return this.listaTodasAsignaturas;
	}
	
	public void setListaTodasAsignaturas(List<Asignatura> values){
		this.listaTodasAsignaturas = values;
	}
	
	private void cargarAsignaturas(){
		PtDaoService ptd = new PtDaoService();
		Set<Asignatura> asigns = ptd.getAsignaturas((int)student.getDni());
		this.listaAsignaturasMatriculadas = new ArrayList<Asignatura>();
		Iterator<Asignatura> it = asigns.iterator();
		Asignatura aux = null;
		System.out.println("A cargar asignaturas");
		if(asigns.isEmpty()) System.out.println("vac�a la lista de asignaturas...");
		while(it.hasNext()){
			aux = it.next();
			System.out.println("Asignatura: " + aux.getNombre());
			this.listaAsignaturasMatriculadas.add(aux);
		}
	}
	
	public String doDesmatricularseDeAsignatura(){
		new PtDaoService().desmatricular(this.student.getDni(), this.subjectId);
		this.cargarAsignaturas();
		return "desmatricularseDeAsignatura";
	}
	
	public String doFormularioMatricularseNuevaAsignatura(){
		this.listaTodasAsignaturas = new ArrayList<Asignatura>();
		this.listaAsignaturasNoMatriculadas = new ArrayList<Asignatura>();
		Iterator<Asignatura> it = new PtDaoService().getAsignaturas().iterator();
		Asignatura aux = null;
		
		while(it.hasNext()){
			aux = it.next();
			System.out.println("A�adida asignatura para mostrar a la hora de matricularse: " + aux.toString());
			this.listaTodasAsignaturas.add(aux);
			
			if( !student.getAsignaturas().contains(aux) ){
				//si la lista de asignaturas en las que est� matriculado un alumno no contiene la asignatura actual
				//la a�adimos a las asignaturas en las que no est� matriculado
				
				this.listaAsignaturasNoMatriculadas.add(aux);
				
			}
			
		}
		
		return "formularioMatricularseNuevaAsignatura";
		
	}
		
	public String doMatricularseEnAsignatura(){
		System.out.println("Intentando matricular al alumno con dni " + this.student.getDni() + " en la asignatura con codigo " + this.subjectId);
		new PtDaoService().matricular(this.student.getDni(), this.subjectId);
		this.cargarAsignaturas();
		return "matricularseEnAsignatura";
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
		
		this.setStudent((Alumno) ActionContext.getContext().getSession().get("user"));
		System.out.println("Info usuario conectado: " + this.getStudentName() + " - " + this.getStudentDni());
		System.out.println("Identificador de asignatura: " + this.subjectId);
		this.cargarAsignaturas();
		
	}

}
