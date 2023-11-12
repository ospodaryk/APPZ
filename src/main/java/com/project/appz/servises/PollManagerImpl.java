package com.project.appz.servises;

import com.project.appz.entities.Poll;
import com.project.appz.entities.ResponsePoll;
import com.project.appz.entities.User;
import com.project.appz.interfaces.IPollManager;
import com.project.appz.utils.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PollManagerImpl implements IPollManager {
    Logger logger;

    @Override
    public void createPoll(Poll poll) {
        // Implementation to create a poll
    }

    @Override
    public void assignPollToPatient(Poll poll, User patient) {
        // Implementation to assign a poll to a patient
    }

    @Override
    public List<ResponsePoll> getPollResults(Poll poll) {
        // Implementation to get poll results
        return new ArrayList<>();
    }
}
