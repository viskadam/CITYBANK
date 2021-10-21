package com.company.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.company.model.Customer;

@Service
public class Notification_reg {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	private JavaMailSender jms;
	
	@Autowired
	public Notification_reg(JavaMailSender jms) {
		this.jms = jms;
	}
	public void sendNotif(Customer customer) throws MailException {
		String notify;
		String message;
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(customer.getEmail());
		mail.setFrom("dev26134@gmail.com");
//		if(value=="update")
//			
//		{
//			 notify="Update Notification";
//			 message = "You have successfully updated your password";
//
//		}
//		
//		else
//		{
//			 notify="Email Notification";
//			 message = "This is a Confirmation email: \n Username: "+customer.getUsername()+" \n Password" +customer.getPassword();
//
//		}
		
		
		mail.setSubject("Email Notification");
		mail.setText("This is a Confirmation email: \n Username: "+customer.getUsername()+" \n Password "+customer.getPassword());

		
		
		jms.send(mail);
	}
}
	
//	public void updateNotif(String email) throws MailException {
//		SimpleMailMessage mail2 = new SimpleMailMessage();
//		mail2.setTo(email);
//		mail2.setFrom("8347.leesa.becomp@gmail.com");
//		mail2.setSubject("Update Notification");
//		mail2.setText("Your Password has been update successfully ");
//		
//		
//		
//		jms.send(mail2);
//	}