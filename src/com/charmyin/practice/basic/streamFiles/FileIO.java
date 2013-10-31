package com.charmyin.practice.basic.streamFiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class FileIO {
	
	public static void main(String[] args) throws IOException{
//		Employee employee = new Employee("charmyin", 12);
//		employee.readText();
		String userDir = FileIO.class.getResource("").getPath();
		System.out.println(userDir);
		File file  = new File(userDir+"test.txt");
		
		//InputStream is = Employee.class.getResourceAsStream("test.txt");
		
	//	InputStreamReader isr = new InputStreamReader(is);
		
		
		//System.out.println();
		System.out.println(userDir);
		FileInputStream fis = new FileInputStream(file);
		
		InputStreamReader isr = new InputStreamReader(fis);
		
		BufferedReader br = new BufferedReader(isr);
		
		String str = br.readLine();
		
		System.out.println(str);
		byte firstByte = (byte)fis.read();
		System.out.println(firstByte);
		testStringReader();
	}
	
	public static void testStringReader() throws IOException{
		char[] cr = new char[3];
		StringReader sr = new StringReader("woaini ni \n woaini ni");
		int i = sr.read(cr);
		i = sr.read(cr);
		StringBuilder sb = new StringBuilder();
		if(i>0){
			i = sr.read(cr);
			
			sb.append(cr);
		}
		
		System.out.println(sb);
		
		System.out.println("i="+i);
		
		
		for(int j=0; j<3; j++){
			sb.append(cr[j]);
		}
		System.out.println("sr.read(cr)="+sb);
	}
	
}
