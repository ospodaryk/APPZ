package com.project.appz.controller;

import com.project.appz.models.dto.BigStatisticDto;
import com.project.appz.models.dto.ShortPollDto;
import com.project.appz.models.dto.StatisticDto;
import com.project.appz.service.PollAssignmentService;
import com.project.appz.service.QuestionService;
import com.project.appz.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/statistic")
public class StatisticController {

    private StatisticService statisticService;
    private PollAssignmentService pollAssignmentService;
    private QuestionService questionService;

    @Autowired

    public StatisticController(StatisticService statisticService, PollAssignmentService pollAssignmentService, QuestionService questionService) {
        this.statisticService = statisticService;
        this.pollAssignmentService = pollAssignmentService;
        this.questionService = questionService;
    }

    @GetMapping("/{blockId}")
    @ResponseBody
    public StatisticDto filterMedicalRecordForUserbyDisease(@PathVariable Long blockId, @RequestParam(name = "userId") long userId) {
        return statisticService.filterByBlock(userId, blockId);
    }

    @GetMapping("/allpolls")
    @ResponseBody
    public List<ShortPollDto> gettCompletedPolls(@RequestParam(name = "userId") long userId) {
        return pollAssignmentService.findAllByUser(userId);
    }

    @GetMapping
    @ResponseBody
    public BigStatisticDto getDataByPoll(
            @RequestParam(name = "pollId") Long pollId,
            @RequestParam(name = "filterId", required = false) Long filterId,
            @RequestParam(name = "userId") Long userId) {
        BigStatisticDto bigStatisticDto = new BigStatisticDto();
        if (filterId != null) {
            bigStatisticDto.setStatisticDto(statisticService.filterByBlockAndPoll(userId, filterId, pollId));

        } else {
            bigStatisticDto.setStatisticDto(statisticService.filterByPoll(pollId));

        }
        bigStatisticDto.setFilterId(filterId);
        bigStatisticDto.setQuestionBlockSet(questionService.getQuestionBlockByPoll(userId, pollId));
        return bigStatisticDto;
    }
}
