package com.project.appz.models.dto;

import lombok.Data;

import java.util.List;

@Data
public class ResponseDto {
    long userId;
    long pollId;
    List<ResponseQuestionPollDto> answers;
}
