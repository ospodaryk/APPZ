package com.project.appz.interfaces;

import com.project.appz.entities.Poll;
import com.project.appz.entities.ResponsePoll;
import com.project.appz.entities.User;

import java.util.List;


public interface IPollManager {
    void createPoll(Poll poll);

    void assignPollToPatient(Poll poll, User patient);

    List<ResponsePoll> getPollResults(Poll poll);
}
