package iso3.pt.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
	private List<Asignatura> asignaturas = null;
		
	/*
	 * Metodos
	 */
	
	public Alumno getStudent() {
		return student;
	}

	public void setStudent(Alumno student) {
		this.student = student;
	}

	public Integer getStudentDni(){
		return this.getStudent().getDni();
	}
	
	public String getStudentName(){
		return this.getStudent().getNombre();
	}
	
	public List<Asignatura> getAsignaturas(){
		return this.asignaturas;
	}
	
	private void cargarAsignaturas(){
		PtDaoService ptd = new PtDaoService();
		Set<Asignatura> asigns = ptd.getAsignaturas(student.getDni());
		this.asignaturas = new ArrayList<Asignatura>();
		Iterator<Asignatura> it = asigns.iterator();
		Asignatura aux = null;
		while(it.hasNext()){
			aux = it.next();
			System.out.println("Asignatura: " + aux.getNombre());
			this.asignaturas.add(aux);
		}
	}
		
	public String execute(){
		/*
		 * todo
		 */
		
		return SUCCESS;
	}
	
	@Override
	public void prepare() throws Exception {
		this.setStudent((Alumno) ActionContext.getContext().getSession().get("user"));
		System.out.println("Info usuario conectado: " + this.getStudentName() + " - " + this.getStudentDni());
		
		this.cargarAsignaturas();
		
	}

}
