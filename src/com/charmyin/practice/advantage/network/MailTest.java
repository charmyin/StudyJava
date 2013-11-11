package com.charmyin.practice.advantage.network;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * This program shows how to use sockets to send plain text mail messages.
 * 
 * 
 */
public class MailTest {
	public static void main(String[] args) {
		JFrame frame = new MailTestFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

/**
 * The frame for the mail GUI.
 */
class MailTestFrame extends JFrame {
	public MailTestFrame() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setTitle("MailTest");

		setLayout(new GridBagLayout());

		// we use the GBC convenience class of Core Java Volume 1 Chapter 9
		add(new JLabel("From:"), new GBC(0, 0).setFill(GBC.HORIZONTAL));

		from = new JTextField(20);
		add(from, new GBC(1, 0).setFill(GBC.HORIZONTAL).setWeight(100, 0));

		add(new JLabel("To:"), new GBC(0, 1).setFill(GBC.HORIZONTAL));

		to = new JTextField(20);
		add(to, new GBC(1, 1).setFill(GBC.HORIZONTAL).setWeight(100, 0));

		add(new JLabel("SMTP server:"), new GBC(0, 2).setFill(GBC.HORIZONTAL));

		smtpServer = new JTextField(20);
		add(smtpServer, new GBC(1, 2).setFill(GBC.HORIZONTAL).setWeight(100, 0));

		message = new JTextArea();
		add(new JScrollPane(message), new GBC(0, 3, 2, 1).setFill(GBC.BOTH)
				.setWeight(100, 100));

		comm = new JTextArea();
		add(new JScrollPane(comm), new GBC(0, 4, 2, 1).setFill(GBC.BOTH)
				.setWeight(100, 100));

		JPanel buttonPanel = new JPanel();
		add(buttonPanel, new GBC(0, 5, 2, 1));

		JButton sendButton = new JButton("Send");
		buttonPanel.add(sendButton);
		sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				new Thread(new Runnable() {
					public void run() {
						comm.setText("");
						sendMail();
					}
				}).start();
			}
		});
	}

	/**
	 * Sends the mail message that has been authored in the GUI.
	 */
	public void sendMail() {
		try {
			
			SendMailTest smt = new SendMailTest("charmyin@sina.com" , "smtp.sina.com", 25, "charmyin@sina.com", "ycm199808");
			//SendMailTest smt = new SendMailTest(from.getText() , smtpServer.getText(), "25", "charmyin@sina.com", "ycm199808");
			//smt.sendEmail("charmyin", "subject", to.getText());
			smt.sendEmail("charmyin", "subject", "976582265@qq.com");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Sends a string to the socket and echoes it in the comm text area.
	 * 
	 * @param s
	 *            the string to send.
	 */
	public void send(String s) throws IOException {
		comm.append(s);
		comm.append("\n");
		out.print(s.replaceAll("\n", "\r\n"));
		out.print("\r\n");
		out.flush();
	}

	/**
	 * Receives a string from the socket and displays it in the comm text area.
	 */
	public void receive() throws IOException {
		if (in.hasNextLine())
			;
		{
			String line = in.nextLine();
			comm.append(line);
			comm.append("\n");
		}
	}

	private Scanner in;
	private PrintWriter out;
	private JTextField from;
	private JTextField to;
	private JTextField smtpServer;
	private JTextArea message;
	private JTextArea comm;

	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 300;
}
