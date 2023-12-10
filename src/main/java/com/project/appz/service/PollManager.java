package com.project.appz.service;

import com.project.appz.models.dto.PollAssignmentDto;
import com.project.appz.models.dto.ResponseDto;
import com.project.appz.models.entities.Poll;
import com.project.appz.models.entities.Statistic;
import com.project.appz.models.entities.User;

import java.util.List;


public interface PollManager {
    void createPoll(Poll poll);

    void assignPoll(PollAssignmentDto pollAssignmentDto);

    List<Statistic> getPollResults(Poll poll);

    public Poll findPollById(Long pollId, Long userId);

    public void savePollResults(ResponseDto responsePollDto);
}
