package com.project.appz.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@Builder
@RequiredArgsConstructor
public class NotificationDto {
    private Long id;

    private String message;
    private Date scheduledTime;

    private Boolean checked;
}
