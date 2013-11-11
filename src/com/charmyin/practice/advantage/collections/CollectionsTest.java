package com.charmyin.practice.advantage.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.Vector;

import org.junit.Test;

import com.charmyin.practice.classObjects.Employee;

/**
 * Test collections
 * 
 * @author YinCM
 * @since
 */
public class CollectionsTest {

	@Test
	public void testCollectionsUtils(){
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		
		List<String> listSubed = list.subList(1, 3);
		
		List<List<String>> listTemp = Collections.nCopies(100, listSubed);
		
		List<String> destList = new ArrayList<String>();
		destList.add("");
		destList.add("");
		Collections.copy(destList, listSubed);
		
		for(String a : destList){
			System.out.println(a);
		}
	}
	
	@Test 
	public void testVector(){
		Vector<String> vect = new Vector<String>();
		vect.add("x");
		vect.add("y");
		vect.add("z");
		for(String str : vect){
			System.out.println(str);
		}
	}
	
	@Test
	public void testShuffle(){
		List<String> list = new ArrayList<String>();
		String str = new String("1");
		list.add("2");
		list.add("3");
		list.add(str);
		list.add("4");
		Collections.shuffle(list);
		int i = Collections.binarySearch(list, str); 
		System.out.println(list.get(i));
		System.out.println(i);
		System.out.println(list);
	}
	
	@Test
	public void testSubList() {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		List<String> listSubed = list.subList(1, 3);
		for(String a : listSubed){
			System.out.println(a);
		}
	}

	static class Data {
		String value;

		Data(String value) {
			this.value = value;
		}
		
		public boolean equals(Data data){
			
			if(this==data || this.value.equals(data.value)){
				return true;
			}else{
				return false;
			}
		}
	}
	
	
	@Test
	public void testIterator() {
		int[] ia = { 1, 2, 4, 5, 6 };
		HashMap hashMap = new HashMap<String, String>();
		hashMap.put("1", "a");
		hashMap.put("2", "b");
		hashMap.put("3", "c");
		hashMap.put("3", "cd");

		Set set = hashMap.keySet();

		Iterator it = set.iterator();
		while (it.hasNext()) {
			String str = it.next().toString();
			it.remove();

			System.out.println(str);
			System.out.println("isempty=" + set.isEmpty());
		}
		/*
		 * HashSet hashSet = new HashSet<String>(); hashSet.add("1");
		 * hashSet.add("2"); hashSet.add("3"); hashSet.add("4"); Iterator it=
		 * hashSet.iterator(); while(it.hasNext()){ String str =
		 * it.next().toString(); it.remove(); System.out.println(str);
		 * 
		 * }
		 */
		// Iterator<String> it = new Iterator<String>();
		System.out.println();
	}

	@Test
	public void testListAndSet() {
		List<Employee> list = new ArrayList<Employee>();

		Employee emp = new Employee("ycm", 12);

		list.add(emp);
		list.add(emp);
		list.add(emp);
		System.out.println(list.size());

	}

	@Test
	public void testLinkedList() {
		LinkedList<Employee> list = new LinkedList<Employee>();

		Employee empHead = new Employee("head", 123);

		Employee emp1 = new Employee("emp1", 123);
		Employee emp2 = new Employee("emp2", 23);

		Employee empMiddle = new Employee("middle", 13);

		Employee emp3 = new Employee("emp3", 13);
		Employee emp4 = new Employee("emp4", 13);

		Employee empTail = new Employee("tail", 123);

		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
		list.add(emp4);

		list.addLast(empTail);

		list.addFirst(empHead);

		ListIterator<Employee> listIt = list.listIterator();

		for (int i = 0; i < list.size() / 2; i++) {
			listIt.next();
		}

		listIt.add(empMiddle);

		for (Employee emp : list) {
			System.out.println(emp.getName());
		}

		System.out.println("-----------华丽力的风格先----remove");
		/*
		 * list.remove();
		 * 
		 * Iterator<Employee> it = list.iterator();
		 * 
		 * while (it.hasNext()) { System.out.println(it.next().getName()); }
		 */
		System.out.println("-----------华丽力的风格先----change previous obj");
		ListIterator<Employee> it = list.listIterator();

		Employee emp = it.next();
		Employee e = new Employee("e", 12);
		it.set(e);
		System.out.println(it.next().getName());
		System.out.println("previous is " + it.previous().getName());
		while (it.hasNext()) {
			System.out.println(it.next().getName());
		}
		System.out.println(emp.getName() + emp.getAge());
		System.out.println("---------------------");
		Iterator<Employee> itt = list.iterator();

		while (itt.hasNext()) {
			System.out.println(itt.next().getName());
		}

		System.out.println("-----------华丽力的风格先");

		System.out.println("-----------华丽力的风格先");

		/*
		 * Employee empTemp = it.next();
		 * 
		 * System.out.println(empTemp.getName());
		 * 
		 * Employee empTemp1 = it.next();
		 * 
		 * System.out.println(empTemp1.getName());
		 */

	}

}
