package com.spring.cosa.common;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Util {
	public static String formatDate() {
		LocalDate now = LocalDate.now();       
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");    
        String formatedNow = now.format(formatter);
        
        return formatedNow;
	}
	
	public static int convertStringToInt(String data) {
		return Integer.parseInt(data);
	}
}
