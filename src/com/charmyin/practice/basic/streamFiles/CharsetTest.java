package com.charmyin.practice.basic.streamFiles;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Set;

public class CharsetTest {
	
	public static void main(String[] args) throws IOException{
		
		FileReader fr = null;
		BufferedReader in = new BufferedReader(fr = new FileReader("employee.txt"));

		PrintWriter out = new PrintWriter(new FileWriter("employee.txt"), true); 
		out.checkError();
		
		Charset cset = Charset.forName("ISO-8859-1");
		Set<String> aliases = cset.aliases();
		for (String alias : aliases)
		   System.out.println(alias);

	}
	
}
