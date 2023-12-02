package com.project.appz.servises;

import com.project.appz.entities.Notification;
import com.project.appz.interfaces.INotificationService;
import com.project.appz.utils.Logger;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class NotificationServiceImpl implements INotificationService {
    Logger logger;

    @Override
    public void sendNotification(Notification notification) {
        // Implementation to send the notification
        Logger.getInstance().log("Sending notification: " + notification.getMessage());
    }

    @Override
    public void scheduleNotification(Notification notification, Date scheduledTime) {
        // Implementation to schedule the notification
        Logger.getInstance().log("Scheduling notification for: " + scheduledTime.toString());
    }
}
