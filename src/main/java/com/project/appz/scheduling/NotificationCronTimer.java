package com.project.appz.scheduling;

import com.project.appz.service.notification.NotificationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class NotificationCronTimer {

    private final NotificationManager notificationManager;

    @Autowired
    public NotificationCronTimer(NotificationManager notificationManager) {
        this.notificationManager = notificationManager;
    }

    @Scheduled(cron = "0 * * * * *") // Runs every minute
    public void sendNotifications() {
        LocalDate today = LocalDate.now();
        notificationManager.sendScheduledNotifications(today);
    }
}
