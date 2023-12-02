package com.project.appz.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@RequiredArgsConstructor
public class MedicalRecordDto {
    private Long id;
    private Long patient;

    private Long doctor;

    private LocalDateTime createdTime;
    private String doctorNotes;

    private String disease;

}
