package com.charmyin.practice.classObjects;

import java.util.Date;

/**
 * Employee
 * @author YinCM
 * @since 2013-10-21 10:30:09
 */
public class Employee implements Cloneable {
	
	private String name;
	private int age;
	private Date hireDay;
	
	public Date getHireDay() {
		return hireDay;
	}

	public void setHireDay(Date hireDay) {
		this.hireDay = hireDay;
	}

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
	
	// raise visibility level to public, change return type
   public Employee clone() throws CloneNotSupportedException
   {
	  
      return (Employee) super.clone();
   }
	
}
