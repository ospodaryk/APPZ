package com.project.appz.servises;

import com.project.appz.entities.Notification;
import com.project.appz.interfaces.INotificationService;

import java.util.Date;

public class NotificationListener implements EventListener {
    public Date getSendTime() {
        return sendTime;
    }

    private Date sendTime;
    private Notification notification;
    private INotificationService notificationService;

    public NotificationListener(Notification notification, INotificationService notificationService) {
        this.notification = notification;
        this.sendTime = notification.getScheduledTime();
        this.notificationService = notificationService;
    }

    @Override
    public long getListenerId() {
        return notification.getNotificationId();
    }

    @Override
    public void update(Date newDate) {
        notificationService.sendNotification(notification);
        this.sendTime = newDate;
    }
}
