package com.charmyin.practice.basic.streamFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.StringTokenizer;

import org.junit.Test;

import com.charmyin.practice.classObjects.Employee;
import com.charmyin.practice.classObjects.Manager;

/**
 * Test object Stream
 * @author YinCM
 * @date 2013-10-30 23:14:24
 */
public class ObjectStream {

	@Test
	public void testOutputSteam() throws FileNotFoundException, IOException{
		
		String path = ObjectStream.class.getResource("").getPath();
		File file =  new File(path+"employee.dat");
		System.out.println(file.getAbsolutePath());
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		Employee emp1 = new Employee("charmyin",22);
		Employee emp2 = new Employee("ycm",26);
		oos.writeObject(emp1);
		oos.writeObject(emp2);
		oos.close();
	}
	
	@Test
	public void testInputStream() throws FileNotFoundException, IOException, ClassNotFoundException{
		String path = ObjectStream.class.getResource("").getPath();
		File file =  new File(path+"employee.dat");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		
		Object obj=null;
		//Employee emp1 = (Employee)ois.readObject();
		//Employee emp2 = (Employee)ois.readObject();
		//System.out.println(emp1.getName()+":"+emp1.getAge());
		try{
			do{
				System.out.println(ois.available());
				obj = ois.readObject();
				if(obj!=null){
					Employee emp2 = (Employee)obj;
					System.out.println(emp2.getName()+":"+emp2.getAge());
				}
				
			}while(obj!=null);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testOutputSteamComplex() throws FileNotFoundException, IOException{
		
		String path = ObjectStream.class.getResource("").getPath();
		File file =  new File(path+"employee.dat");
		System.out.println(file.getAbsolutePath());
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		Employee emp1 = new Employee("charmyin",22);
		Employee emp2 = new Employee("ycm",26);
		
		Manager manager = new Manager();
		manager.setPower("Very big");
		manager.setSecretary(emp2);
		
		//oos.writeObject(emp1);
		//oos.writeObject(emp2);
		oos.writeObject(manager);
		oos.close();
	}
	
	@Test
	public void testInputStreamComplex() throws FileNotFoundException, IOException, ClassNotFoundException{
		String path = ObjectStream.class.getResource("").getPath();
		File file =  new File(path+"employee.dat");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		
		Object obj=null;
		//Employee emp1 = (Employee)ois.readObject();
		//Employee emp2 = (Employee)ois.readObject();
		//System.out.println(emp1.getName()+":"+emp1.getAge());
		try{
			do{
				System.out.println(ois.available());
				obj = ois.readObject();
				if(obj!=null){
					Manager emp2 = (Manager)obj;
					System.out.println(emp2.getName()+":"+emp2.getAge());
					Employee emp = emp2.getSecretary();
					System.out.println("secretary:"+emp.getName()+":"+emp.getAge());
				}
				
			}while(obj!=null);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	@Test
	public void testTokenization(){
		String str = "1,2,3;4,ad;23/12,13.";
		StringTokenizer st = new StringTokenizer(str, ",;/");
		
		while(st.hasMoreTokens()){
			String temp = st.nextToken();
			System.out.println(temp);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
