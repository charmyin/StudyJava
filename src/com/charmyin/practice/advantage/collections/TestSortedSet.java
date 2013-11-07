package com.charmyin.practice.advantage.collections;

import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Test;

public class TestSortedSet {

	@Test
	public void testSortedTest(){
		SortedSet<String> sorter = new TreeSet<String>(); // TreeSet implements SortedSet
		sorter.add("Bob");
		sorter.add("Amy");
		sorter.add("Carl");
		for (String s : sorter)
			System.out.println(s);
	}
	
}
