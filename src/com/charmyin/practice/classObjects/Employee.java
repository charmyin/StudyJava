package com.charmyin.practice.classObjects;

/**
 * Employee
 * @author YinCM
 * @since 2013-10-21 10:30:09
 */
public class Employee {
	
	private String name;
	private int age;
	
	public Employee(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
