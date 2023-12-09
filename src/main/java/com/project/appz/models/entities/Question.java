package com.project.appz.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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


    @Column(name = "question_text")
    private String questionText;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers = new ArrayList<>();

    @ManyToMany
    private List<Poll> polls = new ArrayList<>();

}
