package com.project.appz.service.impl;

import com.project.appz.models.dto.ShortPollDto;
import com.project.appz.models.entities.PollAssignment;
import com.project.appz.models.entities.Response;
import com.project.appz.repository.*;
import com.project.appz.service.PollAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PollAssignmentImplAssignment implements PollAssignmentService {
    private final PollRepository pollRepository;
    private final PollAssignmentRepository pollAssignmentRepository;

    private final ResponseRepository responseRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final UserRepository userRepository;
    private final StatisticRepository statisticRepository;

    @Autowired
    public PollAssignmentImplAssignment(PollRepository pollRepository, PollAssignmentRepository pollAssignmentRepository, ResponseRepository responseRepository, QuestionRepository questionRepository, AnswerRepository answerRepository, UserRepository userRepository, StatisticRepository statisticRepository) {
        this.pollRepository = pollRepository;
        this.pollAssignmentRepository = pollAssignmentRepository;
        this.responseRepository = responseRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
        this.userRepository = userRepository;
        this.statisticRepository = statisticRepository;
    }


    @Override
    public List<ShortPollDto> findAllByUser(Long userId) {
        List<PollAssignment> pollAssignments = pollAssignmentRepository.findByUserIdAndAndIsCompleted(userId, true);
        List<ShortPollDto> shortPollDtos = new ArrayList<>();
        for (int i = 0; i < pollAssignments.size(); i++) {
            Long pollId = pollAssignments.get(i).getPoll().getId();
            List<Response> responses = responseRepository.findByUserIdAndPollId(userId, pollId);
            shortPollDtos.add(ShortPollDto.builder()
                    .pollDate(responses.get(0).getResponseDate())
                    .id(pollAssignments.get(i).getPoll().getId())
                    .pollTitle(pollAssignments.get(i).getPoll().getPollTitle())
                    .build());
        }
        return shortPollDtos;
    }
}
