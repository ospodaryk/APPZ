package com.project.appz;

import com.project.appz.models.entities.*;
import com.project.appz.models.enums.Disease;
import com.project.appz.models.enums.Specialization;
import com.project.appz.models.entities.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.time.LocalDate;

public final class ModelUtils {
    public static Cabinet getCabinet() {
        return Cabinet.builder()
                .id(1L)
                .doctor(getDoctor())
                .user(getUser())
                .disease("Cardiology")
                .build();
    }

    public static PollAssignment getPollAssignment() {
        return PollAssignment.builder()
                .id(1L)
                .doctor(getDoctor())
                .user(getUser())
                .poll(getPoll())
                .deadline(LocalDateTime.now().plusDays(30))
                .createdDate(LocalDateTime.now())
                .isCompleted(false)
                .build();
    }

    public static Response getResponse() {
        return Response.builder()
                .id(1L)
                .poll(getPoll())
                .user(getUser())
                .answer(getAnswer())
                .question(getQuestion())
                .responseDate(LocalDate.now())
                .build();
    }

    public static Statistic getStatistic() {
        return Statistic.builder()
                .id(1L)
                .poll(getPoll())
                .result(75L)
                .user(getUser())
                .build();
    }

    // Updating getQuestion method to include answers
    public static Question getQuestionWithAnswers() {
        return Question.builder()
                .id(1L)
                .questionText("What is your current health status?")
                .answers(Arrays.asList(getAnswer(), getAnswerCorrect()))
                .correctAnswer(getAnswerCorrect())
                .questionBlock(getQuestionBlock())
                .build();
    }

    public static User getUpdatedUser() {
        User user = getUser();
        user.setMedicalRecords(Collections.singletonList(getMedicalRecord_ACNE()));
        return user;
    }

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
                .blockName("General Health Assessment")
                .build();
    }

    public static final Question getQuestion() {
        return Question.builder()
                .id(1L)
                .questionBlock(getQuestionBlock())
                .questionText("How would you rate your general health?")
                .correctAnswer(getAnswerCorrect())
                .answers(Arrays.asList(getAnswerCorrect(), getAnswer()))
                .build();
    }

    public static final Answer getAnswerCorrect() {
        return Answer.builder()
                .id(1L)
                .answerText("Good")
                .build();
    }

    public static final Answer getAnswer() {
        return Answer.builder()
                .id(2L)
                .answerText("Poor")
                .build();
    }

    public static final MedicalRecord getMedicalRecord_ACNE() {
        return MedicalRecord.builder()
                .id(1L)
                .createdTime(LocalDateTime.now())
                .doctorNotes("Regular acne treatment ongoing")
                .doctor(getDoctor())
                .disease("Acne")
                .patient(getUser())
                .build();
    }


    public static final Poll getPoll() {
        return Poll.builder()
                .id(1L)
                .pollTitle("Health and Lifestyle Survey")
                .disease("General")
                .questions(Arrays.asList(getQuestion()))
                .build();
    }

    public static final MedicalRecord getMedicalRecordLastYear_ACNE() {
        return MedicalRecord.builder()
                .id(2L)
                .createdTime(LocalDateTime.now().minusYears(1))
                .doctorNotes("Initial consultation for acne")
                .doctor(getDoctor())
                .disease("Acne")
                .patient(getUser())
                .build();
    }

    public static final MedicalRecord getMedicalRecord_ECZEMA() {
        return MedicalRecord.builder()
                .id(3L)
                .createdTime(LocalDateTime.now().minusYears(1))
                .doctorNotes("Eczema treatment follow-up")
                .doctor(getDoctor())
                .disease("Eczema")
                .patient(getUser())
                .build();
    }
}
