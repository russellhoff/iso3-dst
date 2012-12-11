package iso3.pt.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import iso3.pt.model.Asignatura;
import iso3.pt.model.Profesor;
import iso3.pt.model.Unidad;
import iso3.pt.service.PtDaoService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class UnitAction extends ActionSupport implements Preparable {

	/*
	 * Atributos
	 */
	private static final long serialVersionUID = 1L;
	private Asignatura subject = null;
	private Profesor lecturer = null;
	private String subjectID = null;
	private List<Unidad> listaUnidades = null;

	
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



	public String getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(String subjectId) {
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

	public String doShowUnitListLecturer(){
		System.out.println("Asignatura para mostrar sus unidades: " + this.subjectID);
		
		PtDaoService pt = new PtDaoService();
		
		this.subject = pt.getAsignatura(Integer.parseInt(this.subjectID));
		System.out.println("Asignatura: " + this.subject.getNombre());
		Iterator<Unidad> it = this.subject.getUnidades().iterator();
		
		this.listaUnidades = new ArrayList<Unidad>();
		
		while( it.hasNext() ){
			this.listaUnidades.add( (Unidad) it.next() );	
		}
		
		return "showUnitListLecturer";
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
