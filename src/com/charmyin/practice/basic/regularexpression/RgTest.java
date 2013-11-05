package com.charmyin.practice.basic.regularexpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * Test regular expression
 * @author YinCM
 * @since
 */
public class RgTest {
	
	@Test
	public void testRegularExpression(){
		
		
		Pattern pattern = Pattern.compile(".*+o");
		Matcher matcher = pattern.matcher("ahelaloa");
		
		while(matcher.find()){
			System.out.print(matcher.start()+"-");
			System.out.print(matcher.end()+"-");
			System.out.println("yes");
		}
		
	}
	
}
