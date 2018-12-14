package com.biz.common;

//자바의 apk 에디션 검색해보자
//standard e 
//enterPrise e 
//micro e
import java.util.*;  
import javax.mail.*;  
import javax.mail.internet.*;  
import javax.activation.*; 


public class SendMailTest {
	public static void main(String [] args){  
		String to = "eungyusong@gmail.com"; //change accordingly  
		String from = "eungyusong@gmail.com";  //change accordingly  
		String host = "localhost";//or IP address  

		//Get the session object  
		Properties properties = System.getProperties();  
		properties.setProperty("mail.smtp.host", host);  
		Session session = Session.getDefaultInstance(properties);  

		//compose the message  
		try{  
			MimeMessage message = new MimeMessage(session);  
			message.setFrom(new InternetAddress(from));  
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
			message.setSubject("웹메일 TEST 중...");  
			message.setText("Hello, this is example of sending email  ");  

			// Send message  
			Transport.send(message);  
			System.out.println("message sent successfully....");  

		}catch (MessagingException e)
			{e.printStackTrace();}  
	}   

}
