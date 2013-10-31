package com.charmyin.practice.classObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * Employee
 * @author YinCM
 * @since 2013-10-21 10:30:09
 */
public class Employee implements Cloneable, Serializable  {
	
	private static final long serialVersionUID = -6579358768304389035L;
//  private static final long serialVersionUID = 1L;
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
	
	public void readText() throws IOException{
		String userDir = Employee.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		File file  = new File("test.txt");
		
		InputStream is = Employee.class.getResourceAsStream("test.txt");
		 
		//System.out.println();
		System.out.println(userDir);
		FileInputStream fis = new FileInputStream(file);
		byte firstByte = (byte)is.read();
		System.out.println(firstByte);
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
