package com.project.appz.models.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ResponseDto {
    long userId;
    long pollId;
    Map<Long, Long> questionAnswer = new HashMap<>();
}
