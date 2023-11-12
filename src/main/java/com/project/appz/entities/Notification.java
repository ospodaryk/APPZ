package com.project.appz.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "notification")
public class Notification {
    @Id
    @Column(name = "notification_id")
    String notificationId;

    @NotBlank
    @Column(name = "message")
    String message;

    @Column(name = "scheduled_time")
    Date scheduledTime;

    @Column(name = "checked")
    Boolean checked;


    public void schedule() {
        // Implementation
    }

    public void send() {
        // Implementation
    }

    public void cancel() {
        // Implementation
    }

    public void check() {
        // Implementation
    }
}
