package com.charmyin.practice.basic.streamFiles;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;

import org.junit.Test;

/**
 * Test buffer
 * @author YinCM
 * @since
 */
public class BufferTest {

	@Test
	public void testBuffer() throws FileNotFoundException{
		ByteBuffer buffer ;
		FileInputStream fis = new FileInputStream(new File(""));
		BufferedInputStream bis = new BufferedInputStream(fis);
		
	}
	
}
