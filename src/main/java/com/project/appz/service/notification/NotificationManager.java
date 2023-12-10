package com.project.appz.service.notification;

import com.project.appz.models.entities.PollAssignment;
import com.project.appz.service.notification.Notification;

import java.time.LocalDate;

public interface NotificationManager {

    Notification createNotification(PollAssignment pollAssignment);
    Notification createDeadlineNotification(PollAssignment pollAssignment);
    void sendMessage(Notification notification);

    public void scheduleNotification(Notification notification);

    public void removeNotification(Notification notification);

    public void sendScheduledNotifications(LocalDate date);
}
