package AAI_data_and_database.database.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class RunApp {

	public static void main(String[] args) {
		Configuration config = new Configuration().configure();
		config.addAnnotatedClass(Player.class);
		
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
		
		SessionFactory factory = config.buildSessionFactory(builder.build());
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		//save new object
		Player p1 = new Player(1,"joel");
		session.save(p1);
		transaction.commit();
		session.close();
		
		//get record
		session = factory.openSession();
		transaction = session.beginTransaction();
		
		Player p2 = session.get(Player.class, 1); //get by id
		//update this record
		p2.setPlayerName("joel2");
		//when update, just commit transaction, no need to call save on session object
		transaction.commit();
		
		session.close();
	}

}
