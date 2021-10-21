package com.company.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.company.model.Customer;


@Service
@SessionAttributes("email")
public class Notification_cust {
	private JavaMailSender javaMailSender;


	
	@Autowired
	public Notification_cust(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}



	public void sendEmail(Customer user) throws MailException {

	
		
		SimpleMailMessage mail = new SimpleMailMessage();
		//System.out.println(user.getEmail());
		mail.setFrom("dev26134@gmail.com");
		mail.setTo("devanshimadhani20@gmail.com");
		
		mail.setSubject("Kyc request initiated");
		mail.setText("ekyc no:2345");

		
	javaMailSender.send(mail);
	}

	
	

}