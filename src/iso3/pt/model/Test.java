/**
 * 
 */
package iso3.pt.model;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

/**
 * @author Jon_Inazio
 * @author Lucia
 * @author Eztizen
 */
public class Test {

	private SessionFactory sessionFactory;
	
	public Test() throws Exception{
		
		sessionFactory = new Configuration().configure().buildSessionFactory();
		
		if( sessionFactory.equals(null) ){
			throw new Exception("Session factory is null");
		}
		
	}
	
	
	public void prueba(){
		
		Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
		
		/*
		 * PRUEBA DE PROFESOR
		Profesor unProfe = new Profesor();
		unProfe.setDni(78936044);
		//unProfe.setId(1);
		unProfe.setPassword("1234");
		unProfe.setNombre("Pedro Zier");
		unProfe.setTelefono("777886543");
		unProfe.setEmail("pz23@juer.com");
		unProfe.setDespacho("12AZ");
		
		session.save(unProfe);
		System.out.println("Añadido profesor!");
		
		Unidad unaUnidad = new Unidad();
		unaUnidad.setAcronimo("ALG");
		unaUnidad.setContenido("Para aprender algoritmia.");
		unaUnidad.setTitulo("Algoritmia");
		
		session.save(unaUnidad);
		System.out.println("Añadida unidad!");
		
		Unidad unaUnidad1 = new Unidad();
		unaUnidad1.setAcronimo("F1V");
		unaUnidad1.setContenido("Análisis matemático de funciones de 1 variable.");
		unaUnidad1.setTitulo("Funciones de 1 variable");
		
		session.save(unaUnidad1);
		System.out.println("Añadida unidad!");
		*/
		
		/*
		 *  PRUEBA GENERAL
		 */
		Profesor p1 = new Profesor(65435677, "1234", "Perico Delgado", "654784356", "a@a.com", "DepartamentoZ");
		Profesor p2 = new Profesor(90654327, "1234", "Patxi Zubilaga", "678901234", "b@b.com", "DepartamentoZX");
		
		Alumno a1 = new Alumno(76548732, "1234", "Iñaki Jundiz", "678543267");
		Alumno a2 = new Alumno(98765432, "1234", "Alfonso Manero", "657895857");
		
		Asignatura as1 = new Asignatura(8796, "Ingeniería del Software", 12.0f);
		Asignatura as2 = new Asignatura(1652, "Metodología de la Programación", 6.0f);
		
		Unidad u1 = new Unidad("Intr.ISO", "Introducción ISO", "Muchas cosas");
		Unidad u2 = new Unidad("Intr.MP", "Introducción MP", "Muchisimas cosas");
		
		Evaluacion e1 = new Evaluacion("Concepto 1", 9.5f);
		Evaluacion e2 = new Evaluacion("Concepto 2", 6.6f);

		as1.addProfesor(p1);
		as2.addProfesor(p2);
		as1.getAlumnos().add(a1);
		as2.getAlumnos().add(a2);
		as1.getUnidades().add(u1);
		as2.getUnidades().add(u2);
		
		e1.setAlumno(a1);
		e1.setAsignatura(as1);
		e2.setAlumno(a2);
		e2.setAsignatura(as2);
		
		a1.getEvaluaciones().add(e1);
		a2.getEvaluaciones().add(e2);
		
		session.save(p1);
		session.save(p2);
		session.save(as1);
		session.save(as2);
		session.save(u1);
		session.save(u2);
		session.save(a1);
		session.save(a2);
		session.save(e1);
		session.save(e2); 
		 
		tx.commit();
		
		if( session != null ){
			session.flush();
			session.close();
		}
		
       
		
	}
	
	public void close(){
        sessionFactory.close();
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try{
			Test t1 = new Test();
			t1.prueba();
			t1.close();
		}catch(Exception e){
			System.out.println("****Error: " + e.getMessage() + "\nMore info: ");
			e.printStackTrace();
		}
		
		
		
	}

}
