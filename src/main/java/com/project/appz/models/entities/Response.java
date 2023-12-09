package com.project.appz.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "response")
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "poll_id")
    private Long pollId;

    @JoinColumn(name = "user_id")
    private Long userId;

    @JoinColumn(name = "answer_id")
    private Long answerId;
    @JoinColumn(name = "question_id")
    private Long questionId;

}
