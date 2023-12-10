package com.project.appz.service.notification.impl;

import com.project.appz.service.notification.EmailService;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    @Override
    public void sendMessage(String to, String subject, String text) {

    }

//    @Autowired
//    private JavaMailSender mailSender;
//
//    public void sendMessage(String to, String subject, String text) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom("appz.rehabilitation.service@gmail.com");
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(text);
//        mailSender.send(message);
//    }
}