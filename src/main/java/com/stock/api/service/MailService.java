package com.stock.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailService {

	private JavaMailSender javaMailSender;

	@Autowired
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void sendOTPEmail(String emailId, String message) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(emailId);
		mail.setSubject("INGTMRW Model Bank");

		mail.setText("The OTP for Making Transfer" + " " + message);
		javaMailSender.send(mail);
	}

	public void sendEmail(String emailId, String userId, String password) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(emailId);
		mail.setSubject("StockManagement");
		mail.setText("Login Credentials \n " + "UserId : " + userId + "\n Password :" + password);
		javaMailSender.send(mail);
	}

}