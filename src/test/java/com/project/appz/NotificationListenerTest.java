package com.project.appz;

import com.project.appz.service.notification.EmailService;
import com.project.appz.service.notification.Notification;
import com.project.appz.service.notification.impl.NotificationListener;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

import static org.mockito.Mockito.*;

class NotificationListenerTest {
    private NotificationListener notificationListener;
    private EmailService mockEmailService;
    private Notification mockNotification;

    @BeforeEach
    void setUp() {
        mockEmailService = Mockito.mock(EmailService.class);
        mockNotification = Mockito.mock(Notification.class);
        notificationListener = new NotificationListener(mockNotification, mockEmailService);
    }

    @Test
    void testUpdate_SendEmail() {
        LocalDateTime scheduleTime = LocalDateTime.now().plusMinutes(50);
        when(mockNotification.scheduleTime).thenReturn(scheduleTime);

        notificationListener.update();

        verify(mockEmailService, times(1)).sendMessage(anyString(), anyString(), anyString());
    }

    @Test
    void testUpdate_NotSendEmail_LessThan45Min() {
        LocalDateTime scheduleTime = LocalDateTime.now().plusMinutes(30);
        when(mockNotification.scheduleTime).thenReturn(scheduleTime);

        notificationListener.update();

        verify(mockEmailService, never()).sendMessage(anyString(), anyString(), anyString());
    }

    @Test
    void testUpdate_NotSendEmail_MoreThan60Min() {
        LocalDateTime scheduleTime = LocalDateTime.now().plusMinutes(70);
        when(mockNotification.scheduleTime).thenReturn(scheduleTime);

        notificationListener.update();

        verify(mockEmailService, never()).sendMessage(anyString(), anyString(), anyString());
    }

    @Test
    void testUpdate_NotSendEmail_PastTime() {
        LocalDateTime scheduleTime = LocalDateTime.now().minusMinutes(10);
        when(mockNotification.scheduleTime).thenReturn(scheduleTime);

        notificationListener.update();

        verify(mockEmailService, never()).sendMessage(anyString(), anyString(), anyString());
    }
}
