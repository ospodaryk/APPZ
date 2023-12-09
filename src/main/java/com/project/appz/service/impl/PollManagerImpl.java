package com.project.appz.service.impl;

import com.project.appz.models.dto.ResponseDto;
import com.project.appz.models.entities.*;
import com.project.appz.repository.PollRepository;
import com.project.appz.repository.ResponseRepository;
import com.project.appz.service.PollManager;
import com.project.appz.utils.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PollManagerImpl implements PollManager {
    Logger logger;
    PollRepository pollRepository;
    ResponseRepository responseRepository;

    @Override
    public void createPoll(Poll poll) {
        // Implementation to create a poll
    }

    @Override
    public void assignPollToPatient(Poll poll, User patient) {
        // Implementation to assign a poll to a patient
    }

    @Override
    public List<Statistic> getPollResults(Poll poll) {
        // Implementation to get poll results
        return new ArrayList<>();
    }

    public boolean isPollAssignedToUser(Poll poll, Long userId) {
        //User user = poll.getUser();
        User user = null;
        if (user == null) {
            throw new NullPointerException("user not found with ID: " + userId);
        }
        return user.getId().equals(userId);
    }

    @Override
    public Poll findPollById(Long pollId, Long userId) {
        Poll poll = pollRepository.findById(pollId).orElseThrow(() -> new NullPointerException("Poll not found with ID: " + pollId));
        if (isPollAssignedToUser(poll, userId)) {
            return poll;
        } else throw new NullPointerException("user not found with ID: " + pollId);

    }

    @Override

    public void savePollResults(ResponseDto responsePollDto) {
//        long userID = responsePollDto.getUserId();
//        long pollId = responsePollDto.getPollId();
//        Poll poll = findPollById(pollId, userID);
//        List<Question> questions = poll.getQuestions();
//        for (int i = 0; i < questions.size(); i++) {
//            Response response = Response.builder()
//                    //.userId(userID)
//                    .pollId(pollId)
//                    .questionId(questions.get(i).getId())
//                    .answerId(responsePollDto.getQuestionAnswer().get(questions.get(i).getId()))
//                    .build();
//            responseRepository.save(response);
//        }

    }

}
