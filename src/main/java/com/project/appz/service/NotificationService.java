package com.project.appz.service;

import com.project.appz.models.entities.Notification;

import java.util.Date;

public interface NotificationService {
    void sendNotification(Notification notification);

    void scheduleNotification(Notification notification, Date scheduledTime);
}
