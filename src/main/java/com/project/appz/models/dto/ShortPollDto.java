package com.project.appz.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShortPollDto {
    Long id;
    String pollTitle;
    LocalDate pollDate;
}
