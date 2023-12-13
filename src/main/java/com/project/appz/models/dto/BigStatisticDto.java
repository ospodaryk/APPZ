package com.project.appz.models.dto;

import com.project.appz.models.entities.QuestionBlock;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BigStatisticDto {
    Long filterId;
    String titleOfPoll;
    StatisticDto statistic;
    Set<QuestionBlock> questionBlockSet;
}
