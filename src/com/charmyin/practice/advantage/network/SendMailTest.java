package com.charmyin.practice.advantage.network;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMailTest {

	String from;
	String smtpHost;
	int port;
	
	String login;
	String password;
	
	SendMailTest(String from, String smtpHost, int port, String login, String password){
		this.from = from;
		this.smtpHost = smtpHost;
		this.port = port;
		this.login  = login;
		this.password = password;
	}
	
	public void sendEmail(String body, String subject, String recipient)
			throws MessagingException, UnsupportedEncodingException {
		Properties mailProps = new Properties();
		mailProps.put("mail.smtp.from", from);
		mailProps.put("mail.smtp.host", smtpHost);//
		mailProps.put("mail.smtp.port", port);//
		mailProps.put("mail.smtp.auth", "true");

		Session mailSession = Session.getDefaultInstance(mailProps, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(login, password);
			}
		});

		MimeMessage message = new MimeMessage(mailSession);
		message.setFrom(new InternetAddress(from));
		String[] emails = { recipient };
		InternetAddress dests[] = new InternetAddress[emails.length];
		for (int i = 0; i < emails.length; i++) {
			dests[i] = new InternetAddress(emails[i].trim().toLowerCase());
		}
		message.setRecipients(Message.RecipientType.TO, dests);
		message.setSubject(subject, "UTF-8");
		Multipart mp = new MimeMultipart();
		MimeBodyPart mbp = new MimeBodyPart();
		mbp.setContent(body, "text/html;charset=utf-8");
		mp.addBodyPart(mbp);
		message.setContent(mp);
		message.setSentDate(new java.util.Date());

		Transport.send(message);
	}

}
