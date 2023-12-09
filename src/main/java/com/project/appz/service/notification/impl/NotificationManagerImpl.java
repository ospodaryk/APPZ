package com.project.appz.service.notification.impl;

import com.project.appz.models.entities.PollAssignment;
import com.project.appz.service.notification.EmailService;
import com.project.appz.service.notification.Notification;
import com.project.appz.service.notification.NotificationManager;
import com.project.appz.service.notification.impl.EventManager;
import com.project.appz.service.notification.impl.NotificationListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class NotificationManagerImpl implements NotificationManager {
    EventManager eventManager;
    EmailService emailService;

    @Autowired
    public NotificationManagerImpl(EventManager eventManager, EmailService emailService) {
        this.eventManager = eventManager;
        this.emailService = emailService;
    }

    @Override
    public Notification createNotification(PollAssignment pollAssignment) {
        String doctorName = pollAssignment.getDoctor().getName() + " " + pollAssignment.getDoctor().getSurname(); // Adjust based on actual fields
        String subject = "Test Assignment: " + pollAssignment.getPoll().getPollTitle();
        String text = String.format("Doctor %s has prescribed a test '%s' for you. Please complete it by %s.",
                doctorName, pollAssignment.getPoll().getPollTitle(), pollAssignment.getDeadline().toString());

        Notification notification = new Notification();
        notification.pollAssignmentId = pollAssignment.getId();
        notification.destinationEmail = pollAssignment.getUser().getEmail(); // Assuming User has an email field
        notification.text = text;
        notification.scheduleTime = pollAssignment.getDeadline(); // or any other logic for scheduling
        notification.subject = subject;
        return notification;
    }

    @Override
    public Notification createDeadlineNotification(PollAssignment pollAssignment) {
        String doctorName = pollAssignment.getDoctor().getName() + " " + pollAssignment.getDoctor().getSurname(); // Adjust based on actual fields
        String subject = "Urgent: Test Deadline Approaching";
        String text = String.format("Reminder from Doctor %s: Only one hour left to complete the test '%s'. Deadline is %s.",
                doctorName, pollAssignment.getPoll().getPollTitle(), pollAssignment.getDeadline().toString());

        Notification notification = new Notification();
        notification.pollAssignmentId = pollAssignment.getId();
        notification.destinationEmail = pollAssignment.getUser().getEmail(); // Assuming User has an email field
        notification.text = text;
        notification.scheduleTime = pollAssignment.getDeadline(); // One hour before deadline
        notification.subject = subject;
        return notification;
    }

    @Override
    public void sendMessage(Notification notification) {
        emailService.sendMessage(notification.destinationEmail, notification.subject, notification.text);
    }

    @Override
    public void scheduleNotification(Notification notification) {
        LocalDate scheduleDate = notification.scheduleTime.toLocalDate();
        NotificationListener listener = new NotificationListener(notification, emailService);
        eventManager.subscribe(scheduleDate, listener);
    }

    @Override
    public void removeNotification(Notification notification) {
        LocalDate scheduleDate = notification.scheduleTime.toLocalDate();
        eventManager.unsubscribe(scheduleDate, notification.pollAssignmentId);
    }

    @Override
    public void sendScheduledNotifications(LocalDate date) {
        eventManager.notify(date);
    }
}
