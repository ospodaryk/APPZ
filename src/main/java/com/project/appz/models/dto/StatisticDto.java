package com.project.appz.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.project.appz.models.enums.StatisticVariants;

import java.util.HashMap;
import java.util.Map;
@Data
@Builder
@AllArgsConstructor
public class StatisticDto {

    Map<String, Long> statisticMap = new HashMap<>();

    public StatisticDto() {
        statisticMap.put(StatisticVariants.GOOD.getDisplayName(),-1l);
        statisticMap.put(StatisticVariants.BAD.getDisplayName(), -1l);
    }
}
