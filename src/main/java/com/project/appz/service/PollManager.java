package com.project.appz.service;

import com.project.appz.models.dto.PollAssignmentDto;
import com.project.appz.models.dto.ResponseDto;
import com.project.appz.models.entities.Poll;
import com.project.appz.models.entities.Statistic;

import java.util.List;


public interface PollManager {

    void assignPoll(PollAssignmentDto pollAssignmentDto);

    public Poll findPollById(Long pollId, Long userId);

    public void savePollResults(ResponseDto responsePollDto);
}
