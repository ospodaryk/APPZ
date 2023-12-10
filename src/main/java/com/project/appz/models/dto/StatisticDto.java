package com.project.appz.models.dto;

import com.project.appz.models.enums.StatisticVariants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
public class StatisticDto {

    Map<String, Double> statisticMap = new HashMap<>();

    public StatisticDto() {
        statisticMap.put(StatisticVariants.GOOD.getDisplayName(), 0.0);
        statisticMap.put(StatisticVariants.BAD.getDisplayName(), 0.0);
    }
}
