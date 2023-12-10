package com.project.appz.service.impl;

import com.project.appz.models.dto.ShortPollDto;
import com.project.appz.models.entities.Poll;
import com.project.appz.models.entities.PollAssignment;
import com.project.appz.models.entities.Response;
import com.project.appz.models.entities.Statistic;
import com.project.appz.repository.*;
import com.project.appz.service.PollAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
        List<Statistic> responsesByUser = statisticRepository.findByUserId(userId);
        List<ShortPollDto> shortPollDtos = new ArrayList<>();

        for (int i = 0; i < responsesByUser.size(); i++) {
            List<Response> responses = responseRepository.findByUserIdAndPollId(userId, responsesByUser.get(i).getPoll().getId());
            if (!responses.isEmpty()) {
                shortPollDtos.add(ShortPollDto.builder()
                        .pollDate(responses.get(0).getResponseDate())
                        .id(responsesByUser.get(i).getId())
                        .pollTitle(responsesByUser.get(i).getPoll().getPollTitle())
                        .build());
            }
        }
        return shortPollDtos;
    }

}
