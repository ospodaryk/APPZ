package com.project.appz.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@RequiredArgsConstructor
public class UserDto {
    private Long id;

    private String name;
    private String surname;
    private String phoneNumber;

    private String email;

    private List<Long> medicalRecords = new ArrayList<>();
}
