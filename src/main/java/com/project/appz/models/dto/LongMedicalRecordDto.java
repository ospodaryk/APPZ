package com.project.appz.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LongMedicalRecordDto {
    Long id;
    String title;
    String doctorName;
    String dateofvisit;
    private String doctorNotes;
}
