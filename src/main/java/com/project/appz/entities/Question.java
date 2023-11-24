package com.project.appz.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
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
    private Long id;

    @NotBlank
    @Column(name = "question_text", nullable = false)
    private String questionText;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers = new ArrayList<>();

    @ManyToMany
    private List<Poll> polls = new ArrayList<>();
    ;

    // New methods
    public void setAnswers(List<String> answers) {
        // Implementation
    }

    public String getQuestionText() {
        // Implementation
        return "";
    }
}
