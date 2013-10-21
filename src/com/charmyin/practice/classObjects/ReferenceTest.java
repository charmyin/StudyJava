package com.charmyin.practice.classObjects;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

import java.awt.Window;

/**
 * Test reference
 * @author YinCM
 * @since 2013-10-21 10:30:50
 */
public class ReferenceTest {
	public static void swap(Employee a, Employee b){
		Employee temp;
		temp = a;
		a = b;
		b = temp;
	}
	
	public static void main(String[] args){
		Employee x = new Employee("charmyin",12);
		Employee y = new Employee("yinchangming", 13);
		
		System.out.println(sqrt(12.4));
		System.out.println(pow(2,4));
		swap(x,y);
		
		Employee temp ;
		temp = x;
		x = y;
		y = temp;
		System.out.println(x.getName());
		System.out.println(y.getName());
	}
}
