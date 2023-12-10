package com.project.appz.service;

import com.project.appz.models.dto.ShortPollDto;

import java.util.List;

public interface PollAssignmentService {
    public List<ShortPollDto> findAllByUser(Long userId);
    public List<ShortPollDto> findAllRESULTSByUser(Long userId);
    }
