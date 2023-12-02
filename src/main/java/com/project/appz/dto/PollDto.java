package com.project.appz.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@RequiredArgsConstructor
public class PollDto {

    private Long id;

    private List<Long> questions = new ArrayList<>();

    private Long userId;

    private Long notificationId;
}
