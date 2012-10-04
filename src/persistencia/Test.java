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
		
		tx.commit();
		
		if( session != null ){
			session.flush();
			session.close();
		}
		
        System.out.println("Añadido profesor!");
		
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
