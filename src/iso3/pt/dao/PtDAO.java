/**
 * 
 */
package iso3.pt.dao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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
	private SessionFactory factory;
	private Transaction tx;
	private static Session session;

	
	/*
	 * Metodos
	 */
	/**
	 * <h1>Constructora</h1>
	 * <p>Crea una instancia de la clase PtDAO. También carga automáticamente en la caché las asignaturas.</p>
	 */
	private PtDAO(){
		
		factory = new Configuration().configure().buildSessionFactory();
		this.openSession();
		asignaturas = new HashMap<Integer, Asignatura>();
		
		Query q = null;
		
		try {
			
			q = session.createQuery("from Asignatura");
			
			@SuppressWarnings("unchecked")
			List<Asignatura> ass = q.list();
			
			Iterator<Asignatura> it = ass.iterator();
			Asignatura asig = null;
			while(it.hasNext()){
				asig = it.next();
				this.asignaturas.put(asig.getId(), asig);
			}
			
			//Mostrar una asignatura:
			Iterator<Entry<Integer, Asignatura>> it2 = this.asignaturas.entrySet().iterator();
			Asignatura asigAux = null;
			
			while(it2.hasNext()){
				Map.Entry<Integer,Asignatura> e= (Map.Entry<Integer,Asignatura>)it2.next();
				asigAux = (Asignatura)e.getValue();
				//System.out.println("Asignatura #" + e.getKey() + ": " + asigAux.getNombre() + " (" + asigAux.getCreditos() + ")");
			}
			
			this.closeSession();
			
		} catch (Exception e) {
			System.out.println("Error en la consulta de asignaturas: " + e.getMessage() + ". Mas info: " + e.getStackTrace());
			this.closeSession();
		}
				
	}
	
	/**
	 * <h1>Crear una sesión</h1>
	 * <p>Crear una sesión de hibernate</p>
	 */
	private void openSession(){
		session = factory.openSession();
	}
	
	/**
	 * <h1>Cerrar una sesión</h1>
	 * <p>Cerrar una sesión de hibernate</p>
	 */
	private void closeSession(){
		session.close();
	}
	
	private void beginTransaction(){
		this.tx = null;
		this.openSession();
		this.tx = session.beginTransaction();
	}
	
	private void commitTransaction(){
		this.tx.commit();
	}
	
	private void rollbackTransaction(){
		if ( this.tx != null )
			this.tx.rollback();
	}
	
	/**
	 * <h1>Devolver la instancia DAO</h1>
	 * <p>Devuelve la única instancia de PtDAO. Si no existe, crea una.</p>
	 * @return PtDAO
	 */
	public static PtDAO getPtDao(){
		
		if( myPtDAO == null ){
			
			myPtDAO = new PtDAO();
			
		}
		
		return myPtDAO;
	}
	
	/**
	 * <h1>Obtener el profesor de una asignatura.</h1>
	 * <p>Devuelve el profesor de una asignatura, dado el identificador de la asignatura.</p>
	 * @param idAsignatura
	 * @return Profesor
	 */
	public Profesor getProfesor(Integer idAsignatura){
		
		return this.getAsignatura(idAsignatura).getProfesor();
		
	}
	
	/**
	 * <h1>Obtiene los alumnos de una asignatura.</h1>
	 * <p>Devuelve los alumnos de una asignatura.</p>
	 * @param idAsignatura
	 * @return Set de Alumnos.
	 */
	public Set<Alumno> getAlumnos(Integer idAsignatura){
		return this.getAsignatura(idAsignatura).getAlumnos();
	}
	
	/**
	 * <h1>Obtiene las evaluaciones de un alumno</h1>
	 * <p>Devuelve las evaluaciones de un alumno ordenadas por asignaturas.</p>
	 * @param idAlumno DNI del alumno.
	 * @return Lista de evaluaciones.
	 */
	public List<Evaluacion> getEvaluacionesOrderedByAsignatura(Integer idAlumno){
		
		/*
		 * Con una consulta simple HQuery, nos ordena las evaluaciones por id de asignatura (Group by u Order by).
		 */
		
		this.openSession();
		
		Query q = null;
		
		try {
			
			q = session.createQuery("select eva from Alumno as alum, Evaluacion as eva"
					+ " where alum=eva.alumno and alum.dni = :idalumno order by eva.asignatura DESC");
			q.setInteger("idalumno", idAlumno);
			@SuppressWarnings("unchecked")
			List<Evaluacion> es = q.list();
			
			return es;
			
		}catch (Exception e) {
			System.out.println("Error al obtener las evaluaciones de un alumno ordenadas por asignatura: " + e.getMessage());
			return null;
			
		}finally{

			this.closeSession();
				
		}
			
		
	}
	
	/**
	 * <h1>Obtiene las evaluaciones de un alumno en una asignatura.</h1>
	 * <p>Devuelve las evaluaciones de un alumno en una asignatura, dados los ids de alumno y asignatura.</p>
	 * @param idAsignatura Identificador de la asignatura.
	 * @param idAlumno DNI del alumno
	 * @return Set de evaluaciones.
	 */
	public Set<Evaluacion> getEvaluaciones(Integer idAsignatura, Integer idAlumno){
		Asignatura as = this.getAsignatura(idAsignatura);
		Alumno al = as.getAlumnoByDni(idAlumno);
		return al.getEvaluaciones();
		//no hay que hacerlo con consultas porque tenemos las asignaturas mapeadas:
		//cuantas menos consultas, menos acceso a disco y más eficiente será la aplicación
		// (tiempo de acceso a disco >> tiempo de acceso a memoria ram)
	}
	
	/**
	 * <h1>Añade una evalación.</h1>
	 * <p>Dadas una asignatura, alumno y tanto concepto como nota, crea una evaluación a un alumno en una asignatura.</p>
	 * @param concepto Concepto de evaluación.
	 * @param nota Nota de la evaluación.
	 * @param idAsignatura La asignatura.
	 * @param idAlumno El alumno.
	 */
	public void addEvaluacion(String concepto, float nota, Integer idAsignatura, Integer idAlumno){
		Asignatura asign = this.getAsignatura(idAsignatura);
		Alumno alm = this.getAlumno(idAlumno);
		
		System.out.println("Inserción de evaluación");
		this.openSession();
		
		try {
			
			this.beginTransaction();
			session.save(new Evaluacion(concepto, nota, asign, alm));
			this.commitTransaction();
			
		} catch (Exception e) {
			this.rollbackTransaction();
			this.closeSession();
			System.out.println("Error al insertar evaluación: " + e.getMessage());
		}
		
	}
	
	/**
	 * <h1>Obtener las unidades de una asignatura.</h1>
	 * <p>Devuelve las unidades de una asignatura determinada.</p>
	 * @param idAsignatura Identificador de la asignatura.
	 * @return Un Set de Unidades
	 */
	public Set<Unidad> getUnidades(Integer idAsignatura){
		return this.getAsignatura(idAsignatura).getUnidades();
	}
	
	/**
	 * <h1>Añadir una asignatura.</h1>
	 * <p>Añade una asignatura.</p>
	 * @param asignatura La asignatura a añadir.
	 */
	public void addAsignatura(Asignatura asignatura){
		
		System.out.println("Inserción de evaluación");
		this.openSession();
		
		try {
			
			this.beginTransaction();
			session.save(asignatura);
			this.commitTransaction();
			this.asignaturas.put(asignatura.getId(), asignatura);
			
		} catch (Exception e) {
			this.rollbackTransaction();
			this.asignaturas.remove(asignatura);
			this.closeSession();
			System.out.println("Error al insertar evaluación: " + e.getMessage());
		}
	}
	
	/**
	 * <h1>Obtener las asignaturas</h1>
	 * <p>Devuelve las asignaturas en una lista.</p>
	 * @return
	 */
	public Set<Asignatura> getAsignaturas(){
		return new HashSet<Asignatura>(asignaturas.values());
	}
	
	/**
	 * <h1>Obtener un alumno</h1>
	 * <p>Devuelve el alumno dado un identificador (dni).</p>
	 * @param id DNI del alumno
	 * @return El Alumno. Si hay excepción, devuelve null;
	 */
	public Alumno getAlumno(Integer id){
		
		this.openSession();
		
		Query q = null;
		
		try {
			
			q = session.createQuery("from Alumno as al where al.dni=:dni");
			q.setInteger("dni", id);
			@SuppressWarnings("unchecked")
			List<Alumno> alms = q.list();
			Iterator<Alumno> it = alms.iterator();
			
			if( it.hasNext() )
				return (Alumno) it.next();
			else
				return null;
			
		} catch (Exception e) {
			System.out.println("Error al obtener alumno: " + e.getMessage());
			return null;
			
		}finally{

			this.closeSession();
				
		}
			
			
		
	}
	
	/**
	 * <h1>Obtener asignatura</h1>
	 * <p>Devuelve la asignatura que tiene un identificador determinado.</p>
	 * @param id El identificador de la asignatura
	 * @return La Asignatura
	 */
	public Asignatura getAsignatura(Integer id){
		
		return this.asignaturas.get(id);
		
	}
	
	/**
	 * <h1>Loguear alumno</h1>
	 * <p>Dado un dni y una contraseña, devuelve el Alumno correspondiente (el proceso de loguear).</p>
	 * @param dni El DNI del alumno.
	 * @param pass Contraseña del alumno
	 * @return Alumno. Si excepción, devuelve null;
	 * @throws UserNotFoundException
	 * @throws IncorrectPasswordException
	 */
	public Alumno loginAlumno(Integer dni, String pass) throws UserNotFoundException, IncorrectPasswordException{
		
		this.openSession();
		
		Query q = null;
		
		try {
			
			q = session.createQuery("from Alumno as al where al.dni=:dni");
			q.setInteger("dni", dni);
			@SuppressWarnings("unchecked")
			List<Alumno> alms = q.list();
			Iterator<Alumno> it = alms.iterator();
			
			if(!it.hasNext())
				
				throw new UserNotFoundException(dni);
			
			else{
				
				Alumno alm = (Alumno)it.next();
				
				if( alm.getPassword().equals(pass) )
					return alm;
				else
					throw new IncorrectPasswordException();
				
			}
			
		} catch (Exception e) {
			
			System.out.println("Error al loguear alumno: " + e.getMessage());
			return null;
			
		}finally{

			this.closeSession();
				
		}
		
	}
	
	
	/**
	 * <h1>Devuelve las asignaturas en las que está matriculado un alumno</h1>
	 * <p>Dado un id de alumno, devuelve sus asignaturas en las que está matriculado.</p>
	 * @param idAlumno El DNI del alumno
	 * @return Set de asignaturas.
	 */
	public Set<Asignatura> getAsignaturas(Integer idAlumno){
		
		Iterator<Entry<Integer, Asignatura>> it = this.asignaturas.entrySet().iterator();
		Set<Asignatura> asignaturasAlumno = new HashSet<Asignatura>();
		Asignatura asigAux = null;
		
		while(it.hasNext()){
			
			Map.Entry<Integer,Asignatura> e= (Map.Entry<Integer,Asignatura>)it.next();
			asigAux = (Asignatura)e.getValue();	
			
			if( asigAux.estaMatriculadoAlumno(idAlumno) ){
				asignaturasAlumno.add(asigAux);
			}
			
		}
		
		return asignaturasAlumno;			
		
	}
	
	/**
	 * <h1>Matricular un alumno en una asignatura.</h1>
	 * <p>Matricula a un alumno en una asignatura.</p>
	 * @param idAlumno
	 * @param idAsignatura
	 */
	public void matricular(Integer idAlumno, Integer idAsignatura){
		
		Asignatura asign = this.getAsignatura(idAsignatura);
		Alumno alm = this.getAlumno(idAlumno);
		
		System.out.println("Matricular a alumno en una asignatura");
		this.openSession();
		
		asign.addAlumnos(alm);
		alm.addAsignatura(asign);
		
		try {
			
			this.beginTransaction();
			session.update(asign);
			session.update(alm);
			this.commitTransaction();
			
		} catch (Exception e) {
			this.rollbackTransaction();
			
			alm.removeAsignatura(asign);
			asign.removeAlumnos(alm);
			
			this.closeSession();
			System.out.println("Error al matricular un alumno de una asignatura: " + e.getMessage());
		}
	}
	
	/**
	 * <h1>Desmatricular un alumno en una asignatura.</h1>
	 * <p>Desmatricula a un alumno en una asignatura.</p>
	 * @param idAlumno
	 * @param idAsignatura
	 */
	public void desmatricular(Integer idAlumno, Integer idAsignatura){
		Asignatura asign = this.getAsignatura(idAsignatura);
		Alumno alm = this.getAlumno(idAlumno);
		
		System.out.println("Desmatricular a alumno en una asignatura");
		this.openSession();
		
		alm.removeAsignatura(asign);
		asign.removeAlumnos(alm);
		
		try {
			
			this.beginTransaction();
			session.update(asign);
			session.update(alm);
			this.commitTransaction();
			
		} catch (Exception e) {
			this.rollbackTransaction();
			
			asign.addAlumnos(alm);
			alm.addAsignatura(asign);
			
			this.closeSession();
			System.out.println("Error al desmatricular un alumno de una asignatura: " + e.getMessage());
		}
	}
	
	/**
	 * <h1>Loguear profesor</h1>
	 * <p>Dado un dni y una password, devuelve el profesor logueado.</p>
	 * @param dni El Dni del profesor
	 * @param pass Contraseña del profesor
	 * @return Profesor, si ocurre excepción, devuelve null
	 * @throws UserNotFoundException
	 * @throws IncorrectPasswordException
	 */
	public Profesor loginProfesor(Integer dni, String pass) throws UserNotFoundException, IncorrectPasswordException{
		
		this.openSession();
		
		Query q = null;
		
		try {
			
			q = session.createQuery("from Profesor as p where p.dni=:dni");
			q.setInteger("dni", dni);
			@SuppressWarnings("unchecked")
			List<Profesor> ps = q.list();
			Iterator<Profesor> it = ps.iterator();
			
			if(!it.hasNext())
				
				throw new UserNotFoundException(dni);
			
			else{
				
				Profesor p = (Profesor)it.next();
				
				if( p.getPassword().equals(pass) )
					return p;
				else
					throw new IncorrectPasswordException();
				
			}
			
		} catch (Exception e) {
			
			System.out.println("Error al loguear alumno: " + e.getMessage());
			return null;
			
		}finally{

			this.closeSession();
				
		}
		
	}
	
	/**
	 * <h1>Devuelve las asignaturas que imparte un profesor.</h1>
	 * <p>Dado un identificador de un profesor, el método obtiene en un Set las asignaturas que imparte.</p>
	 * @param idProfesor Identificador del profesor.
	 * @return Set<Asignatura> La lista de las asignaturas.
	 */
	public Set<Asignatura> getAsignaturasProfesor(Integer idProfesor){
		//sin consulta xq tenemos las asignaturas cacheadas
		/*
		 * this.openSession();
		 * 
		 * Query q = null;
		
			try {
			
				q = session.createQuery("from Asignatura as as where as.profesor=:idprof");
				q.setInteger("idprof", idProfesor);
				@SuppressWarnings("unchecked")
				List<Asignatura> ass = q.list();
				Iterator<Asignatura> it = ass.iterator();
				
				Set<Asignatura> listaAsignaturasDevolver = new HashSet<Asignatura>();
				
				while(it.hasNext()){
				
					listaAsignaturasDevolver.add((Asignatura)it.next());
									
				}
				
				return listaAsignaturasDevolver;
			
			} catch (Exception e) {
			
				System.out.println("Error al obtener las asignatura de un profesor: " + e.getMessage());
				return null;
				
			}finally{
	
				this.closeSession();
				
			}
		 * 
		 */
		

		Iterator<Entry<Integer, Asignatura>> it = this.asignaturas.entrySet().iterator();
		Set<Asignatura> asignaturasProf = new HashSet<Asignatura>();
		Asignatura asigAux = null;
		
		while(it.hasNext()){
			
			Map.Entry<Integer,Asignatura> e= (Map.Entry<Integer,Asignatura>)it.next();
			asigAux = (Asignatura)e.getValue();	
			
			if( asigAux.getProfesor().getId().equals(idProfesor) ){
				asignaturasProf.add(asigAux);
			}
			
		}
		
		return asignaturasProf;
		
		
	}
	
	/**
	 * <h1>Devuelve un profesor con un dni.</h1>
	 * <p>Dado un DNI, devuelve el profesor asociado.</p>
	 * @param dni El dni del profesor.
	 * @return Profesor El profesor.
	 * @throws UserNotFoundException Cuando no se encuentra un profesor con ese dni.
	 */
	public Profesor getProfesorByDni(Integer dni) throws UserNotFoundException{
		
		this.openSession();
		
		Query q = null;
		
		try {
			
			q = session.createQuery("from Profesor as p where p.dni=:dni");
			q.setInteger("dni", dni);
			@SuppressWarnings("unchecked")
			List<Profesor> ps = q.list();
			Iterator<Profesor> it = ps.iterator();
			
			if( !it.hasNext() ){
				throw new UserNotFoundException(dni);
			}else{
				
				return (Profesor) it.next();
				
			}
			
		} catch (Exception e) {
			
			System.out.println("Error al obtener un profesor con su dni: " + e.getMessage());
			return null;
			
		}finally{

			this.closeSession();
				
		}
		
	}
	
	/**
	 * <h1>Devuelve todas evaluaciones de una asignatura</h1>
	 * <p>Dado un identificador de una asignatura, devuelve todas las evaluaciones correspondientes a la asignatura esa.</p>
	 * @param idAsignatura El identificador de la asignatura
	 * @return Lista de evaluaciones.
	 */
	public List<Evaluacion> getEvaluacionesAsignatura(Integer idAsignatura){
		
		/*
		 * No se puede hacer con las asignaturas mapeadas
		 * porque las asignaturas no guardan referencias de sus evaluaciones.
		 */
		
		this.openSession();
		
		Query q = null;
		
		try {
			
			q = session.createQuery("select eva from Asignatura as asign, Evaluacion as eva"
					+ " where asign=eva.asignatura and asign.id = :idasign");
			q.setInteger("idasign", idAsignatura);
			@SuppressWarnings("unchecked")
			List<Evaluacion> es = q.list();
			Iterator<Evaluacion> it = es.iterator();
			
			List<Evaluacion> listaEvaluaciones = new ArrayList<Evaluacion>();
			
			while( it.hasNext() ){
				
				listaEvaluaciones.add((Evaluacion) it.next());
				
			}
			
			return listaEvaluaciones;
			
		} catch (Exception e) {
			
			System.out.println("Error al obtener las evaluaciones dado el identificador de una asignatura: " + e.getMessage());
			return null;
			
		}finally{

			this.closeSession();
				
		}
		
	}
	
}
