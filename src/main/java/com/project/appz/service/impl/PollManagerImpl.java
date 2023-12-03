package com.project.appz.service.impl;

import com.project.appz.models.entities.Poll;
import com.project.appz.models.entities.ResponsePoll;
import com.project.appz.models.entities.User;
import com.project.appz.repository.PollRepository;
import com.project.appz.service.PollManager;
import com.project.appz.utils.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PollManagerImpl implements PollManager {
    Logger logger;
    PollRepository pollRepository;

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

    public boolean isPollAssignedToUser(Long pollId, Long userId) {
        Poll poll = pollRepository.findById(pollId).orElseThrow(() -> new NullPointerException("Poll not found with ID: " + pollId));
        User user = poll.getUser();
        if (user == null) {
            throw new NullPointerException("user not found with ID: " + pollId);

        }
        return user.getId().equals(userId);
    }

    public Poll savePollResults(Long pollId, ResponsePoll responsePoll) {
        if (responsePoll == null) {
            throw new NullPointerException("Poll not found with ID: " + pollId);
        }
        Poll poll = pollRepository.findById(pollId)
                .orElseThrow(() -> new NullPointerException("Poll not found with ID: " + pollId));

        // Update poll properties with results from responsePoll
        // e.g., poll.setResults(responsePoll.getResults());

        return pollRepository.save(poll);
    }

}
