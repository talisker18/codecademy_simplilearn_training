package AAI_data_and_database.database.hibernate_jdbc.hibernate.hibernate_queries;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import AAI_data_and_database.database.hibernate_jdbc.hibernate.Player;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create config object
		StandardServiceRegistry s = new StandardServiceRegistryBuilder().configure("path_to_hibernate.cfg.xml").build();
		
		//create session factory object
		Metadata m = new MetadataSources(s).getMetadataBuilder().build();
		SessionFactory sf  = m.getSessionFactoryBuilder().build();
		
		//open session
		Session sn = sf.openSession();
		
		//HQL queries
		
		//query FROM
		String hql = "FROM Player where playerName=:name";
		Query q1 = sn.createQuery(hql);
		//set param
		q1.setString("name", "Joel");
		List results = q1.list(); //the List will contain Player objects
		
		//or
		hql = "FROM Player where age between :age1 AND :age2";
		q1.setInteger("age1", 10);
		q1.setInteger("age2", 20);
		
		//native SQL queries
		SQLQuery q2 = sn.createSQLQuery("SELECT * FROM Player");
		
		//there are also Criteria queries
		Criteria c = sn.createCriteria(Player.class);
		c.add(Restrictions.gt("age", 23)); //gt = greater than, in this case gt than 23
		List<Player> list = c.list();
	}

}
