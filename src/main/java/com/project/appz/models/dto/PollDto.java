package com.project.appz.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PollDto {
    Long pollId;
    String pollTitle;
    List<QuestionDto> questionDtos = new ArrayList<>();

}
