package com.project.appz.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
public class ResponsePollDto {
    private Long id;
    private Long poll;
    private Long result;
}
