package org.javamind.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.javamind.entity.Event;
import org.javamind.uitils.HibernateUtil;

public class InitialTestMain {
	public static void main(String[] args){
		
		Event event = new Event();
		event.setName("FirstEvent");
		
		final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(event);
		session.getTransaction().commit();
		session.close();
	}

}
