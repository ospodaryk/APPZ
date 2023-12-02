package com.project.appz.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
public class CabinetDto {

    private Long id;

    private Long doctorId;

    private Long userId;

    private String disease;

}
