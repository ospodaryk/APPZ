package com.project.appz.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import jakarta.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long questionId;

    @NotBlank
    @Column(name = "question_text")
    String questionText;

    @ElementCollection
    List<String> answers;

    // New methods
    public void setAnswers(List<String> answers) {
        // Implementation
    }

    public String getQuestionText() {
        // Implementation
        return "";
    }
}
