package com.charmyin.practice.advantage.threads;

/**
 * Thread test
 * @author YinCM
 * @since 2013-11-2 22:45:50
 */
public class ThreadTest {
	
	public static void main(String[] args){
		CountFrom1 countA = new CountFrom1("A");
		Thread thread1 = new Thread(countA);
		thread1.setName("A");
		//thread1.setPriority(Thread.MAX_PRIORITY);
		System.out.println(thread1.getState());
		
		CountFrom1 countB = new CountFrom1("B", thread1);
		Thread thread2 = new Thread(countB);
		//thread2.setPriority(Thread.MIN_PRIORITY);
		
		
		thread1.start();
		thread2.start();
		
		
		//thread2.interrupt();
	/*	try {
			Thread.sleep(150);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println("!!!!!!!!!!!!!--------------------!!!!!!!!!");
		//thread2.interrupt();
		
		//System.out.println(thread2.interrupted());
	}
	
}

class CountFrom1 implements Runnable{
	
	private String name;
	private Thread thread;
	
	public CountFrom1(String name){
		this.name = name;
	}
	
	public CountFrom1(String name, Thread thread){
		this(name);
		if(thread!=null){
			this.thread = thread;
		}
	}

	@Override
	public void run() {
		
		int i = 0;
		while(!Thread.currentThread().interrupted()){
			if(i==1000){
				return;
			}
			System.out.println(name+(i++));
		}
		
		/*for(int i=1; i<=20; i++){
			
			try {
				if(name.equals("B")){
					//Thread.sleep(100);
				}else{
					//Thread.sleep(10);
				}
				 
				if(i==10 && this.name.equals("A")){
					Thread.currentThread().interrupt();
					//return;
				}
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(thread!=null){
				System.out.println(thread.getName()+" in "+ name +"----"+thread.getState());
			}
			System.out.println(Thread.currentThread().interrupted()+"----"+name+"---"+i+"---"+Thread.currentThread().getState());
		}*/
	}

	public String getThisName() {
		return name;
	}

	public void setThisName(String name) {
		this.name = name;
	}

	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}
	
	
	
}
