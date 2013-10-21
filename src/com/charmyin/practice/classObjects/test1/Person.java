package com.charmyin.practice.classObjects.test1;

/**
 * Test abstract class
 * @author YinCM
 * @date 2013-10-21 20:35:48
 */
public abstract class Person {
	private String name;
	private String age;
	
	public abstract String getDescription();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	 
}
