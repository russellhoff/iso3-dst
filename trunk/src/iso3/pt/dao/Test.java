/**
 * 
 */
package iso3.pt.dao;

import java.util.Iterator;
import java.util.Set;

import iso3.pt.model.Alumno;
import iso3.pt.model.Asignatura;
import iso3.pt.model.Evaluacion;

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
		
		PtDAO elDao = PtDAO.getPtDao();
		
		Alumno al = elDao.getAlumno(1067499);
		System.out.println(al.toString());
		
		System.out.println(elDao.getProfesor(1).toString());
		
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
			System.out.println(elDao.getProfesorByDni(80409525).toString());
		} catch (UserNotFoundException e) {
			System.out.println("Profesor no cargado");
		}
		
		
		
		
	}

}
