package com.charmyin.practice.inheritance;

import org.junit.Test;

import com.charmyin.practice.classObjects.Employee;

/**
 * Test the cosmic super class
 * @author YinCM
 * @date 2013-10-21 22:17:47
 */
public class CosmicSuperClass {
	
	
	@Test
	public void testHashCodeandToString(){
		
		System.out.println("System.out's hashcode is "+System.out.hashCode());
		
		System.out.println(System.out);
		
		Employee emp1 = new Employee("A",123);
		System.out.println(emp1);
		Employee emp2 = new Employee("B",123);
		System.out.println(emp2);
		Employee emp3 = new Employee("C",123);
		System.out.println(emp3);
		Employee emp11 = new Employee("A",123);
		System.out.println(emp11);
		Employee emp22 = new Employee("B",123);
		System.out.println(emp22);
		Employee emp33 = new Employee("C",123);
		System.out.println(emp33);
		
		
		
	}
}
