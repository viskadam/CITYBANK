package com.company.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.company.model.Customer;

@Service
public class UpdateNotification {
	
	private JavaMailSender jms;
	
	@Autowired
	public UpdateNotification(JavaMailSender jms) {
		this.jms = jms;
	}
	
	public void updateNotif(String email) throws MailException {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(email);
		mail.setFrom("8347.leesa.becomp@gmail.com");	
		mail.setSubject("Password Updated");
		mail.setText("This is to notify you that you password has been successfully updated");

		
		
		jms.send(mail);
	}

}
