package com.charmyin.practice.inheritance;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Test array list
 * @author YinCM
 * @date 2013-10-22 19:55:09
 */
public class ArrayListTest {
	
	@Test
	public void testArrayList(){
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("a");
		arrayList.add("b");
		arrayList.add("c");
		System.out.println(arrayList.size());
		//
		arrayList.trimToSize();
		arrayList.add("hello");
		arrayList.add("hello");
		arrayList.add("hello");
		arrayList.add("hello");
		for(String str : arrayList){
			System.out.println(str);
		}
		System.out.println(arrayList.size());
		
	}
	
	
}
