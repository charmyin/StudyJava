package com.charmyin.practice.basic.exception;


/**
 * Test exception finally
 * @author YinCM
 * @since
 */
public class Finally {
	
	public static void main(String[] args) throws Exception{
		try{
			System.out.println("In try");
			throw new Exception();
		}catch(Exception e){
			System.out.println("In catch first!");
			throw new Exception();
			//System.out.println("In catch after throw another exception");
		}finally{
			System.out.println("In finally");
			//throw new Exception();
		}
		
		//System.out.println("after an exception!");
		
	}
	
	
}
