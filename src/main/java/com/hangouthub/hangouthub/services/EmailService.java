package com.hangouthub.hangouthub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    
    @Autowired
    private JavaMailSender mailSender;

    public void sendForgotPasswordMail(String toEmail, String resetLink){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Password Reset Request");
        message.setText("Click the following link to reset" + resetLink);
        
        message.setFrom("www.nidhisrivastav@gmail.com");

        mailSender.send(message);
        System.out.println("Email sent successfully to "+ toEmail);
    }
}
