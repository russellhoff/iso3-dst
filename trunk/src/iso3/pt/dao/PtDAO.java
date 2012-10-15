/**
 * 
 */
package iso3.pt.dao;


import java.sql.*;
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
//asd
public class PtDAO {

	/*
	 * Atributos
	 */
	private static PtDAO myPtDAO = null;
	private Map<Integer, Asignatura> asignaturas;
	private Connection con;

	
	/*
	 * Metodos
	 */
	/**
	 * <h1>Constructora</h1>
	 * <p>Crea una instancia de la clase PtDAO. También carga automáticamente en la caché las asignaturas.</p>
	 */
	private PtDAO(){
		
		asignaturas = new HashMap<Integer, Asignatura>();
		
		String query = "SELECT * FROM Asignaturas";
		
		ResultSet asignsAux = this.realizarConsulta(query);
		
		try {
			while (asignsAux.next()){
				Asignatura as = new Asignatura(
						asignsAux.getInt("ASIGN_ID"),
						asignsAux.getInt("ASIGN_CODIGO"),
						asignsAux.getString("ASIGN_NOMBRE"),
						asignsAux.getFloat("ASIGN_CREDITOS")
				);		
				
				this.asignaturas.put(as.getId(), as);
				
				/*
				 * TODO hace falta cargar las demas relaciones de asignaturas?
				 */
				
			}
			
			this.cerrarConexionBD();
			
		} catch (SQLException e) {
			System.out.println("**Error mientras se cargaban las asignaturas a la caché: " + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	/**
	 * <h1>Realizar consulta SQL</h1>
	 * <p>Dada una consulta sql, realiza esa consulta y devuelve los/el objeto(s) ResultSet.</p>
	 * @param query Consulta SQL.
	 * @return ResultSet Resultado de la consulta SQL.
	 */
	private ResultSet realizarConsulta(String query){
		
		try {
			this.con = DriverManager.getConnection(
			        "jdbc:mysql://localhost/proyectoIso3?" +
			        "user=eside&password=eside");
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			return rs;
			
			
			
		} catch (SQLException e) {
			// TODO
			e.printStackTrace();
			return null;
		}

		
	}
	
	/**
	 * <h1>Cerrar conexión</h1>
	 * <p>Cierra la conexión a la BD.</p>
	 */
	private void cerrarConexionBD(){
		try {
			this.con.close();
		} catch (SQLException e) {
			System.out.println("**Error mientras se cerraba la conexión a la BD: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static PtDAO getPtDao(){
		
		if( myPtDAO == null ){
			
			myPtDAO = new PtDAO();
			
		}
		
		return myPtDAO;
	}
	
	/*
	 * TODO
	 */
	public Profesor getProfesor(Integer idAsignatura){
		
		return this.getAsignatura(idAsignatura).getProfesor();
		
	}
	
	/*
	 * TODO
	 */
	public Set<Alumno> getAlumnos(Integer idAsignatura){
		return this.getAsignatura(idAsignatura).getAlumnos();
	}
	
	/*
	 * TODO
	 */
	public List<Evaluacion> getEvaluacionesOrderedByAsignatura(Integer idAlumno){
		if(  ){
			
		}else{
			
		}
		Asignatura as = this.getAsignatura(idAsignatura);
		Alumno al = as.getAlumnoByDni(idAlumno);
		Set<Evaluacion> evals = al.getEvaluaciones();
		List<Evaluacion> ret = new List<Evaluacion>();
		{
		};
	}
	
	/*
	 * TODO
	 */
	public Set<Evaluacion> getEvaluaciones(Integer idAsignatura, Integer idAlumno){
		Asignatura as = this.getAsignatura(idAsignatura);
		Alumno al = as.getAlumnoByDni(idAlumno);
		return al.getEvaluaciones();
	}
	
	/*
	 * TODO
	 */
	public void addEvaluacion(String concepto, float nota, Integer idAsignatura, Integer idAlumno){
		
	}
	
	/*
	 * TODO
	 */
	public Set<Unidad> getUnidades(Integer idAsignatura){
		return this.getAsignatura(idAsignatura).getUnidades();
	}
	
	/*
	 * TODO
	 */
	public void addAsignatura(Asignatura asignatura){
		this.asignaturas.put(asignatura.getId(), asignatura);
	}
	
	/*
	 * TODO
	 */
	public Set<Asignatura> getAsignaturas(){
		return asignaturas;
	}
	
	/**
	 * <h1>Obtener un alumno</h1>
	 * <p>Devuelve el alumno dado un identificador</p>
	 * @param id DNI del alumno
	 * @return El Alumno. Si hay excepción, devuelve null;
	 */
	public Alumno getAlumno(Integer id){
		ResultSet rs = this.realizarConsulta("SELECT * FROM Alumnos WHERE Alumnos.ALM_DNI='" + id + "' LIMIT 1");
	
		try {
			rs.next();
			Alumno al = new Alumno(
					rs.getInt("ALM_DNI"),
					rs.getString("ALM_PASSWORD"),
					rs.getString("ALM_NOMBRE"),
					rs.getString("ALM_TELEFONO")
			);	
			
			this.cerrarConexionBD();
			
			return al;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	/*
	 * TODO
	 */
	public Asignatura getAsignatura(Integer id){
		
		Asignatura unAsign = null; 
		
		if( asignaturas.containsKey(id) ){
			//esta en la cache
			
			unAsign = asignaturas.get(id);
			
		}/*else{
			
			//no esta en cache --> buscar en la sesion
			
			esto no seria asi??
			
		}*/
		
		return unAsign;
		
	}
	
	/*
	 * TODO
	 */
	public Alumno loginAlumno(Integer dni, String pass) throws UserNotFoundException, IncorrectPasswordException{
		
	}
	
	/*
	 * TODO
	 */
	public Set<Asignatura> getAsignaturas(Integer idAlumno){
		
	}
	
	/*
	 * TODO
	 */
	public void matricular(Integer idAlumno, Integer idAsignatura){
		
	}
	
	/*
	 * TODO
	 */
	public void desmatricular(Integer idAlumno, Integer idAsignatura){
		
	}
	
	/*
	 * TODO
	 */
	public Profesor loginProfesor(Integer dni, String pass) throws UserNotFoundException, IncorrectPasswordException{
		
	}
	
	/*
	 * TODO
	 */
	public Set<Asignatura> getAsignaturasProfesor(Integer idProfesor){
		
	}
	
	/*
	 * TODO
	 */
	public Profesor getProfesorByDni(Integer dni) throws UserNotFoundException{
		
	}
	
	/*
	 * TODO
	 */
	public List<Evaluacion> getEvaluacionesAsignatura(Integer idAsignatura){
		
	}
	
}
