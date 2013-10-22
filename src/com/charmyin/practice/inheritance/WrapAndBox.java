package com.charmyin.practice.inheritance;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.omg.CORBA.IntHolder;

/**
 * 
 * @author YinCM
 * @date 2013-10-22 20:47:02
 */
public class WrapAndBox {
	
	@Test
	public void testUnboxed(){
		
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(1);
		
		//int n = list.get(0);
		int n = list.get(0).intValue();
	}
	
	@Test
	public void testBox(){
		Integer a = 10000;
		Integer b = 10000;
		System.out.println(a.intValue()==b.intValue());
	}
	
	@Test
	public void changeNumericParameters(){
		 int a = 1;
		 IntHolder ih = new IntHolder(2);
		 WrapAndBox.triple(ih);
		 System.out.println(ih.value);
	}
	
	public static void triple(IntHolder x)
	{
	   x.value = 3 * x.value;
	}

	
	
	
}
