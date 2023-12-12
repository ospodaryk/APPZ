package com.project.appz;

import com.project.appz.models.entities.*;
import com.project.appz.models.enums.Disease;
import com.project.appz.models.enums.Specialization;

import java.time.LocalDateTime;

public final class ModelUtils {
    public static final User getUser() {
        return User.builder()
                .id(1l)
                .name("Taras")
                .surname("Shevchenko")
                .phoneNumber("+380009500066")
                .email("sheva@gmail.com")
                .build();
    }

    public static final Doctor getDoctor() {
        return Doctor.builder()
                .name("Oksana")
                .specialization(Specialization.DERMATOLOGY.getDisplayName())
                .surname("Doctor")
                .phoneNumber("+380009500066")
                .email("sheva@gmail.com")
                .build();
    }
    public static final QuestionBlock getQuestionBlock() {
        return QuestionBlock.builder()
                .id(1L)
                .blockName("QuestionBlock")
                .build();
    }
    public static final Question getQuestion() {
        return Question.builder()
                .questionBlock(getQuestionBlock())
                .questionText("question Text")
                .correctAnswer(getAnswerCorrect())
                .build();
    }
    public static final Answer getAnswerCorrect() {
        return Answer.builder()
                .answerText("AnswerCorrect text")
                .build();
    }
    public static final Answer getAnswer() {
        return Answer.builder()
                .answerText("Answer text")
                .question(getQuestion())
                .build();
    }
    public static final MedicalRecord getMedicalRecord_ACNE() {
        return MedicalRecord.builder()
                .createdTime(LocalDateTime.now())
                .doctorNotes("")
                .doctor(getDoctor())
                .disease(Disease.ACNE.getDisplayName())
                .patient(getUser())
                .build();
    }

    public static final Statistic getResponsePoll() {
        return Statistic.builder()
                .id(1L)
                .build();
    }

    public static final Poll getPoll() {
        return Poll.builder()
                .id(1L)
                //.user(getUser())
                .build();
    }


    public static final MedicalRecord getMedicalRecordLastYear_ACNE() {
        return MedicalRecord.builder()
                .createdTime(LocalDateTime.MAX.minusYears(1))
                .doctorNotes("")
                .doctor(getDoctor())
                .disease(Disease.ACNE.getDisplayName())
                .patient(getUser())
                .build();
    }

    public static final MedicalRecord getMedicalRecord_ECZEMA() {
        return MedicalRecord.builder()
                .createdTime(LocalDateTime.MAX.minusYears(1))
                .doctorNotes("")
                .doctor(getDoctor())
                .disease(Disease.ECZEMA.getDisplayName())
                .patient(getUser())
                .build();
    }
}
