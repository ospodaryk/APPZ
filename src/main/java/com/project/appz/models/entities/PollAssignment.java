package com.project.appz.models.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "poll_assignment")
public class PollAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "poll_id")
    private Poll poll;

    @Column(name = "deadline")
    private LocalDateTime deadline;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "is_completed")
    private Boolean isCompleted;
}
