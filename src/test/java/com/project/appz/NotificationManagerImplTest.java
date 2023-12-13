package com.project.appz;

import com.project.appz.models.entities.Doctor;
import com.project.appz.models.entities.Poll;
import com.project.appz.models.entities.PollAssignment;
import com.project.appz.models.entities.User;
import com.project.appz.service.notification.EmailService;
import com.project.appz.service.notification.Notification;
import com.project.appz.service.notification.impl.EventManager;
import com.project.appz.service.notification.impl.NotificationListener;
import com.project.appz.service.notification.impl.NotificationManagerImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class NotificationManagerImplTest {
    private NotificationManagerImpl notificationManager;
    private EventManager mockEventManager;
    private EmailService mockEmailService;
    private PollAssignment mockPollAssignment;

    @BeforeEach
    void setUp() {
        mockEventManager = Mockito.mock(EventManager.class);
        mockEmailService = Mockito.mock(EmailService.class);
        mockPollAssignment = Mockito.mock(PollAssignment.class);

        Doctor mockDoctor = new Doctor();
        mockDoctor.setName("John");
        mockDoctor.setSurname("Doe");

        User mockUser = new User();
        mockUser.setEmail("user@example.com");

        Poll mockPoll = new Poll();
        mockPoll.setPollTitle("Test Poll Title");

        when(mockPollAssignment.getDoctor()).thenReturn(mockDoctor);
        when(mockPollAssignment.getUser()).thenReturn(mockUser);
        when(mockPollAssignment.getPoll()).thenReturn(mockPoll);
        when(mockPollAssignment.getDeadline()).thenReturn(LocalDateTime.now().plusDays(1));

        notificationManager = new NotificationManagerImpl(mockEventManager, mockEmailService);
    }

    @Test
    void testCreateNotification() {
        Notification notification = notificationManager.createNotification(mockPollAssignment);
        notification.scheduleTime = LocalDateTime.now().plusDays(1); // Set the field directly
        assertNotNull(notification);
    }

    @Test
    void testCreateDeadlineNotification() {
        Notification notification = notificationManager.createDeadlineNotification(mockPollAssignment);
        notification.scheduleTime = LocalDateTime.now().plusDays(1); // Set the field directly
        assertNotNull(notification);
    }

    @Test
    void testSendMessage() {
        Notification notification = new Notification();
        notification.destinationEmail = "test@example.com";
        notification.subject = "Test Subject";
        notification.text = "Test Body";
        notification.pollAssignmentId = 1;
        notification.scheduleTime = LocalDateTime.now().plusDays(1); // Set the field directly

        notificationManager.sendMessage(notification);

        verify(mockEmailService, times(1)).sendMessage(notification.destinationEmail, notification.subject, notification.text);
    }

    @Test
    void testScheduleNotification() {
        Notification notification = new Notification();
        notification.scheduleTime = LocalDateTime.now().plusDays(1); // Set the field directly

        notificationManager.scheduleNotification(notification);

        verify(mockEventManager, times(1)).subscribe(any(LocalDate.class), any(NotificationListener.class));
    }

    @Test
    void testRemoveNotification() {
        Notification notification = new Notification();
        notification.pollAssignmentId = 1;
        notification.scheduleTime = LocalDateTime.now().plusDays(1); // Set the field directly

        notificationManager.removeNotification(notification);

        verify(mockEventManager, times(1)).unsubscribe(any(LocalDate.class), eq(notification.pollAssignmentId));
    }

    @Test
    void testSendScheduledNotifications() {
        LocalDate date = LocalDate.now();
        notificationManager.sendScheduledNotifications(date);

        verify(mockEventManager, times(1)).notify(date);
    }
}
