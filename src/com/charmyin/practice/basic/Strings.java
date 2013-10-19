package com.charmyin.practice.basic;

import org.junit.Test;

/**
 * Test Strings
 * @author YinCM
 * @since 2013-10-19 20:56:08
 */
public class Strings {
	
	
	//@Test
	public void testSimpleUnicode(){ 
		System.out.println("Java\u01222122");
		System.out.println("\u0061");
	}
	
	/**
	 * Get code points length of a string
	 */
	//@Test
	public void testGetTrueLength(){
		String greeting = "aHello";
		int n = greeting.length();
		
		int cpCount = greeting.codePointCount(0, greeting.length());
		
		System.out.println("Cahr count="+n+"; Code point count = "+cpCount);
	}
	
	/**
	 * Get code points length of a string
	 */
	@Test
	public void testGetCodepoint(){
		String greeting = "aHello";
	 
		
		int index = greeting.offsetByCodePoints(0, 0);
		int cp = greeting.codePointAt(2);


		System.out.println("Codepoint of index "+index+" = "+cp);
		System.out.println("\u0061");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
