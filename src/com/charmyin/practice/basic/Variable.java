package com.charmyin.practice.basic;

import org.junit.Test;

/**
 * 用于练习变量
 * @author YinCM
 * @since 2013-10-17 23:01:02
 */
public class Variable {
	
	private final String name="q3";
	
 
	/**
	 * Test whether a final variable can be assign a value in a new line~
	 */
	@Test
	public void testContstAssignment(){
		final String paper = null;
		//paper = "12"; //not work
	}
	
	/**
	 * 
	 */
	@Test
	public void testCharBit(){
		 char simple = 'a';
		 String simpleBit = Integer.toBinaryString((int)'a');
		 char complex = '一';
		 String complexBit = Integer.toBinaryString((int)complex);
		 System.out.println(simple+"："+simpleBit+"----"+complex+"："+complexBit);
	}
}