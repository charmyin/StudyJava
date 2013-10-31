package com.charmyin.practice.basic.streamFiles;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

import com.charmyin.practice.classObjects.Employee;
import com.charmyin.practice.classObjects.Manager;

/**
 * Deep clone an instance by serialize
 * @author YinCM
 * @since
 */
public class SerialDeepClone {

	@Test
	public void testDeepClone() throws FileNotFoundException, IOException, CloneNotSupportedException, ClassNotFoundException{
		
		String path = ObjectStream.class.getResource("").getPath();
	//	File file =  new File(path+"employee.dat");
		//System.out.println(file.getAbsolutePath());
		//ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		Employee emp1 = new Employee("charmyin",22);
		Employee emp2 = new Employee("ycm",26);
		
		Manager manager = new Manager();
		manager.setName("manager");
		manager.setPower("Very big");
		manager.setSecretary(emp2);
		
		//Deep clone
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(manager);
		oos.close();
		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bais);
		Manager managerSerial = (Manager)ois.readObject();
		
		//Shellow clone
		Manager newManager = (Manager) manager.clone();
		manager.getSecretary().setName("on no");
		
		
		
		System.out.println(newManager.getSecretary().getName());
		
		System.out.println(managerSerial.getSecretary().getName());
		
		System.out.println(File.separator);
		
		
		//oos.writeObject(emp1);
		//oos.writeObject(emp2);
		//oos.writeObject(manager);
		//oos.close();
		 
	}
}
