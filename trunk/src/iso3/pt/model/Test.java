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
		System.out.println("A�adido profesor!");
		
		Unidad unaUnidad = new Unidad();
		unaUnidad.setAcronimo("ALG");
		unaUnidad.setContenido("Para aprender algoritmia.");
		unaUnidad.setTitulo("Algoritmia");
		
		session.save(unaUnidad);
		System.out.println("A�adida unidad!");
		
		Unidad unaUnidad1 = new Unidad();
		unaUnidad1.setAcronimo("F1V");
		unaUnidad1.setContenido("An�lisis matem�tico de funciones de 1 variable.");
		unaUnidad1.setTitulo("Funciones de 1 variable");
		
		session.save(unaUnidad1);
		System.out.println("A�adida unidad!");
		*/
		
		/*
		 *  PRUEBA GENERAL : backup
		 */
		/*Profesor p1 = new Profesor(65435677, "1234", "Perico Delgado", "654784356", "a@a.com", "DepartamentoZ");
		Profesor p2 = new Profesor(90654327, "1234", "Patxi Zubilaga", "678901234", "b@b.com", "DepartamentoZX");
		
		Alumno a1 = new Alumno(76548732, "1234", "I�aki Jundiz", "678543267");
		Alumno a2 = new Alumno(98765432, "1234", "Alfonso Manero", "657895857");
		
		Asignatura as1 = new Asignatura(8796, "Ingenier�a del Software", (float) 12.0);
		Asignatura as2 = new Asignatura(1652, "Metodolog�a de la Programaci�n", (float) 6.0);
		
		as1.addAlumnos(a1);
		as2.addAlumnos(a2);
		
		a1.addAsignatura(as1);
		a2.addAsignatura(as2);
		
		Unidad u1 = new Unidad("Intr.ISO", "Introducci�n ISO", "Muchas cosas");
		Unidad u2 = new Unidad("Intr.MP", "Introducci�n MP", "Muchisimas cosas");
		
		Evaluacion e1 = new Evaluacion("Concepto 1", 9.5f);
		Evaluacion e2 = new Evaluacion("Concepto 2", 6.6f);

		as1.setProfesor(p1);
		as2.setProfesor(p2);
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
		session.save(e2); */
        
        //Crear alumnos
  		Alumno al1 = new Alumno(78405443, "1234", "Pavel Benavidez Moreno", "945039476");
  		Alumno al2 = new Alumno(60522675, "1234", "Akemi Briones Parra", "934957355");
  		Alumno al3 = new Alumno(31833384, "1234", "Libia Barrientos Escobar", "961529453");
  		Alumno al4 = new Alumno(40097371, "1234", "Andr� Baca Rael", "946552957");
  		Alumno al5 = new Alumno(04044753, "1234", "Leslie Jurado Naranjo", "945295836");
  		Alumno al6 = new Alumno(23361291, "1234", "Ara T�rrez Oquendo", "945295768");
  		Alumno al7 = new Alumno(20686524, "1234", "Joscio Arg�ello Nevarez", "987654687");
  		Alumno al8 = new Alumno(13940688, "1234", "Pac�fico S�nchez Escobedo", "987098543");
  		Alumno al9 = new Alumno(92878586, "1234", "Esa� Regalado Caraballo", "910543276");
  		Alumno al10 = new Alumno(96059787, "1234", "Rina Valladares Dom�nquez", "943215432");
  		Alumno al11 = new Alumno(93925891, "1234", "Maclovio Salcedo Enr�quez", "987604326");
  		Alumno al12 = new Alumno(32342151, "1234", "Amilcar Madrigal Menchaca", "987540914");
  		Alumno al13 = new Alumno(95815409, "1234", "Elsira Puga Gallardo", "944067452");
  		Alumno al14 = new Alumno(66881939, "1234", "Fedor Cadena Serrato", "965295463");
  		Alumno al15 = new Alumno(96756330, "1234", "Celinda Caldera Cedillo", "945392046");
  		
  		//Crear asignaturas
  		Asignatura as1 = new Asignatura(1, "�lgebra", 6);
  		Asignatura as2 = new Asignatura(2, "C�lculo", 9);
  		Asignatura as3 = new Asignatura(3, "Programaci�n", 12);
  		Asignatura as4 = new Asignatura(4, "Metodolog�a de la programaci�n", 6);
  		Asignatura as5 = new Asignatura(5, "Sistemas operativos", 9);
  		
  		//A�adir unidades a asignaturas
  		Unidad ud1 = new Unidad("ALG-UD1", "Estructuras algebraicas", "Desde los conceptos de conjunto y relaci�n se define una estructura algebraica. Su clasificaci�n se hace en funci�n de las diferentes propiedades que puedan satisfacer las leyes de composici�n implicadas, haciendo relaci�n a las diversas aplicaciones en el campo de la ingenier�a.");
  		as1.addUnidades(ud1);
  		Unidad ud2 = new Unidad("ALG-UD2", "Espacios vectoriales euclideos", "Conocer y comprender los conceptos b�sicos de la teor�a de espacios vectoriales de dimensi�n finita. Describir los espacios vectoriales: 'conjunto de las matrices rectangulares de m filas y n columnas', 'conjunto de los polinomios de grado menor � igual que n', 'conjunto de las funciones reales de variable real continuas en un dominio real'. ");
  		as1.addUnidades(ud2);
  		
  		Unidad ud3 = new Unidad("CALC-UD1", "Ecuaciones diferenciales de primer orden", "Se caracteriza la ecuaci�n diferencial ordinaria de primer orden. A continuaci�n se estudia la estructura del espacio de soluciones, considerando la correspondiente casu�stica, que interviene en su resoluci�n. Finalmente, se realiza la aplicaci�n a problemas de valor inicial en situaciones pr�cticas concretas.");
  		as2.addUnidades(ud3);
  		Unidad ud4 = new Unidad("CALC-UD2", "Ecuaciones diferenciales de orden superior", "Se generaliza el concepto de ecuaci�n diferencial ordinaria a un orden distinto de la unidad, caracterizando, en particular, las lineales (por las aplicaciones pr�cticas que encuentran). Se estudia el espacio de soluciones: resolviendo la ecuaci�n homog�nea y buscando una soluci�n particular (bien por el m�todo de variaci�n de par�metros bien con el m�todo de los coeficientes indeterminados).");
  		as2.addUnidades(ud4);
  		
  		Unidad ud5 = new Unidad("PRO-UD1", "Introducci�n", "Este tema es b�sicamente introductorio y se centra en explicar qu� es la programaci�n, cu�les son los objetivos de la programaci�n, la importancia del algoritmo, cu�les son las fases de la programaci�n (especificaci�n, dise�o del algoritmo, escritura del programa y prueba). Se introducen tambi�n distintos lenguajes de programaci�n y sus caracter�sticas");
  		as3.addUnidades(ud5);
  		Unidad ud6 = new Unidad("PRO-UD2", "Conceptos b�sicos de programaci�n", "A lo largo de este tema se explora la escritura de algoritmos utilizando pseudoc�digo. As� pues se ven expresiones, instrucciones b�sicas, estructuras de control, utilizaci�n de subprogramas, y por �ltimo algoritmos b�sicos de tratamiento de secuencias.");
  		as3.addUnidades(ud6);
  		
  		Unidad ud7 = new Unidad("MP-UD1", "Especificaci�n y documentaci�n de programas", "Especificaci�n formal pre-post.");
  		as4.addUnidades(ud7);
  		Unidad ud8 = new Unidad("MP-UD2", "Variaci�n de programas", "El sistema formal de Hoare.");
  		as4.addUnidades(ud8);
  		
  		Unidad ud9 = new Unidad("SO-UD1", "Gesti�n Sistema de Ficheros e Interprete Comandos", "Concepto de sistema de ficheros y sus mecanismos de representaci�n.Definici�n de sistema multiusuario. Tipos de usuarios, modos de acceso y dominios de protecci�n. Mecanismos b�sicos de gesti�n de la protecci�n de accesos en sistemas centralizados. Llamadas al sistema relacionadas con la protecci�n de accesos y la seguridad. Pr�cticas: uso de redirecciones desde el Shell, programar ejemplos de entrada-salida. Pr�cticas: Manejo del Sistema de Ficheros, manejo del derechos de acceso, redireccionamiento y tuber�as , montaje, programar ... desde el Shell.");
  		as5.addUnidades(ud9);
  		Unidad ud10 = new Unidad("SO-UD2", "Desarrollo y Carga de Programas de C en Memoria: Librer�as est�ticas y din�minas.", "Carga y ubicaci�n de programas en sistemas con uno o varios programas en memoria. Direccionamiento f�sico y virtual. Desarrollo de librer�a est�ticas y din�micas.Librer�as de enlace din�mico. Llamadas al sistema operativo relacionadas con la carga de programas y la gesti�n de la memoria. Pr�cticas: monitorizaci�n de consumo de memoria , manejo del Lenguaje C, uso de funciones de librer�a y ficheros cabecera , Uso de compilador: gcc, crear librer�as din�micas y est�ticas , gestionar los proyectos con make");
  		as5.addUnidades(ud10);

  		//Crear profesores
  		
  		Profesor p1 = new Profesor(80409525, "1234", "Kyle Price", "987647543", "KylePrice@dayrep.com", "1A");
  		Profesor p2 = new Profesor(81880980, "1234", "Jouni Reinikainen", "687609867", "JouniReinikainen@teleworm.us", "1B");
  		Profesor p3 = new Profesor(65299037, "1234", "Abdallah M�rquez Aguayo", "984172645", "AbdallahMrquezAguayo@dayrep.com", "2A");
  		Profesor p4 = new Profesor(57283343, "1234", "Frederic Godoy Comejo", "658493612", "FredericGodoyComejo@teleworm.us", "2B");
  		Profesor p5 = new Profesor(31695763, "1234", "Charline Dastous", "651428503", "CharlineDastous@dayrep.com", "3Z");
  		
  		//A�adir profesores a asignaturas
  		as1.setProfesor(p3);
  		as2.setProfesor(p2);
  		as3.setProfesor(p1);
  		as4.setProfesor(p4);
  		as5.setProfesor(p5);
  		
  		//A�adir alumnos a asignaturas
  		as1.addAlumnos(al1);
  		as1.addAlumnos(al2);
  		as1.addAlumnos(al3);
  		as1.addAlumnos(al15);
  		
  		as2.addAlumnos(al4);
  		as2.addAlumnos(al5);
  		as2.addAlumnos(al6);
  		as2.addAlumnos(al12);

  		as3.addAlumnos(al7);
  		as3.addAlumnos(al8);
  		as3.addAlumnos(al9);
  		as3.addAlumnos(al3);
  		
  		as4.addAlumnos(al10);
  		as4.addAlumnos(al11);
  		as4.addAlumnos(al12);
  		as4.addAlumnos(al6);
  		
  		as5.addAlumnos(al13);
  		as5.addAlumnos(al14);
  		as5.addAlumnos(al15);
  		as5.addAlumnos(al9);
  				
  		//A�adir las asignaturas a sus alumnos
  		al1.addAsignatura(as1);	
  		al2.addAsignatura(as1);
  		al3.addAsignatura(as1);
  		al3.addAsignatura(as3);
  		
  		al4.addAsignatura(as2);
  		al5.addAsignatura(as2);
  		al6.addAsignatura(as2);
  		al6.addAsignatura(as4);
  		
  		al7.addAsignatura(as3);
  		al8.addAsignatura(as3);
  		al9.addAsignatura(as3);
  		al9.addAsignatura(as5);
  		
  		al10.addAsignatura(as4);
  		al11.addAsignatura(as4);
  		al12.addAsignatura(as4);
  		al12.addAsignatura(as2);
  		
  		al13.addAsignatura(as5);
  		al14.addAsignatura(as5);
  		al15.addAsignatura(as5);
  		al15.addAsignatura(as1);
  				
  		//Crear las evaluaciones
  		
  		/*
  		 * as1
  		 */
  		Evaluacion ev1 = new Evaluacion("Evaluaci�n de " + as1.getNombre() + " para " + al1.getNombre(), 7.8f, as1, al1);
  		Evaluacion ev2 = new Evaluacion("Evaluaci�n de " + as1.getNombre() + " para " + al2.getNombre(), 5f, as1, al2);
  		Evaluacion ev3 = new Evaluacion("Evaluaci�n de " + as1.getNombre() + " para " + al3.getNombre(), 6.8f, as1, al3);
  		Evaluacion ev4 = new Evaluacion("Evaluaci�n de " + as1.getNombre() + " para " + al15.getNombre(), 3.1f, as1, al15);

  		/*
  		 * as2
  		 */
  		Evaluacion ev5 = new Evaluacion("Evaluaci�n de " + as2.getNombre() + " para " + al14.getNombre(), 7f, as2, al4);
  		Evaluacion ev6 = new Evaluacion("Evaluaci�n de " + as2.getNombre() + " para " + al5.getNombre(), 1.5f, as2, al5);
  		Evaluacion ev7 = new Evaluacion("Evaluaci�n de " + as2.getNombre() + " para " + al6.getNombre(), 5f, as2, al6);
  		Evaluacion ev8 = new Evaluacion("Evaluaci�n de " + as2.getNombre() + " para " + al12.getNombre(), 6f, as2, al12);
  		
  		/*
  		 * as3
  		 */
  		Evaluacion ev9 = new Evaluacion("Evaluaci�n de " + as3.getNombre() + " para " + al7.getNombre(), 9f, as3, al7);
  		Evaluacion ev10 = new Evaluacion("Evaluaci�n de " + as3.getNombre() + " para " + al8.getNombre(), 8.4f, as3, al8);
  		Evaluacion ev11 = new Evaluacion("Evaluaci�n de " + as3.getNombre() + " para " + al9.getNombre(), 3.6f, as3, al9);
  		Evaluacion ev12 = new Evaluacion("Evaluaci�n de " + as3.getNombre() + " para " + al3.getNombre(), 5f, as3, al3);
  		
  		/*
  		 * as4
  		 */
  		Evaluacion ev13 = new Evaluacion("Evaluaci�n de " + as4.getNombre() + " para " + al10.getNombre(), 3.2f, as4, al10);
  		Evaluacion ev14 = new Evaluacion("Evaluaci�n de " + as4.getNombre() + " para " + al11.getNombre(), 9.5f, as4, al11);
  		Evaluacion ev15 = new Evaluacion("Evaluaci�n de " + as4.getNombre() + " para " + al12.getNombre(), 7f, as4, al12);
  		Evaluacion ev16 = new Evaluacion("Evaluaci�n de " + as4.getNombre() + " para " + al5.getNombre(), 7.9f, as4, al5);
  		
  		/*
  		 * as5
  		 */
  		Evaluacion ev17 = new Evaluacion("Evaluaci�n de " + as5.getNombre() + " para " + al13.getNombre(), 7.5f, as5, al13);
  		Evaluacion ev18 = new Evaluacion("Evaluaci�n de " + as5.getNombre() + " para " + al14.getNombre(), 4f, as5, al14);
  		Evaluacion ev19 = new Evaluacion("Evaluaci�n de " + as5.getNombre() + " para " + al15.getNombre(), 9f, as5, al15);
  		Evaluacion ev20 = new Evaluacion("Evaluaci�n de " + as5.getNombre() + " para " + al9.getNombre(), 7f, as5, al9);
  		
  		//A�adir las evaluaciones a alumnos
  		al1.addEvaluacion(ev1);
  		al2.addEvaluacion(ev2);
  		al3.addEvaluacion(ev3);
  		al3.addEvaluacion(ev12);
  		
  		al4.addEvaluacion(ev5);
  		al5.addEvaluacion(ev6);
  		al6.addEvaluacion(ev7);
  		al6.addEvaluacion(ev16);
  		
  		al7.addEvaluacion(ev9);
  		al8.addEvaluacion(ev10);
  		al9.addEvaluacion(ev11);
  		al9.addEvaluacion(ev20);
  		
  		al10.addEvaluacion(ev13);
  		al11.addEvaluacion(ev14);
  		al12.addEvaluacion(ev15);
  		al12.addEvaluacion(ev8);
  		
  		al13.addEvaluacion(ev17);
  		al14.addEvaluacion(ev18);
  		al15.addEvaluacion(ev19);
  		al15.addEvaluacion(ev4);
  		
  		//Guardar los objetos
		session.save(p1);
		session.save(p2);
		session.save(p3);
		session.save(p4);
		session.save(p5);
		
		//las asignaturas tienen cascada con las unidades
		session.save(as1);
		session.save(as2);
		session.save(as3);
		session.save(as4);
		session.save(as5);
	
		//los alumnos tienen cascada con sus evaluaciones
		session.save(al1);
		session.save(al2);
		session.save(al3);
		session.save(al4);
		session.save(al5);
		session.save(al6);
		session.save(al7);
		session.save(al8);
		session.save(al9);
		session.save(al10);
		session.save(al11);
		session.save(al12);
		session.save(al13);
		session.save(al14);
		session.save(al15);
		
		
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
