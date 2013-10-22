package com.charmyin.practice.classObjects;

/**
 * 
 * @author YinCM
 * @since
 */
public class Manager extends Employee{
	private String power;
	
	public Manager(){
		super("",-1);
	}
	
	public Manager(String name, int age){
		super(name, age);
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	
}
