package com.charmyin.practice.advantage.collections;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.junit.Test;

/**
 * Test read write propertis
 * @author YinCM
 * @since
 */
public class PropertiesTest {
	
	@Test
	public void testProperties() throws IOException{
		
		String path = PropertiesTest.class.getResource("").getPath()+"properties.property";
		File file = new File(path);
		System.out.println(path);
		InputStream fis = new FileInputStream(file);
		
		Properties prot = new Properties();
		prot.load(fis);
		
	 
		Iterator<Map.Entry<Object, Object>> it = prot.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<Object, Object> entry = it.next();
			System.out.println(entry.getKey().toString()+"--"+entry.getValue().toString());
			
		}
		
		fis.close();
		
		String path2 = PropertiesTest.class.getResource("").getPath()+"properties.property";
		
		prot.put("weight1", "63kg");
		
		OutputStream fos = new FileOutputStream(file);
		
		prot.store(fos, "It is so cool~");
		
		
		
		fos.close();
		
	}
}
