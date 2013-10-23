package com.charmyin.practice.clone;

import java.util.Date;

import org.junit.Test;

import com.charmyin.practice.classObjects.Employee;
import com.charmyin.practice.interfacetest.Mp3Player;

/**
 * Test clone
 * @author YinCM
 * @since
 */
public class Clone {
	
	@Test
	public void testClone() throws CloneNotSupportedException{
		Mp3Player mp = new Mp3Player();
		
		
		Employee orgEmp = new Employee("charmyin",12);
		orgEmp.setHireDay(new Date());
		
		Employee cpyEmp = orgEmp.clone();
		
		cpyEmp.setAge(22);
		cpyEmp.setName("yinchangming");
		
		
		
		System.out.println("org:name-age-hireday--"+orgEmp.getName()+"-"+orgEmp.getAge()+"-"+orgEmp.getHireDay());
		System.out.println("cpy:name-age-hireday--"+cpyEmp.getName()+"-"+cpyEmp.getAge()+"-"+cpyEmp.getHireDay());
		
		//我只是小小的改变了一下
		orgEmp.getHireDay().setDate(12);
		System.out.println("org:name-age-hireday--"+orgEmp.getName()+"-"+orgEmp.getAge()+"-"+orgEmp.getHireDay());
		System.out.println("cpy:name-age-hireday--"+cpyEmp.getName()+"-"+cpyEmp.getAge()+"-"+cpyEmp.getHireDay());
	}
}
