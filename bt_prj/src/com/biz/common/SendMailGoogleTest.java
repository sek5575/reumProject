package com.biz.common;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//------------------------------------------------------------------------
//https://www.google.com/settings/security/lesssecureapp
//	https://support.google.com/accounts/answer/6009563
// https://accounts.google.com/DisplayUnlockCaptcha
//534-5.7.14
//------------------------------------------------------------------------


import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class SendMailGoogleTest
{
	// Sender's email ID needs to be mentioned
	private final String HOST = "smtp.gmail.com";
	private final String HOST_ID = "eungyusong@gmail.com";
	private final String HOST_PW = "song486486";
	private final String HOST_PORT = "587";
	private final String HOST_STARLS = "true";
	private final String HOST_AUTH = "true";
	
//	public static void main(String [] args)
//	{
//		SendMailGoogleTest g = new SendMailGoogleTest();
//		g.sendMail();
//		
//		
//	}
	public void sendMail(String to, String subject, String body) {
		
		// Recipient's email ID needs to be mentioned.
//		String to = "eungyusong@gmail.com";
//		lss910412


		// Get system properties
		Properties properties = System.getProperties();
		// Setup mail server
		properties.put("mail.smtp.starttls.enable", HOST_STARLS);
		properties.put("mail.smtp.host", HOST);
		properties.put("mail.smtp.user", HOST_ID);
		properties.put("mail.smtp.password", HOST_PW);
		properties.put("mail.smtp.port", HOST_PORT);
		properties.put("mail.smtp.auth", HOST_AUTH);

		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties);

		try{
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set HOST_ID: header field of the header.
			message.setFrom(new InternetAddress(HOST_ID));  //누가 보낼거냐

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO,
					new InternetAddress(to));

			// Set Subject: header field
			message.setSubject(subject);

			
			message.setContent(body, "text/html");
			//message.setText(htmlStr);
			
			// Send message
			Transport transport = session.getTransport("smtp");
			transport.connect(HOST, HOST_ID, HOST_PW);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			System.out.println("Sent message successfully....");
		}catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}


//import java.util.Properties;
//
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//
//public class SendMailGoogleTest {
//
//	public static void main(String[] args) {
//
//		final String username = "coms.korea@gmail.com";
//		final String password = "dd";
//
//		Properties props = new Properties();
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.starttls.enable", "true");
//		props.put("mail.smtp.host", "smtp.gmail.com");
//		props.put("mail.smtp.port", "587");
//
//		Session session = Session.getInstance(props,
//		  new javax.mail.Authenticator() {
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(username, password);
//			}
//		  });
//
//		try {
//
//			Message message = new MimeMessage(session);
//			message.setFrom(new InternetAddress("koms.korea@gmail.com"));
//			message.setRecipients(Message.RecipientType.TO,
//				InternetAddress.parse("koms.korea@gmail.com"));
//			message.setSubject("Testing Subject");
//			message.setText("Dear Mail Crawler No spam to my email, please!");
//
//			Transport.send(message);
//
//			System.out.println("Done");
//
//		} catch (MessagingException e) {
//			throw new RuntimeException(e);
//		}
//	}
//}

//import java.util.Properties;  
//import javax.mail.*;  
//import javax.mail.internet.*;  
//
//public class SendMailGoogleTest {
//	//http://blog.naver.com/PostView.nhn?blogId=choda100&logNo=220848908601
//	
//	
//	public static void main(String[] args) {  
//
//
//		/* Outgoing Mail (SMTP) Server
//		       requires TLS : smtp.gmail.com (use authentication)
//		       Use Authentication: Yes
//		       Use STARTTLS: Yes(some clients call this SSL)
//		 Port: 465 or 587
//		 Account Name : admin@xxx.co.kr
//		 Email Address : admin@xxx.co.kr
//		 Password : xxxxxx
//		 */
//		final String user="coms.korea@gmail.com";  
//		final String password="dd";  
//
//		String from = "coms.korea@gmail.com";
//		String to = "coms.korea@gmail.com";   
//
//		//Get the session object  
//		Properties props = new Properties();  
//		props.put("mail.smtp.host", "smtp.gmail.com");
//		props.put("mail.smtp.auth", "true");  
//		props.put("mail.smtp.starttls.enable", "true");
//		props.put("mail.smtp.port", "587");
//		
//
//		Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator() {  
//			protected PasswordAuthentication getPasswordAuthentication() {  
//				return new PasswordAuthentication(user,password);  
//			}  
//		});  
//
//		//Compose the message  15*25  
//		try {  
//			MimeMessage message = new MimeMessage(session);  
//			message.setFrom(new InternetAddress(from));  
//			message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
//			message.setSubject("Send MAIL TEST......kosmo jp5");  
//			message.setText("This is simple program of sending email using JavaMail API");  
//
//			//send the message  
//			Transport.send(message);  
//
//			System.out.println("======================");  
//
//		} catch (MessagingException e) {e.printStackTrace();}  
//	}  
//}  