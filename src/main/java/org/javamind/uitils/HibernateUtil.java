package org.javamind.uitils;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public final class HibernateUtil {

	private static SessionFactory sessionFactory;
	
	protected static void setUp(){
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
					.configure()
					.build();
		try{
			sessionFactory = new MetadataSources(registry).
					buildMetadata().buildSessionFactory();
		}
		catch(Exception e){
			StandardServiceRegistryBuilder.destroy(registry);
		}
		
	}
	
	protected void tearDown(){
		if(sessionFactory != null){
			sessionFactory.close();
		}
	}
	
	public static SessionFactory getSessionFactory(){
		if(sessionFactory == null){
			setUp();
		}
		return sessionFactory;
	}
}
