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
 * <h1>Clase que cumple el patr�n DAO (Data Access Object) y Singleton.</h1>
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
	 * <b>OK</b>
	 * <h1>Constructora</h1>
	 * <p>Crea una instancia de la clase PtDAO. Tambi�n carga autom�ticamente en la cach� las asignaturas.</p>
	 */
	private PtDAO(){
		
		factory = new Configuration().configure().buildSessionFactory();
		this.openSession();
		this.cargarAsignaturas();				
	}
	
	private void cargarAsignaturas(){
		
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
			/*Iterator<Entry<Integer, Asignatura>> it2 = this.asignaturas.entrySet().iterator();
			Asignatura asigAux = null;
			
			while(it2.hasNext()){
				Map.Entry<Integer,Asignatura> e= (Map.Entry<Integer,Asignatura>)it2.next();
				asigAux = (Asignatura)e.getValue();
				System.out.println("Asignatura #" + e.getKey() + ": " + asigAux.getNombre() + " (" + asigAux.getCreditos() + ")");
			}*/
			
			//this.closeSession(); <-- no funciona sino!!
			
		} catch (Exception e) {
			System.out.println("Error en la consulta de asignaturas: " + e.getMessage() + ". Mas info: " + e.getStackTrace());
			this.closeSession();
		}
	}
	
	/**
	 * <b>OK</b>
	 * <h1>Crear una sesi�n</h1>
	 * <p>Crear una sesi�n de hibernate</p>
	 */
	private void openSession(){
		session = factory.openSession();
	}
	
	/**
	 * <b>OK</b>
	 * <h1>Cerrar una sesi�n</h1>
	 * <p>Cerrar una sesi�n de hibernate</p>
	 */
	private void closeSession(){
		session.close();
	}
	
	/**
	 * <b>OK</b>
	 * <h1>Iniciar transaccion</h1>
	 * <p>Inicia una transaccion</p>
	 */
	private void beginTransaction(){
		this.tx = null;
		this.tx = session.beginTransaction();
	}
	
	/**
	 * <b>OK</b>
	 * <h1>Validar una transaccion</h1>
	 */
	private void commitTransaction(){
		this.tx.commit();
	}
	
	/**
	 * <b>OK</b>
	 * <h1>Deshacer un cambio</h1>
	 */
	private void rollbackTransaction(){
		if ( this.tx != null )
			this.tx.rollback();
	}
	
	/**
	 * <b>OK</b>
	 * <h1>Devolver la instancia DAO</h1>
	 * <p>Devuelve la �nica instancia de PtDAO. Si no existe, crea una.</p>
	 * @return PtDAO
	 */
	public static PtDAO getPtDao(){
		
		if( myPtDAO == null ){
			
			myPtDAO = new PtDAO();
			
		}
		
		return myPtDAO;
	}
	
	/**
	 * <b>OK</b>
	 * <h1>Obtener el profesor de una asignatura.</h1>
	 * <p>Devuelve el profesor de una asignatura, dado el identificador de la asignatura.</p>
	 * @param idAsignatura
	 * @return Profesor
	 */
	public Profesor getProfesor(Integer idAsignatura){
		
		return this.asignaturas.get(idAsignatura).getProfesor();
		
	}
	
	/**
	 * <b>OK</b>
	 * <h1>Obtiene los alumnos de una asignatura.</h1>
	 * <p>Devuelve los alumnos de una asignatura.</p>
	 * @param idAsignatura
	 * @return Set de Alumnos.
	 */
	public Set<Alumno> getAlumnos(Integer idAsignatura){
		return this.getAsignatura(idAsignatura).getAlumnos();
	}
	
	/**
	 * <b>OK</b>
	 * <h1>Obtiene las evaluaciones de un alumno</h1>
	 * <p>Devuelve las evaluaciones de un alumno ordenadas por asignaturas.</p>
	 * @param idAlumno DNI del alumno.
	 * @return Lista de evaluaciones.
	 */
	public List<Evaluacion> getEvaluacionesOrderedByAsignatura(Integer idAlumno){
		
		/*
		 * Con una consulta simple HQuery, nos ordena las evaluaciones por id de asignatura (Group by u Order by).
		 */
		
		
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
			
		}			
		
	}
	
	/**
	 * <b>OK</b>
	 * <h1>Obtiene las evaluaciones de un alumno en una asignatura.</h1>
	 * <p>Devuelve las evaluaciones de un alumno en una asignatura, dados los ids de alumno y asignatura.</p>
	 * @param idAsignatura Identificador de la asignatura.
	 * @param idAlumno DNI del alumno
	 * @return Set de evaluaciones.
	 */
	public Set<Evaluacion> getEvaluaciones(Integer idAsignatura, Integer idAlumno){
		Asignatura as = this.getAsignatura(idAsignatura);
		//System.out.println(as.toString());
		Alumno al = as.getAlumnoByDni(idAlumno);
		//System.out.println(al.toString());
		
		
		Set<Evaluacion> evs = al.getEvaluaciones();
		Iterator<Evaluacion> it = evs.iterator();
		Evaluacion ev = null;
		
		Set<Evaluacion> evsAlmAsign = new HashSet<Evaluacion>();
		
		while( it.hasNext() ){
			ev = it.next();
			
			if( ev.getAsignatura().getId().equals(idAsignatura) )
				evsAlmAsign.add(ev);
						
		}
		
		return evsAlmAsign;
		
	}
	
	/**
	 * <b>OK</b>
	 * <h1>A�ade una evalaci�n.</h1>
	 * <p>Dadas una asignatura, alumno y tanto concepto como nota, crea una evaluaci�n a un alumno en una asignatura.</p>
	 * @param concepto Concepto de evaluaci�n.
	 * @param nota Nota de la evaluaci�n.
	 * @param idAsignatura La asignatura.
	 * @param idAlumno El alumno.
	 */
	public void addEvaluacion(String concepto, float nota, Integer idAsignatura, Integer idAlumno){
		Asignatura asign = this.getAsignatura(idAsignatura);
		Alumno alm = this.getAlumno(idAlumno);
		
		System.out.println("Inserci�n de evaluaci�n");
		
		try {
			
			this.beginTransaction();
			session.save(new Evaluacion(concepto, nota, asign, alm));
			this.commitTransaction();
			
		} catch (Exception e) {
			this.rollbackTransaction();
			this.closeSession();
			System.out.println("Error al insertar evaluaci�n: " + e.getMessage());
		}
		
	}
	
	/**
	 * <b>OK</b>
	 * <h1>Obtener las unidades de una asignatura.</h1>
	 * <p>Devuelve las unidades de una asignatura determinada.</p>
	 * @param idAsignatura Identificador de la asignatura.
	 * @return Un Set de Unidades
	 */
	public Set<Unidad> getUnidades(Integer idAsignatura){
		return this.getAsignatura(idAsignatura).getUnidades();
	}
	
	/**
	 * <b>OK</b>
	 * <h1>A�adir una asignatura.</h1>
	 * <p>A�ade una asignatura.</p>
	 * @param asignatura La asignatura a a�adir.
	 */
	public void addAsignatura(Asignatura asignatura){
		
		System.out.println("A�adir asignatura");
		
		try {
			
			this.beginTransaction();
			session.save(asignatura);
			this.commitTransaction();
			this.asignaturas.put(asignatura.getId(), asignatura);
			
		} catch (Exception e) {
			this.rollbackTransaction();
			this.asignaturas.remove(asignatura);
			this.closeSession();
			System.out.println("Error al insertar evaluaci�n: " + e.getMessage());
		}
	}
	
	/**
	 * <b>OK</b>
	 * <h1>Obtener las asignaturas</h1>
	 * <p>Devuelve las asignaturas en una lista.</p>
	 * @return
	 */
	public Set<Asignatura> getAsignaturas(){
		return new HashSet<Asignatura>(asignaturas.values());
	}
	
	/**
	 * <b>OK</b>
	 * <h1>Obtener un alumno</h1>
	 * <p>Devuelve el alumno dado un identificador (dni).</p>
	 * @param id DNI del alumno
	 * @return El Alumno. Si hay excepci�n, devuelve null;
	 */
	public Alumno getAlumno(Integer id){
		
		Query q = null;
		
		try {
			
			q = session.createQuery("from Alumno as al where al.dni=:dni");
			q.setInteger("dni", id);
			@SuppressWarnings("unchecked")
			List<Alumno> alms = q.list();
			
			if(alms.size() != 0 )
				return alms.get(0);
			else
				return null;
			
		} catch (Exception e) {
			System.out.println("Error al obtener alumno: " + e.getMessage());
			return null;
			
		}/*finally{
			//si se hace esto no funciona!!
			this.closeSession();
				
		}*/
			
			
		
	}
	
	/**
	 * <b>OK</b>
	 * <h1>Obtener asignatura</h1>
	 * <p>Devuelve la asignatura que tiene un identificador determinado.</p>
	 * @param id El identificador de la asignatura
	 * @return La Asignatura
	 */
	public Asignatura getAsignatura(Integer id){
		
		return this.asignaturas.get(id);
		
	}
	
	/**
	 * <b>OK</b>
	 * <h1>Loguear alumno</h1>
	 * <p>Dado un dni y una contrase�a, devuelve el Alumno correspondiente (el proceso de loguear).</p>
	 * @param dni El DNI del alumno.
	 * @param pass Contrase�a del alumno
	 * @return Alumno. Si excepci�n, devuelve null;
	 * @throws UserNotFoundException
	 * @throws IncorrectPasswordException
	 */
	public Alumno loginAlumno(Integer dni, String pass) throws UserNotFoundException, IncorrectPasswordException{
		
		Query q = session.createQuery("from Alumno as al where al.dni=:dni");
		q.setInteger("dni", dni);
		@SuppressWarnings("unchecked")
		List<Alumno> alms = q.list();
		Iterator<Alumno> it = alms.iterator();
		
		if(!it.hasNext())
			
			throw new UserNotFoundException(dni);
		
		else{
			
			Alumno alm = (Alumno)it.next();
			
			if( alm.getPassword().equals(pass) ){
				//this.closeSession(); <-- no funciona sino!!
				return alm;
			}else{
				//this.closeSession(); <-- no funciona sino!!
				throw new IncorrectPasswordException();
			}
		}
		
	}
	
	
	/**
	 * <b>OK</b>
	 * <h1>Devuelve las asignaturas en las que est� matriculado un alumno</h1>
	 * <p>Dado un id de alumno, devuelve sus asignaturas en las que est� matriculado.</p>
	 * @param idAlumno El DNI del alumno
	 * @return Set de asignaturas.
	 */
	public Set<Asignatura> getAsignaturas(Integer idAlumno){
		
		/*Iterator<Entry<Integer, Asignatura>> it = this.asignaturas.entrySet().iterator();
		Set<Asignatura> asignaturasAlumno = new HashSet<Asignatura>();
		Asignatura asigAux = null;
		
		while(it.hasNext()){
			
			Map.Entry<Integer,Asignatura> e= (Map.Entry<Integer,Asignatura>)it.next();
			asigAux = (Asignatura)e.getValue();	
			
			if( asigAux.estaMatriculadoAlumno(idAlumno) ){
				asignaturasAlumno.add(asigAux);
			}
			
		}
		
		return asignaturasAlumno;	*/
		
		Alumno alm = this.getAlumno(idAlumno);
		return alm.getAsignaturas();
		
	}
	
	/**
	 * <h1>OK</h1>
	 * <h1>Matricular un alumno en una asignatura.</h1>
	 * <p>Matricula a un alumno en una asignatura.</p>
	 * @param idAlumno
	 * @param idAsignatura
	 */
	public void matricular(int idAlumno, int idAsignatura){
		
			this.beginTransaction();	
					
			System.out.println("Matricular a alumno en una asignatura");
			Alumno alm = this.getAlumno(idAlumno);
			System.out.println(alm.toString());
			Asignatura asign = this.getAsignatura(idAsignatura);
			System.out.println(asign.toString());
			
			alm.addAsignatura(asign);
			System.out.println("Asociada la asignatura al alumno");
			
			asign.addAlumnos(alm);
			System.out.println("Asociada la asignatura al alumno");
			
			session.update(alm);
			System.out.println("Alumno updated");
			
			session.update(asign);
			System.out.println("Asignatura updated");
			
			this.commitTransaction();
			
		
	}
	
	
	/**
	 * <h1>OK</h1>
	 * <h1>Desmatricular un alumno en una asignatura.</h1>
	 * <p>Desmatricula a un alumno en una asignatura.</p>
	 * @param idAlumno
	 * @param idAsignatura
	 */
	public void desmatricular(Integer idAlumno, Integer idAsignatura){
		Asignatura asign = this.getAsignatura(idAsignatura);
		Alumno alm = this.getAlumno(idAlumno);
		
		System.out.println("Desmatricular a alumno en una asignatura");
		
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
	 * <b>OK</b>
	 * <h1>Loguear profesor</h1>
	 * <p>Dado un dni y una password, devuelve el profesor logueado.</p>
	 * @param dni El Dni del profesor
	 * @param pass Contrase�a del profesor
	 * @return Profesor, si ocurre excepci�n, devuelve null
	 * @throws UserNotFoundException
	 * @throws IncorrectPasswordException
	 */
	public Profesor loginProfesor(Integer dni, String pass) throws UserNotFoundException, IncorrectPasswordException{
		
		Query q = session.createQuery("from Profesor as p where p.dni=:dni");
		q.setInteger("dni", dni);
		@SuppressWarnings("unchecked")
		List<Profesor> ps = q.list();
		Iterator<Profesor> it = ps.iterator();
		
		if(!it.hasNext())
			
			throw new UserNotFoundException(dni);
		
		else{
			
			Profesor p = (Profesor)it.next();
			
			if( p.getPassword().equals(pass) ){
				//this.closeSession(); <-- no funciona sino!!
				return p;
			}else{
				//this.closeSession(); <-- no funciona sino!!
				throw new IncorrectPasswordException();
			}
		}
	
		
		
		
	}
	
	/**
	 * <h1>OK</h1>
	 * <h1>Devuelve las asignaturas que imparte un profesor dado su DNI.</h1>
	 * <p>Dado un identificador de un profesor, el m�todo obtiene en un Set las asignaturas que imparte.</p>
	 * @param idProfesor Identificador del profesor, DNI del profesor.
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
				
			}/*finally{
				//no funciona sino!!
				this.closeSession();
				
			}*/
		 
		

		Iterator<Entry<Integer, Asignatura>> it = this.asignaturas.entrySet().iterator();
		Set<Asignatura> asignaturasProf = new HashSet<Asignatura>();
		Asignatura asigAux = null;
		
		while(it.hasNext()){
			
			Map.Entry<Integer,Asignatura> e= (Map.Entry<Integer,Asignatura>)it.next();
			asigAux = (Asignatura)e.getValue();	
			
			if( asigAux.getProfesor().getDni().equals(idProfesor) ){
				asignaturasProf.add(asigAux);
			}
			
		}
		
		return asignaturasProf;
		
		
	}
	
	/**
	 * <h1>OK</h1>
	 * <h1>Devuelve un profesor con un dni.</h1>
	 * <p>Dado un DNI, devuelve el profesor asociado.</p>
	 * @param dni El dni del profesor.
	 * @return Profesor El profesor.
	 * @throws UserNotFoundException Cuando no se encuentra un profesor con ese dni.
	 */
	public Profesor getProfesorByDni(Integer dni) throws UserNotFoundException{
		
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
			
		}/*finally{
			//no funciona sino!!
			this.closeSession();
				
		}*/
		
	}
	
	/**
	 * <h1>OK</h1>
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
			
		}/*finally{
			//no funciona sino!!
			this.closeSession();
				
		}*/
		
	}
	
	
}
