package com.charmyin.practice.interfacetest;

import com.charmyin.practice.classObjects.Employee;

/**
 * Test interface
 * @author YinCM
 * @since
 */
public interface USB {
	static final String version = "2.0";
	public void readData();
	public void readEmployee(Employee employee);
}
