/**
 * 
 */
package iso3.pt.model;

/**
 * @author Jon_Inazio
 * @author Lucia
 * @author Eztizen
 */
public class Evaluacion {

	/*
	 * Atributos
	 */
	private Integer id;
	private String concepto;
	private float nota;
	private Asignatura asignatura;
	private Alumno alumno;
	
	/*
	 * Metodos
	 */
	/**
	 * <h1>Constructora de Evaluacion</h1>
	 */
	public Evaluacion(){
		
	}
	
	public Evaluacion(String concepto, float nota){
		this.concepto = concepto;
		this.nota = nota;
	}
	
	/**
	 * <h1>Crear evaluacion con las referencias asignadas</h1>
	 * @param concepto
	 * @param nota
	 * @param asignatura
	 * @param alumno
	 */
	public Evaluacion(String concepto, float nota, Asignatura asignatura, Alumno alumno){
		this.concepto = concepto;
		this.nota = nota;
		this.asignatura = asignatura;
		this.alumno = alumno;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
	
	
}
