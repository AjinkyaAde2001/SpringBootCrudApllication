package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.EmpDao;
import com.example.demo.model.EmpModel;
import com.example.demo.model.LoginModel;
import com.example.demo.model.Mail;

import jakarta.mail.internet.InternetAddress;
@Service
public  class EmailServiceImpl implements EmailService {
    @Autowired
	private JavaMailSender javaMailSender;
	
	public JavaMailSender getJavaMailSender() {
		return javaMailSender;
	}

	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
@Autowired
EmpDao dao;
Mail mail;


    @Transactional
	@Override
	public void sendOtpEmail(String to, String otp) {
		
		if (javaMailSender == null) {
            throw new IllegalStateException("JavaMailSender is not initialized.");
        }
		SimpleMailMessage sm= new SimpleMailMessage();
		sm.setFrom("helloajinkya2001@gmail.com");
		 sm.setTo(to);
         sm.setSubject("Password Reset Otp");
         sm.setText("your 6 digit otp is " +otp);
        javaMailSender.send(sm);
        
	}

	
}
