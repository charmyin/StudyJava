package com.charmyin.practice.advantage.collections;

import java.util.BitSet;

import org.junit.Test;

/**
 * Test bitset
 * @author YinCM
 * @since
 */
public class BitsetTest {

	@Test
	public void testBitSet(){
		BitSet bs = new BitSet(16);
		bs.set(0, false);
		bs.set(1, false);
		bs.set(2, true);
		bs.set(3, true);
		bs.set(4, true);
		bs.set(19);
		
		System.out.println(bs.toString());
	//	bs.set(16);
		for (int i = bs.length()-1; i >= 0; i--) {
			String temp = "0";
			if(bs.get(i)){
				temp = "1";
			}
			System.out.print(temp);
		}
		//System.out.println(bs);
		System.out.println();
		System.out.println("------------");
		byte[] bytes = bs.toByteArray();
		for(byte be : bytes){
			System.out.println(be);
		}
		long[] l = bs.toLongArray();
		for(long ll : l){
			System.out.println(ll);
		}
	}
}
