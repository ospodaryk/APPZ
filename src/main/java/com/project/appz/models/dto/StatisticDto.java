package com.project.appz.models.dto;

import com.project.appz.models.enums.StatisticVariants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StatisticDto {
    Double negative;
    Double positive;
}
