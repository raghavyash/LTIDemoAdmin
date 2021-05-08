package com.lti.am.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
public static String convertDateTimeDateToString(Date date) {
	 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
     String strDate = dateFormat.format(date);  
     System.out.println("Converted String: " + strDate);  
	return strDate;
}
public static Date convertStringToDate(String date) throws ParseException {
	 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
    Date strDate = dateFormat.parse(date);  
    System.out.println("Converted String: " + strDate);  
	return strDate;
}

public static void main(String[] args) {
	Date d= new Date();
	DateUtils.convertDateTimeDateToString(d);
	
}
}
