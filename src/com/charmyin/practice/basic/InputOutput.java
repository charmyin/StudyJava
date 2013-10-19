package com.charmyin.practice.basic;

import java.util.Scanner;

import org.junit.Test;

/**
 * Input and output
 * @author YinCM
 * @since 2013-10-19 21:53:31
 */
public class InputOutput {
	
	
	@Test
	public void testScannerInput(){
		Scanner in = new Scanner(System.in);
		System.out.println("What's your name?");
		String name = in.nextLine();
		
		System.out.println("How old are you?");
		int age = in.nextInt();
		
		System.out.println("Hello, "+name+". Next year, you'll be "+(age+1)+".");
		
	}
	
	
	//@Test
	public void testFormatOutput(){
		double x = 1000000.0 / 3.0;
		System.out.printf("%,8.1f", x);
	}
	
}
