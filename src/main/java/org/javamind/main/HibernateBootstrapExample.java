package org.javamind.main;

import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.sql.DataSource;
import javax.transaction.Transaction;
import javax.transaction.UserTransaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.mapping.MetadataSource;
import org.hibernate.service.ServiceRegistry;
import org.javamind.entity.Event;
import org.javamind.uitils.HibernateUtil;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HibernateBootstrapExample {

	private static int CONNECTION_POOL_SIZE = 10;
	private static int CONNECTION_TIMEOUT = 2000;
	private static int CONNECTION_IDLE_TIMEOUT = 30000;
	
	public static void main(String[] args){
		
				
		Event event = new Event();
		event.setName("FirstEvent");
		
		final SessionFactory sessionFactory = getSessionFactory();
		//OPEN NEW SESSION
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(event);
		session.getTransaction().commit();
		//NO NEED TO CLOSE SESSION BECAUSE SESSION GET CLOSED AFTER COMMIT.
		//GET CURRENT SESSION
		session = sessionFactory.openSession();
		session.getTransaction().begin();
		List<Event> events =  session.createCriteria(Event.class).list();
		System.out.println("The size of events is " +  events.size());
		session.getTransaction().commit();
		
	}
	
	public static DataSource getDataSource(){

		Properties dsProperties = new Properties();
		dsProperties.setProperty("url", "jdbc:oracle:thin:@localhost:1521:xe");
		dsProperties.setProperty("user", "hibernateuser");
		dsProperties.setProperty("password", "hibernate");

		
		HikariConfig hikariConfig = new HikariConfig();

		hikariConfig.setDataSourceProperties(dsProperties);
		hikariConfig.setDataSourceClassName("oracle.jdbc.pool.OracleDataSource");
		hikariConfig.setMaximumPoolSize(CONNECTION_POOL_SIZE);
		hikariConfig.setConnectionTimeout(CONNECTION_TIMEOUT);
		hikariConfig.setIdleTimeout(CONNECTION_IDLE_TIMEOUT);
		
		return new HikariDataSource(hikariConfig);
	}
	
	public static SessionFactory getSessionFactory(){

		StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
		
		serviceRegistryBuilder
			.applySetting("hibernate.connection.datasource", getDataSource())
			.applySetting("hibernate.format_sql", "true")
			.applySetting("hibernate.user_sql_comments", "true")
			.applySetting("hibernate.hbm2ddl.auto", "update")
			.applySetting("hibernate.show_sql", "true")
			.applySetting("hibernate.physical_naming_strategy", "org.javamind.entity.shared.CENamingStrategy");
		
		ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
		
		MetadataSources metadataSources = new MetadataSources(serviceRegistry);
		
		metadataSources.addAnnotatedClass(Event.class);
		//TO add the package-info.java files.
		metadataSources.addPackage("org.javamind.entity");
		metadataSources.addPackage("org.javamind.typedef");


		MetadataBuilder metadataBuilder = metadataSources.getMetadataBuilder();
		Metadata metadata = metadataBuilder.build();
		
		return metadata.buildSessionFactory();
	}
}
