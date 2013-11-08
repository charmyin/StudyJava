package com.charmyin.practice.advantage.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.charmyin.practice.classObjects.Employee;
import com.charmyin.practice.classObjects.Manager;

/**
 * Test map
 * @author YinCM
 * @since
 */
public class TestMap {
	
	
	
	@Test
	public void testMap(){
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("1", "a");
		hashMap.put("2", "b");
		hashMap.put("3", "c");
		hashMap.put("3", "cd");
		
		
		Set<Map.Entry<String, String>> mapEntry = hashMap.entrySet();
		for(Map.Entry<String, String> mapTemp : mapEntry){
			String temp = "key="+mapTemp.getKey()+"--value="+mapTemp.getValue();
			System.out.println(temp);
		}
		
	}
	
	@Test
	public void testLinkedMap(){
		Map<String, Employee> staff = new LinkedHashMap<String, Employee>(10,0.8f)
		{
			private static final long serialVersionUID = 1L;

			protected boolean removeEldestEntry(Map.Entry<String, Employee> eldest)
		      {
		         return size() > 20;
		      }
		};
		
		Employee employee = new Employee("1",12);
		Manager man = (Manager)employee;
		Employee emm = (Employee)man;
		
		staff.put("567-24-2546", new Employee("1",12));
		staff.put("144-25-5464", new Employee("2",12));
		
		staff.put("157-62-7935", new Employee("3",12));
		staff.put("1456-62-5527", new Employee("4",12));
		staff.put("2456-62-5527", new Employee("5",12));
		staff.put("3567-24-2546", new Employee("6",12));
		staff.put("4567-24-2546", new Employee("1",12));
		staff.put("5144-25-5464", new Employee("2",12));
		
		staff.put("6157-62-7935", new Employee("3",12));
		staff.put("7456-62-5527", new Employee("4",12));
		staff.put("8456-62-5527", new Employee("5",12));
		staff.put("9567-24-2546", new Employee("6",12));
		staff.put("10567-24-2546", new Employee("1",12));
		staff.put("11144-25-5464", new Employee("2",12));
		
		staff.put("12157-62-7935", new Employee("3",12));
		staff.put("13456-62-5527", new Employee("4",12));
		staff.put("14456-62-5527", new Employee("5",12));
		staff.put("15567-24-2546", new Employee("6",12));
		staff.put("16567-24-2546", new Employee("1",12));
		staff.put("17144-25-5464", new Employee("2",12));
		
		staff.put("18157-62-7935", new Employee("3",12));
		staff.put("19456-62-5527", new Employee("4",12));
		staff.put("20456-62-5527", new Employee("5",12));
		staff.put("567-24-2546", new Employee("6",12));
		
		System.out.println("--------------华丽丽的分割线--------------------");
		int i=0;
		Set<Map.Entry<String, Employee>> mapEntry = staff.entrySet();
		for(Map.Entry<String, Employee> mapTemp : mapEntry){
			i++;
			Employee emp = (Employee)mapTemp.getValue();
			String temp = i+"--key="+mapTemp.getKey()+"--value="+emp.getName();
			System.out.println(temp);
		}
		
	}
	
}
