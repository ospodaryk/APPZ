package com.project.appz.interfaces;

import com.project.appz.entities.Notification;

import java.util.Date;

public interface INotificationService {
    void sendNotification(Notification notification);

    void scheduleNotification(Notification notification, Date scheduledTime);
}
