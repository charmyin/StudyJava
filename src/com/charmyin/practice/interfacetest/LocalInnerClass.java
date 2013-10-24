package com.charmyin.practice.interfacetest;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import com.charmyin.practice.classObjects.Employee;


/**
 * Test datetime
 * 
 * @author YinCM
 * @date 2013-10-24 20:53:43
 */
public class LocalInnerClass {

	public static void main(String[] args){
		TalkingClock talkingClock = new TalkingClock(2000, true);
		talkingClock.start();
		
		JOptionPane.showMessageDialog(null, "Quit program?");
		
		
		Employee emp = new Employee("cm",12){
			private boolean sex = false;
			private String father = "ls";
			public String toString(){
				return this.getName()+"-"+this.getAge()+"-"+this.sex+"_"+this.getHireDay();
			}
		};
		
		System.out.println(emp.toString());
		System.exit(0);
		
	}
	
	
}

class LocalTalkingClock {

	private int interval = 5000;
	private boolean beep;

	public LocalTalkingClock(int interval, boolean beep){
		this.interval = interval;
		this.beep = beep;
	}
	
	public void start(){
		/*class InnerTimePrinter implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				Date now = new Date();
				System.out.println("At the tone, the time is " + now);
				if (beep)
					Toolkit.getDefaultToolkit().beep();
			}

		}
		InnerTimePrinter itp = new InnerTimePrinter();*/
		
		ActionListener itp = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Date now = new Date();
				System.out.println("At the tone, the time is " + now);
				if (beep)
					Toolkit.getDefaultToolkit().beep();
			}

		};
		
		Timer t = new Timer(interval, itp);
		t.start();
	}
	
}
