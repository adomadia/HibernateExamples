package org.javamind.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.javamind.entity.User;
import org.javamind.uitils.HibernateUtil;

public class CreateUsersMain {

	public static void main(String[] args){
		
		User johndow = new User();
		johndow.setName("John Dow");
		johndow.setUsername("john.dow");
		
		User janeDow = new User();
		janeDow.setName("Jane Dow");
		janeDow.setUsername("jane.dow");
		
		User johnSmith = new User();
		johnSmith.setName("John Smith");
		johnSmith.setUsername("john.smith");
		
		User mikeGeorgia = new User();
		mikeGeorgia.setName("Mike Georgia");
		mikeGeorgia.setUsername("mike.georgia");
		
		try{
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			session.getTransaction().begin();
			session.save(johndow);
			session.getTransaction().commit();
			
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			session.save(janeDow);
			session.getTransaction().commit();
			
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			session.save(johnSmith);
			session.getTransaction().commit();
			
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			session.save(mikeGeorgia);
			session.getTransaction().commit();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
}
