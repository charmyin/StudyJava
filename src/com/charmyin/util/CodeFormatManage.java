package com.charmyin.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * Used to deal with the line number in front of a line~
 * @author YinCM
 * @since
 */
public class CodeFormatManage {
	
	
	public static void main(String[] args) throws IOException{
		
		//Package path
		String packagePath = CodeFormatManage.class.getResource("").getPath();
		
		//Get code.txt file for inputstream
		File file = new File(packagePath+"code.txt");
		//FileInputStream fis = new FileInputStream(file);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String tempStr = "";
		while(tempStr != null){
			String outputStr = tempStr.replaceAll("^\\s*\\d+\\.", "");
			System.out.println(outputStr);
			tempStr = br.readLine();
		}
		
		fr.close();
		br.close();
		/*System.out.println(file.length());
		//Prepare a fileoutputstream
		File outputFile = new File(packagePath+"target.txt");
		FileOutputStream fos = new FileOutputStream(outputFile);*/
		
		
	}
}
