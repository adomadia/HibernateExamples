package org.javamind.uitils;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	public static final Date getDateWithDaysAdded(int days){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, days);
		return calendar.getTime();
	}

}
