/**
 * 
 */
package iso3.pt.dao;

import iso3.pt.model.Alumno;
import iso3.pt.model.Asignatura;

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
		
		Alumno al = elDao.getAlumno(76548732);
		System.out.println(al.toString());

		Alumno al2 = new Alumno(78936045, "1234", "Mario Escondrillas", "944986754");
		Asignatura as = new Asignatura(43235, "Fundamentos de Bases de Datos", 6);
		as.addAlumnos(al2);
		elDao.addAsignatura(as);
		
	}

}
