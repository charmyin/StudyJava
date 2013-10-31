package com.charmyin.practice.basic.streamFiles;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/**
 * Manage file
 * @author YinCM
 * @since
 */
public class FileManage {
	
	public static void main(String[] args) throws IOException{
		File tempDir= new File(File.separator+"temp");
		System.out.println(tempDir.getParent());
		
		String str = tempDir.getAbsolutePath();
		String tempStr = tempDir.getCanonicalPath();
		//tempDir.mkdir();
		tempDir.createNewFile();
		System.out.println(tempStr);
		System.out.println(str);
		//tempDir.createNewFile();
	}
	
	
}
