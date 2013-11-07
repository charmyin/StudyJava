package com.charmyin.practice.basic;

import org.junit.Test;

/**
 * 用于测试 操作符
 * @author YinCM
 * @since 2013-10-18 22:06:30
 */
public class Operators {
	
	@Test
	public void testxor(){
		int i = 4;
		int j = 6;
		int k = i^j;
		System.out.println(Integer.toBinaryString(i)+"^"+Integer.toBinaryString(j)+"=0"+Integer.toBinaryString(k));
	}
	
	//@Test
	public void testMinus(){
		byte i = 127;
		int j = 12;
		System.out.println(j/i);
	}
	
	//@Test
	public void testMinus0(){
		int i = 1/0;
		System.out.println(i);
	}
	
	/**
	 * 
	 */
	//@Test
	public void testBitwise(){
		
		for(int h=0; h<2 ; h++){
			int i = h ;//-1111110
			int j = -h;
			System.out.println("i="+i+":"+ Integer.toBinaryString(i)+":"+Integer.toBinaryString(i).length());
			System.out.println("j="+j+":"+ Integer.toBinaryString(j)+":"+Integer.toBinaryString(j).length());
//			System.out.println("i="+ Integer.toBinaryString(i)+":"+Integer.toBinaryString(i).length());
//			System.out.println("j="+ Integer.toBinaryString(j)+":"+Integer.toBinaryString(j).length());
			System.out.println("-----------");
		}
		
	}
	
	
	/**
	 * Test operate ">>>" 
	 */
    @Test
	public void testBitwiseTE(){
    	//与>>的区别在于>>>符号位也一起右移，>>保留符号位
    		int j = -1024;
			int i = -1024>>>3 ;//11111110
			System.out.println("old i = "+Integer.toBinaryString(j)+":"+Integer.toBinaryString(j).length());
			System.out.println("i="+i+":"+ Integer.toBinaryString(i)+":"+Integer.toBinaryString(i).length());
//			System.out.println("i="+ Integer.toBinaryString(i)+":"+Integer.toBinaryString(i).length());
//			System.out.println("j="+ Integer.toBinaryString(j)+":"+Integer.toBinaryString(j).length());
			System.out.println("-----------");
		
	}
    
    @Test
    public void getMidOfTwoInt(){
    	int a = 15;
    	int b = 17;
    	int avg = (a+b)>>>1;
    	System.out.println("a="+a+";b="+b+";avg="+avg);
    }
	
	/**
	 * Test math tangant
	 */
	//@Test
	public void testMathTriangle(){
		double trigo = 45.0f;
		double radians = Math.toRadians(trigo);
		System.out.println("radians of "+trigo+" is "+radians);
		
		
		double dd = Math.sin(radians);
		System.out.println("sin"+trigo+"="+dd);
		
		dd = Math.cos(radians);
		System.out.println("cos"+trigo+"="+dd);
		
		double bb = Math.tan(radians);
		System.out.println("tan"+trigo+"="+bb);
		
		dd = Math.atan(radians);
		System.out.println("atan"+trigo+"="+dd);
	}
	
	
	/**
	 * Power Exponential Natural log
	 */
	//@Test
	public void testMatPowerExpLog(){
		
		double dt = 9.0d;
		
		double result;
		
		result = Math.pow(dt,2);
		System.out.println("Power 9 with 2, Math.pow(9,2)= "+result);
		
		//e的指数
		result = Math.exp(dt);
		System.out.println("Exponential dt, Math.exp("+dt+")="+result);
		
		//e的log
		result = Math.log(dt);
		System.out.println("Exponential dt, Math.exp("+dt+")="+result);
	}
	
	/**
	 * Math constant
	 */
	//@Test
	public void testMathConstant(){
		System.out.println("pi p ="+Math.PI);
		System.out.println("E ="+Math.E);
	}
	
	
	@Test
	public void testMathCast(){
		
		double x = 2.7234;
		double i = Math.round(x);
		System.out.println("Math.round(x)="+i);
		
		x = 300.2134;
		short y = (short)x;
		System.out.println(y);
		byte b = (byte)x;
		System.out.println(b);
		
	}
	
	
	
	
}
