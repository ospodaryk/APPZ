package com.project.appz.servises;

import com.project.appz.entities.Notification;
import com.project.appz.interfaces.INotificationService;

import java.util.Calendar;
import java.util.Date;

// NotificationManager class
public class NotificationManager {
    private EventManager events;
    private INotificationService notificationService;

    public NotificationManager(INotificationService notificationService) {
        this.events = new EventManager();
        this.notificationService = notificationService;
    }

    public void scheduleNotification(Notification notification) {
        events.subscribe(notification.getScheduledTime(), new NotificationListener(notification, notificationService));
    }

    public void removeNotification(Notification notification) {
        events.unsubscribe(notification.getScheduledTime(), notification.getNotificationId());
    }

    public void sendScheduledNotifications(Date date) {

        events.notify(date, new Date()); // Pass the actual notification object
    }

}
