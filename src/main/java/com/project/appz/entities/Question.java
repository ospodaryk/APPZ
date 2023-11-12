package com.project.appz.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

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
