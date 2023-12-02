package com.project.appz.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
public class DoctorDto {

    private Long id;

    private String specialization;

    private String name;

    private String surname;

    private String phoneNumber;

    private String email;

}
