package com.spring.mail.sender.Services;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.charset.StandardCharsets;

@Service
public class MailService {
    @Value("${email.sender.username}")
    private String Username;

    @Autowired
    private JavaMailSender javaMailSender;


    public void sendEmail(String [] toUser, String subject, String message ){
        SimpleMailMessage mailMessage= new SimpleMailMessage();
        mailMessage.setFrom(Username);
        mailMessage.setTo(toUser);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);

        javaMailSender.send(mailMessage);
    }

    public void sendEmailFile(String [] toUser, String subject, String message, File file){
       try {
           MimeMessage mimeMessage= javaMailSender.createMimeMessage();
           MimeMessageHelper mimeMessageHelper= new MimeMessageHelper(mimeMessage,true, StandardCharsets.UTF_8.name());
           mimeMessageHelper.setFrom(Username);
           mimeMessageHelper.setTo(toUser);
           mimeMessageHelper.setSubject(subject);
           mimeMessageHelper.setText(message);
           mimeMessageHelper.addAttachment(file.getName(), file);

           javaMailSender.send(mimeMessage);
       }catch (MessagingException e){
           throw  new RuntimeException(e);
       }
    }
}
