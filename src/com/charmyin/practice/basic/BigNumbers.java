package com.charmyin.practice.basic;

import java.math.BigInteger;

import org.junit.Test;

/**
 * Big Numbers
 * @author YinCM
 * @since 2013-10-19 22:09:38
 */
public class BigNumbers {
	
	
	@Test
	public void testBigInteger(){
		BigInteger a = BigInteger.valueOf(100);
		BigInteger b = BigInteger.valueOf(10000);
		BigInteger e = a.add(b);
		BigInteger c = BigInteger.valueOf(10);
		BigInteger d = c.multiply(e);
		System.out.println(d);
	}
}
