package com.charmyin.practice.interfacetest;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;


/**
 * Test datetime
 * 
 * @author YinCM
 * @date 2013-10-24 20:53:43
 */
public class InnerClass {

	public static void main(String[] args){
		TalkingClock talkingClock = new TalkingClock(2000, true);
		talkingClock.start();
		
		JOptionPane.showMessageDialog(null, "Quit program?");
		
		System.exit(0);
	}
	
	
}

class TalkingClock {

	private int interval = 5000;
	private boolean beep;

	public TalkingClock(int interval, boolean beep){
		this.interval = interval;
		this.beep = beep;
	}
	
	public void start(){
		InnerTimePrinter itp = new InnerTimePrinter();
		Timer t = new Timer(interval, itp);
		t.start();
	}
	
	private class InnerTimePrinter implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Date now = new Date();
			System.out.println("At the tone, the time is " + now);
			if (beep)
				Toolkit.getDefaultToolkit().beep();
		}

	}
}
