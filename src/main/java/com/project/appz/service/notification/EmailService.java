package com.project.appz.service.notification;

public interface EmailService {
    void sendMessage(String to, String subject, String text);
}
