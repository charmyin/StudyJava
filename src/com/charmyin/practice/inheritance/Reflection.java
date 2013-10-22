package com.charmyin.practice.inheritance;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

import com.charmyin.practice.classObjects.Employee;
import com.charmyin.practice.classObjects.Manager;

/**
 * Test Reflection
 * @author YinCM
 * @since 2013-10-22 21:36:53
 */
public class Reflection {
	
	//Employee emp = new Employee();
	
	@Test
	public void testGetReflection() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		Class cls =Class.forName("com.charmyin.practice.classObjects.Manager");
		//Employee emp = new Manager("charmyin", 12);
		Employee emp = (Manager)cls.newInstance();
		emp.setAge(1);
		emp.setName("charmyin");
		System.out.println(emp.getAge());
		System.out.println(emp.getName());
		System.out.println("getName()="+emp.getClass().getName());
		for(Method me : emp.getClass().getMethods()){
			System.out.println("getMethod()="+me.getName());
		}
		for(Constructor con : emp.getClass().getConstructors()){
			System.out.println("getConstructor()="+con.getName());
		}
		for(Field fi : emp.getClass().getFields()){
			System.out.println("getFields()="+fi.getName());
		}
	}
	
}
