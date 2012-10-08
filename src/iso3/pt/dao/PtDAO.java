/**
 * 
 */
package iso3.pt.dao;


import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import iso3.pt.model.*;

/**
 * @author Jon_Inazio
 * @author Lucia
 * @author Eztizen
 * 
 * <h1>Clase que cumple el patrón DAO (Data Access Object) y Singleton.</h1>
 */
public class PtDAO {

	/*
	 * Atributos
	 */
	private static PtDAO myPtDAO = null;
	
	/*
	 * ¡¡NOTA!!
	 * 
	 * Dado que:
	 * 
	 * "Dado que muchas de las operaciones de negocio giran en torno a las asignaturas,
		es conveniente que esta capa mantenga en caché e indexadas por su identificador
		toda la lista de asignaturas de forma que su búsqueda sea lo más rápida posible y
		evite el acceso a la base de datos."
		
		Entonces, no convendria que la cache de asignaturas fuese un Map en vez de un Set, 
		que es como se intuye que sea (dado que hay un metodo que nos dan en la interfaz 
		getAsignaturas que devuelve las asignaturas como un Set<>).
	 * 
	 */
	private Map<Asignatura,String> asignaturas;
	//private Set<Asignatura> asignaturas;
	
	/*
	 * Metodos
	 */
	
	private PtDAO(){
		
		asignaturas = new HashMap<Asignatura,String>();
		//asignaturas = new HashSet<Asignatura>();
		
	}
	
	public static PtDAO getPtDao(){
		
		if( myPtDAO == null ){
			
			myPtDAO = new PtDAO();
			
		}
		
		return myPtDAO;
	}
	
	public Profesor getProfesor(int idAsignatura){
		/*
		 * ¡¡NOTA!!
		 * 
		 * Una asignatura puede tener varios profesores. Por qué devuelve un unico profesor?
		 */
	}
	
	public Set<Alumno> getAlumnos(int idAsignatura){
		
	}
	
	public List<Evaluacion> getEvaluacionesOrderedByAsignatura(int idAlumno){
		
	}
	
	public Set<Evaluacion> getEvaluaciones(int idAsignatura, int idAlumno){
		
	}
	
	public void addEvaluacion(String concepto, float nota, int idAsignatura, int idAlumno){
		
	}
	
	public Set<Unidad> getUnidades(int idAsignatura){
		
	}
	
	/**
	 * 
	 * @return
	 */
	public Set<Asignatura> getAsignaturas(){
		return asignaturas;
	}
	
	public Alumno getAlumno(int id){
		
	}
	
	public Asignatura getAsignatura(int id){
		
		Asignatura unAsign = null; 
		
		if( asignaturas.containsValue(id) ){
			
			//esta en cache
			
		}else{
			
			//no esta en cache
			
		}
		
	}
	
	public Alumno loginAlumno(int dni, String pass) throws UserNotFoundException, IncorrectPasswordException{
		
	}
	
	public Set<Asignatura> getAsignaturas(int idAlumno){
		
	}
	
	public void matricular(int idAlumno, int idAsignatura){
		
	}
	
	public void desmatricular(int idAlumno, int idAsignatura){
		
	}
	
	public Profesor loginProfesor(int dni, String pass) throws UserNotFoundException, IncorrectPasswordException{
		
	}
	
	public Set<Asignatura> getAsignaturasProfesor(int idProfesor){
		
	}
	
	public Profesor getProfesorByDni(int dni) throws UserNotFoundException{
		
	}
	
	public List<Evaluacion> getEvaluacionesAsignatura(int idAsignatura){
		
	}
	

}
