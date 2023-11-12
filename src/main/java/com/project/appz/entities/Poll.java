package com.project.appz.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "poll")
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long pollId;

    @OneToMany(mappedBy = "poll")
    Set<Question> questions;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @OneToOne
    @JoinColumn(name = "notification_id")
    Notification notification;

    public void addQuestion(Question question) {
        // Implementation
    }

    public Set<ResponsePoll> getResponses() {
        // Implementation
        return new HashSet<>();
    }
}
