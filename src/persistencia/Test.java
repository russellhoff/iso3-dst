/**
 * 
 */
package persistencia;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

/**
 * @author Jon_Inazio
 * @author Lucia
 *
 */
public class Test {

	SessionFactory sessionFactory;
	
	public Test(){
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	
	public void prueba(){
		
		Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
		
		Profesor unProfe = new Profesor(
				78936044,
				"1234",
				"Juanito Panes",
				"666228866",
				"juan@panes.es",
				"11ASK"
				);
		
		session.save(unProfe);
		
		tx.commit();
		session.close();
        System.out.println("Añadido profesor!");
		
	}
	
	public void close(){
        sessionFactory.close();
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		Test t1 = new Test();
		t1.prueba();
		t1.close();
		
		
	}

}
