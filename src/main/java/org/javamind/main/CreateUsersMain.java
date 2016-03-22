package org.javamind.main;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.javamind.entity.Address;
import org.javamind.entity.User;
import org.javamind.uitils.HibernateUtil;

public class CreateUsersMain {

	public static void main(String[] args){
		
		Address address = new Address("5220 Crazy Blvd.", "Oklahoma City", "Oklahoma", "73134", "USA");

		User johndow = new User();
		johndow.setName("John Dow");
		johndow.setUsername("john.dow");
		johndow.setBillingAddress(address);
		johndow.setShippingAddress(address);
		
		
		User janeDow = new User();
		janeDow.setName("Jane Dow");
		janeDow.setUsername("jane.dow");
		janeDow.setBillingAddress(address);
		janeDow.setShippingAddress(address);
		
		User johnSmith = new User();
		johnSmith.setName("John Smith");
		johnSmith.setUsername("john.smith");
		johnSmith.setBillingAddress(address);
		johnSmith.setShippingAddress(address);
		
		User mikeGeorgia = new User();
		mikeGeorgia.setName("Mike Georgia");
		mikeGeorgia.setUsername("mike.georgia");
		mikeGeorgia.setBillingAddress(address);
		mikeGeorgia.setShippingAddress(address);
		
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
		finally{
			HibernateUtil.tearDown();
		}
		
	}
}
