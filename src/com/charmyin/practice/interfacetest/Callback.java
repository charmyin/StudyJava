package com.charmyin.practice.interfacetest;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * Test Interface and callbacks
 * @author YinCM
 * @since
 */
public class Callback {
	
	
	public static void main(String[] args){
		
		ActionListener listener = new TimePrinter();
		
		Timer t = new Timer(5000, listener);
		
		t.start();
		
		JOptionPane.showMessageDialog(null, "Quit program?");
		
		System.exit(0);
		
	}
}

class TimePrinter implements ActionListener{
	
	public void actionPerformed(ActionEvent event){
		Date now = new Date();
		SimpleDateFormat stf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		System.out.println("At this tone, the time is "+stf.format(now));
		Toolkit.getDefaultToolkit().beep();
	}
	class myme{
		String name = "223";
	}
}










