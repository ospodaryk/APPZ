package com.project.appz.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
public class AnswerDto {

    private Long id;
    private String answerText;
    private Boolean isChosen;
    private Long question;
}
