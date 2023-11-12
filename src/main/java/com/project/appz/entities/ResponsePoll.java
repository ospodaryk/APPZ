package com.project.appz.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "response_poll")
public class ResponsePoll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long responseId;

    @ManyToOne
    @JoinColumn(name = "poll_id")
    Poll poll;

    @Column(name = "result")
    Long result;


    public void submitResponse() {
        // Implementation
    }

    public Long getResponseDetails() {
        // Implementation
        return 0L;
    }
}
