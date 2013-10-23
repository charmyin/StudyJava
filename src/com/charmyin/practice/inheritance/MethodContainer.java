package com.charmyin.practice.inheritance;

/**
 * Used for test method invoke in another class
 * 
 * @author YinCM
 * @since
 */
public class MethodContainer {
	public static String doubleString(String name) {
		return name+name;
	}

	public int doubleInt(int number) {
		return number*2;
	}
}
