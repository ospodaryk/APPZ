package com.project.appz.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "answer_text", nullable = false)
    private String answerText;

    @Column(name = "is_chosen")
    private Boolean isChosen;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
}
