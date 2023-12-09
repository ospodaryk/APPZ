package com.project.appz.service.notification.impl;

import com.project.appz.service.notification.EmailService;
import com.project.appz.service.notification.EventListener;
import com.project.appz.service.notification.Notification;

import java.time.Duration;
import java.time.LocalDateTime;

public class NotificationListener implements EventListener {
    private Notification notification;
    private EmailService emailService;

    public NotificationListener(Notification notification, EmailService emailService) {
        this.notification = notification;
        this.emailService = emailService;
    }

    @Override
    public long getListenerId() {
        return notification.pollAssignmentId;
    }

    @Override
    public void update() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime scheduleTime = notification.scheduleTime;

        // Calculate time difference
        Duration duration = Duration.between(now, scheduleTime);

        if (!duration.isNegative() && duration.toMinutes() > 45 && duration.toMinutes() < 60) {
            // Assuming EmailService has a method to send emails
            emailService.sendMessage(notification.destinationEmail, notification.subject, notification.text);
        }
    }
}