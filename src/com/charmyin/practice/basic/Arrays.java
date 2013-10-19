package com.charmyin.practice.basic;

import org.junit.Test;

/**
 * Arrays
 * @author YinCM
 * @since 2013-10-19 22:23:22
 */
public class Arrays {
	
	/**
	 * Initial an array
	 */
	//@Test
	public void testInitArray(){
		
		//Not permitted below
		/*
		int[] smallPrimes = null;
		smallPrimes = {2, 3, 5, 7};
		*/
		//OK
		int[] smallPrimes = {2, 3, 5, 7};
		
		//Equals upside
		int[] anoymous = {2, 3, 5, 7};
		//int[] smallPrimes;
		smallPrimes = anoymous;
	}
	
	
	/**
	 * Test copy array
	 */
	//@Test
	public void copyArray(){
		int[] from = {1,2,3,4};
		int[] to = new int[from.length];
		
		System.arraycopy(from, 0, to, 0, 4);
		
		to[0] = 123;
		
		System.out.println("To");
		for(int i : to){
			System.out.print(i+",");
		}
		System.out.println("");
		System.out.println("From");
		for(int i : from){
			System.out.print(i+",");
		}
	}
	
	
	/**
	 * SortArray
	 */
	@Test
	public void testSortArray(){
		int[] arr = {1,3,12,3,55,23,53};
		for(int i : arr){
			System.out.println(i+",");
		}
		System.out.println("");
		
		java.util.Arrays.sort(arr);
		System.out.println("After sorted");
		for(int i : arr){
			System.out.println(i+",");
		}
		System.out.println("");
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
