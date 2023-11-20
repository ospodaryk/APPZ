package com.project.appz;

import com.project.appz.entities.Notification;
import com.project.appz.servises.NotificationServiceImpl;
import com.project.appz.utils.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class NotificationServiceImplTest {

    @Mock
    private Logger logger;

    @InjectMocks
    private NotificationServiceImpl notificationService;

    // Existing positive tests...

    // Additional Positive Tests
    @Test
    public void testSendNotificationWithValidNotification() {
        Notification notification = new Notification();
        notification.setMessage("Valid Message");
        notificationService.sendNotification(notification);
        Mockito.verify(logger).log("Sending notification: Valid Message");
    }

    @Test
    public void testScheduleNotificationWithValidInputs() {
        Notification notification = new Notification();
        Date scheduledTime = new Date();
        notificationService.scheduleNotification(notification, scheduledTime);
        Mockito.verify(logger).log("Scheduling notification for: " + scheduledTime.toString());
    }

    // Negative Tests
    @Test
    public void testSendNotificationWithNullNotification() {
        // Depending on implementation, expect an exception or specific behavior
        // Example: Expect an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            notificationService.sendNotification(null);
        });
    }

    @Test
    public void testScheduleNotificationWithNullInputs() {
        assertThrows(IllegalArgumentException.class, () -> {
            notificationService.scheduleNotification(null, new Date());
        });
        assertThrows(IllegalArgumentException.class, () -> {
            notificationService.scheduleNotification(new Notification(), null);
        });
    }

    @Test
    public void testSendNotificationWithEmptyMessage() {
        Notification emptyMessageNotification = new Notification();
        emptyMessageNotification.setMessage("");
        notificationService.sendNotification(emptyMessageNotification);
        // Verify based on expected behavior
    }

    @Test
    public void testScheduleNotificationWithPastDate() {
        Notification notification = new Notification();
        Date pastDate = new Date(System.currentTimeMillis() - 100000); // Past date
        notificationService.scheduleNotification(notification, pastDate);
        // Verify based on expected behavior
    }
}
