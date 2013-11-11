package com.charmyin.practice.advantage.network;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.junit.Test;

public class JunitTestMail {
	@Test
	public void sendMail() {
		try {

			SendMailTest smt = new SendMailTest("charmyin@sina.com", "smtp.sina.com", 25, "charmyin@sina.com", "ycm199808");
			// SendMailTest smt = new SendMailTest(from.getText() ,
			// smtpServer.getText(), "25", "charmyin@sina.com", "ycm199808");
			// smt.sendEmail("charmyin", "subject", to.getText());
			smt.sendEmail("今天是星期几呢，我爱你啦哈哈哈", "charmyin", "976582265@qq.com");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSendMail() {
		String SMTP_HOST_NAME = "smtp.sina.com";
		String SMTP_PORT = "25";

		String SMTP_FROM_ADDRESS = "charmyin@sina.com";
		String SMTP_TO_ADDRESS = "976582265@qq.com";
		String subject = "我爱你";
		String fileAttachment = "C:\\test.txt";

		Properties props = new Properties();

		props.put("mail.smtp.host", SMTP_HOST_NAME);
		props.put("mail.smtp.auth", "true");
		props.put("mail.debug", "true");
		props.put("mail.smtp.port", SMTP_PORT);
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
						return new javax.mail.PasswordAuthentication(
								"charmyin@sina.com", "ycm199808");
					}
				});
		try {

			Message msg = new MimeMessage(session);

			msg.setFrom(new InternetAddress(SMTP_FROM_ADDRESS));
			// create the message part
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			// fill message
			messageBodyPart.setText("Test mail one");
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			//Part two is attachment
			messageBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource(fileAttachment);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(source.getName());
			multipart.addBodyPart(messageBodyPart);
			// Put parts in message
			msg.setContent(multipart);

			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(SMTP_TO_ADDRESS));

			msg.setSubject(subject);
			//msg.setContent(content, "text/plain");

			Transport.send(msg);
			System.out.println("success....................................");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
