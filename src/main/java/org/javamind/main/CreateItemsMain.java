package org.javamind.main;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.javamind.entity.AuctionType;
import org.javamind.entity.Item;
import org.javamind.uitils.DateUtil;
import org.javamind.uitils.HibernateUtil;

public class CreateItemsMain {
	public static void main(String[] args){
		try{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.getTransaction().begin();
			
			Item anApple = new Item();
			Date date = DateUtil.getDateWithDaysAdded(10);
			anApple.setAuctionEnd(date);
			anApple.setBuyNowPrice(new BigDecimal(10.00));
			anApple.setIntialPrice(new BigDecimal(2.51));
			anApple.setMetricWeight(20.8);
			anApple.setName("Crazy Apple");
			anApple.setAuctionType(AuctionType.HIGHEST_BID);
			session.save(anApple);
			
			Item toyCar = new Item();
			toyCar.setAuctionEnd(DateUtil.getDateWithDaysAdded(15));
			toyCar.setBuyNowPrice(new BigDecimal(25.99));
//			toyCar.setIntialPrice(new BigDecimal(2.51));
			toyCar.setMetricWeight(12);
			toyCar.setName("Todler Car");
			toyCar.setAuctionType(AuctionType.HIGHEST_BID);
			session.save(toyCar);
			
			Item shavingCream = new Item();
			shavingCream.setAuctionEnd(DateUtil.getDateWithDaysAdded(15));
			shavingCream.setBuyNowPrice(new BigDecimal(15.99));
			shavingCream.setIntialPrice(new BigDecimal(5.99));
			shavingCream.setMetricWeight(20);
			shavingCream.setName("Yummy Yummy Shaving Cream");
			shavingCream.setAuctionType(AuctionType.HIGHEST_BID);
			session.save(shavingCream);
			
			Item javaForDummy = new Item();
			javaForDummy.setAuctionEnd(DateUtil.getDateWithDaysAdded(15));
			javaForDummy.setBuyNowPrice(new BigDecimal(15.99));
			//javaForDummy.setIntialPrice(new BigDecimal(5.99));
			javaForDummy.setMetricWeight(10);
			javaForDummy.setName("Java Book For Dummy");
			//javaForDummy.setAuctionType(AuctionType.HIGHEST_BID);
			session.save(javaForDummy);
			session.getTransaction().commit();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
