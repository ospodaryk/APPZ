package com.project.appz.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@RequiredArgsConstructor
public class QuestionDto {
    private Long id;

    private String questionText;

    private List<Long> answers = new ArrayList<>();

    private List<Long> polls = new ArrayList<>();

}
