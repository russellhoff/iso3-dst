/**
 * 
 */
package iso3.pt.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import iso3.pt.model.Alumno;
import iso3.pt.model.Asignatura;
import iso3.pt.model.Evaluacion;
import iso3.pt.model.Profesor;
import iso3.pt.model.Unidad;

/*import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;*/


/**
 * @author Jon_Inazio
 * <h1>Preparación de datos de BBDD</h1>
 * <p>Esta clase preparara, creara y guardara los datos en la BBDD necesarios para trabajar con la aplicación</p>
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		PtDAO ptDao = PtDAO.getPtDao();
		
		/*Alumno al = ptDao.getAlumno(1067499);
		System.out.println(al.toString());
		
		System.out.println(ptDao.getProfesor(1).toString());
		
		Set<Asignatura> asigs = al.getAsignaturas();
		Iterator<Asignatura> it = asigs.iterator();
		while(it.hasNext()){
			System.out.println(it.next().toString());
		}
		
		Set<Evaluacion> evs = al.getEvaluaciones();
		Iterator<Evaluacion> it2 = evs.iterator();
		while(it2.hasNext()){
			System.out.println(it2.next().toString());
		}

		try {
			System.out.println(ptDao.getProfesorByDni(80409525).toString());
		} catch (UserNotFoundException e) {
			System.out.println("Profesor no cargado");
		}*/
		
		//System.out.println(ptDao.getProfesor(1).toString());
		
		/*Set<Alumno> s = ptDao.getAlumnos(1);
		Iterator<Alumno> it = s.iterator();
		while(it.hasNext()){
			System.out.println(it.next().toString());
		}*/
		
		/*List<Evaluacion> a = ptDao.getEvaluacionesAsignatura(1);
		Iterator<Evaluacion> it = a.iterator();
		while(it.hasNext()){
			System.out.println(it.next().toString());
		}*/
		
		/*ptDao.addEvaluacion("Examen subir nota de Álgebra para Libia Barrientos Escobar", 9, 1,31833384);
		
		Set<Evaluacion> a = ptDao.getEvaluaciones(1,31833384);
		Iterator<Evaluacion> it = a.iterator();
		while(it.hasNext()){
			System.out.println(it.next().toString());
		}*/
		
		/*Set<Unidad> a = ptDao.getUnidades(1);
		Iterator<Unidad> it = a.iterator();
		while(it.hasNext()){
			System.out.println(it.next().toString());
		}*/
		
		/*Profesor p = null;
		try {
			p = ptDao.getProfesorByDni(57283343);
		} catch (UserNotFoundException e) {
			System.out.println("Adios!");
		}
		ptDao.addAsignatura(new Asignatura(6, 6, "Gestión del Conocimiento", 6, p));
		*/
		
		/*Set<Asignatura> a = ptDao.getAsignaturas();
		Iterator<Asignatura> it = a.iterator();
		while(it.hasNext()){
			System.out.println(it.next().toString());
		}*/
		
		//System.out.println(ptDao.getAlumno(78405443).toString());
		//System.out.println(ptDao.getAsignatura(1).toString());
		
		/*
		
			NO FUNCIONAN DE MOMENTO:::
		
		//ptDao.matricular(1067499, 6);
		
		//ptDao.matricular(1067499, 1);

		//ptDao.desmatricular(1067499, 1);
		
		Set<Alumno> s = ptDao.getAlumnos(1);
		Iterator<Alumno> it = s.iterator();
		System.out.println("A punto de bluclear");
		while(it.hasNext()){
			System.out.println(it.next().toString());
		}
		*/
		
		
		
		
		/*Set<Asignatura> s = ptDao.getAsignaturasProfesor(80409525);
		Iterator<Asignatura> it = s.iterator();
		System.out.println("A punto de bluclear");
		while(it.hasNext()){
			System.out.println(it.next().toString());
		}*/
		
		/*try {
			System.out.println(ptDao.getProfesorByDni(80409525).toString());
		} catch (UserNotFoundException e) {
			System.out.println("Profesor con dni 80409525 no encontrado");
		}*/
		
		
		/*List<Evaluacion> s = ptDao.getEvaluacionesAsignatura(1);
		Iterator<Evaluacion> it = s.iterator();
		System.out.println("A punto de bluclear");
		while(it.hasNext()){
			System.out.println(it.next().toString());
		}*/
		
	}

}
