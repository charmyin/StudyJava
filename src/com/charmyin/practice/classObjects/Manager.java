package com.charmyin.practice.classObjects;

/**
 * 
 * @author YinCM
 * @since
 */
public class Manager extends Employee{
	private static final long serialVersionUID = 7440411297511886604L;
	private String power;
	private Employee secretary;
	
	public Manager(){
		super("",-1);
	}
	
	public Employee getSecretary() {
		return secretary;
	}

	public void setSecretary(Employee secretary) {
		this.secretary = secretary;
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
