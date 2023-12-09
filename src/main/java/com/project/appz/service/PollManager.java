package com.project.appz.service;

import com.project.appz.models.dto.ResponseDto;
import com.project.appz.models.entities.Poll;
import com.project.appz.models.entities.ResponsePoll;
import com.project.appz.models.entities.User;

import java.util.List;


public interface PollManager {
    void createPoll(Poll poll);

    void assignPollToPatient(Poll poll, User patient);

    List<ResponsePoll> getPollResults(Poll poll);

    public Poll findPollById(Long pollId, Long userId);

    public void savePollResults(ResponseDto responsePollDto);
}
