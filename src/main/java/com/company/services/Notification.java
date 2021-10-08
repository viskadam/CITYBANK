package com.company.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.company.model.Customer;

@Service
public class Notification {
	private JavaMailSender jms;
	
	@Autowired
	public Notification(JavaMailSender jms) {
		this.jms = jms;
	}
	public void sendNotif(Customer cust) throws MailException {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(cust.getEmail());
		mail.setFrom("dev26134@gmail.com");
		mail.setSubject("Request Initiated");
		mail.setText("Your kyc request is successfull.");
		
		jms.send(mail);
	}
}
