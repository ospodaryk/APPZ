package com.project.appz.service.notification;

import java.time.LocalDateTime;

public class Notification {
    public long pollAssignmentId;
    public String destinationEmail;
    public String text;
    public String subject;
    public LocalDateTime scheduleTime;
}
