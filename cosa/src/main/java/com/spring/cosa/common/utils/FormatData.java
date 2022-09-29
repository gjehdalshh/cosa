package com.spring.cosa.common.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormatData {
	public static String formatDate() {
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String formatedNow = now.format(formatter);

		return formatedNow;
	}
}