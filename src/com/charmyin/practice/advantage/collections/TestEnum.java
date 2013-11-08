package com.charmyin.practice.advantage.collections;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.charmyin.practice.classObjects.Employee;

 enum Weekday { MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY };

 public class TestEnum{
	
	@Test
	public void testEnumSet(){
		EnumSet<Weekday> always = EnumSet.allOf(Weekday.class);
		EnumSet<Weekday> never = EnumSet.noneOf(Weekday.class);
		EnumSet<Weekday> workday = EnumSet.range(Weekday.MONDAY, Weekday.FRIDAY);
		EnumSet<Weekday> mwf = EnumSet.of(Weekday.MONDAY, Weekday.WEDNESDAY, Weekday.FRIDAY); 
		
		Iterator<Weekday> it = never.iterator();
		while(it.hasNext()){
			Weekday wd = (Weekday)it.next();
			System.out.println(wd);
		}
	}
	
	@Test
	public void testEnumMap(){
		EnumMap<Weekday, Employee> personInCharge = new EnumMap<Weekday, Employee>(Weekday.class);
		personInCharge.put(Weekday.MONDAY, new Employee("charmyin",12));
		personInCharge.put(Weekday.TUESDAY, new Employee("ycm",12));
		
		Set<Map.Entry<Weekday, Employee>> set = personInCharge.entrySet();
		for(Map.Entry<Weekday, Employee> entry : set){
			Employee emp = (Employee)entry.getValue();
			System.out.println(entry.getKey()+":"+emp.getName());
		}
	}
	
}