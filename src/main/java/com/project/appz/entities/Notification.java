package com.project.appz.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "scheduled_time")
    private Date scheduledTime;

    @Column(name = "checked")
    private Boolean checked;

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
