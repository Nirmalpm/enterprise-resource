package com.enterprise.resource.utils;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class CalendarUtil {
	public static String getDateString(String formatString, Date date) {
		/*Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		SimpleDateFormat format = new SimpleDateFormat(formatString);
		String stringDate = null;
		stringDate = format.format(date);
		return stringDate;*/
		Instant inst = Instant.ofEpochMilli(date.getTime());
		ZoneId zone = ZoneId.of("Asia/Kolkata");
		ZonedDateTime dateTime = ZonedDateTime.ofInstant(inst, zone); 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd-HH:mm:ssa");
		String formattedString = dateTime.format(formatter);		
		return formattedString;
	}
}
