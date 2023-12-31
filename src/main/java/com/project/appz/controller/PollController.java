package com.project.appz.controller;

import com.project.appz.models.dto.*;
import com.project.appz.models.entities.Poll;
import com.project.appz.service.PollAssignmentService;
import com.project.appz.service.PollManager;
import com.project.appz.service.StatisticService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/poll")
public class PollController {

    private PollManager pollManager;
    private StatisticService statisticService;
    private PollAssignmentService pollAssignmentService;

    public PollController(PollManager pollManager, StatisticService statisticService, PollAssignmentService pollAssignmentService) {
        this.pollManager = pollManager;
        this.statisticService = statisticService;
        this.pollAssignmentService = pollAssignmentService;
    }

    @GetMapping
    @ResponseBody
    public List<ShortPollDto> getAllPollForUserById(@RequestParam(name = "userId") long userId) {
        return pollAssignmentService.findAllByUser(userId);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public PollDto getPollForUserById(@PathVariable long id, @RequestParam(name = "userId") long userId) {
        Poll poll = pollManager.findPollById(id, userId);
        return map(poll);
    }

    @PostMapping("/response")
    public ResponseEntity<Void> submitResponse(@RequestBody ResponseDto responseDto) {
        pollManager.savePollResults(responseDto);
        statisticService.saveData(responseDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/assign")
    public ResponseEntity<Void> assignPollToUser(@RequestBody PollAssignmentDto pollAssignmentDto) {
        pollManager.assignPoll(pollAssignmentDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    private PollDto map(Poll poll) {
        return PollDto.builder()
                .pollId(poll.getId())
                .pollTitle(poll.getPollTitle())
                .questionDtos(
                        poll.getQuestions().stream()
                                .map(question -> QuestionDto.builder()
                                        .questionId(question.getId())
                                        .questionTitle(question.getQuestionText())
                                        .answerDtoList(question.getAnswers().stream()
                                                .map(answer -> AnswerDto.builder()
                                                        .answerId(answer.getId())
                                                        .answerTitle(answer.getAnswerText())
                                                        .build())
                                                .collect(Collectors.toList()))
                                        .build())
                                .collect(Collectors.toList())
                )
                .build();
    }

}
