package com.project.appz.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDto {
    List<DiseaseDTO> diseases;
    private String name;
    private long id;
    private DoctorDto doctorDto;

}
