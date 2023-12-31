package com.project.appz.service.impl;

import com.project.appz.models.dto.ResponseDto;
import com.project.appz.models.dto.ShortPollDto;
import com.project.appz.models.entities.PollAssignment;
import com.project.appz.models.entities.Response;
import com.project.appz.models.entities.Statistic;
import com.project.appz.repository.PollAssignmentRepository;
import com.project.appz.repository.ResponseRepository;
import com.project.appz.repository.StatisticRepository;
import com.project.appz.service.PollAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class PollAssignmentImplAssignment implements PollAssignmentService {
    private final PollAssignmentRepository pollAssignmentRepository;
    private final ResponseRepository responseRepository;
    private final StatisticRepository statisticRepository;

    @Autowired
    public PollAssignmentImplAssignment(PollAssignmentRepository pollAssignmentRepository, ResponseRepository responseRepository, StatisticRepository statisticRepository) {
        this.pollAssignmentRepository = pollAssignmentRepository;
        this.responseRepository = responseRepository;
        this.statisticRepository = statisticRepository;
    }


    @Override
    @Transactional
    public synchronized void save(ResponseDto responseDto) {
        PollAssignment pollAssignment = pollAssignmentRepository.findByPollIdAndUserId(responseDto.getUserId(), responseDto.getPollId());
        pollAssignment.setIsCompleted(true);
        pollAssignmentRepository.save(pollAssignment);
    }

    @Override
    public List<ShortPollDto> findAllByUser(Long userId) {
        List<PollAssignment> pollAssignments = pollAssignmentRepository.findByUserId(userId);
        List<ShortPollDto> shortPollDtos = new ArrayList<>();

        for (int i = 0; i < pollAssignments.size(); i++) {
            shortPollDtos.add(ShortPollDto.builder()
                    .id(pollAssignments.get(i).getId())
                    .pollTitle(pollAssignments.get(i).getPoll().getPollTitle())
                    .build());
        }
        return shortPollDtos;
    }

    @Override
    public List<ShortPollDto> findAllRESULTSByUser(Long userId) {
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
