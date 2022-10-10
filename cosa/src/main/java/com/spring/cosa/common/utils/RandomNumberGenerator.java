package com.spring.cosa.common.utils;

public class RandomNumberGenerator {
	public static String get_5_randomNumber() {
		int number = (int)(Math.random() * (99999 - 10000 + 1)) + 10000;
		return number + "";
	}
}
