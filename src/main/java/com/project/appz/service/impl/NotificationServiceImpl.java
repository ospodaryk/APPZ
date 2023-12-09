package com.project.appz.service.impl;


import com.project.appz.models.entities.Notification;
import com.project.appz.service.NotificationService;
import com.project.appz.utils.Logger;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class NotificationServiceImpl implements NotificationService {
    Logger logger;

    @Override
    public void sendNotification(Notification notification) {
        if (notification == null || notification.getMessage() == null) {
            throw new IllegalArgumentException("Notification and its message must not be null");
        }

        // Logic to send the notification
        // ...

        // Log the action
        logger.log("INFO", "Sending notification: " + notification.getMessage());
    }

    @Override
    public void scheduleNotification(Notification notification, Date scheduledTime) {
        if (notification == null || scheduledTime == null) {
            throw new IllegalArgumentException("Notification and scheduled time must not be null");
        }

        // Logic to schedule the notification
        // ...

        // Log the action
        logger.log("INFO", "Scheduling notification for: " + scheduledTime.toString());
    }
}
