/**
 * 
 */
package persistencia;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

/**
 * @author Jon_Inazio
 * @author Lucia
 *
 */
public class Test {

	SessionFactory sessionFactory;
	
	public Test() throws Exception{
		
		sessionFactory = new Configuration().configure().buildSessionFactory();
		
		if( sessionFactory.equals(null) ){
			throw new Exception("Session factory is null");
		}
		
	}
	
	
	public void prueba(){
		
		Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
		
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
			System.out.println("****Error: " + e.getMessage());
		}
		
		
		
	}

}
