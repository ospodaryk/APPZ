package com.project.appz.service.impl;

import com.project.appz.models.dto.ResponseDto;
import com.project.appz.models.dto.StatisticDto;
import com.project.appz.models.entities.*;
import com.project.appz.models.enums.Disease;
import com.project.appz.models.enums.StatisticVariants;
import com.project.appz.repository.*;
import com.project.appz.service.PollAssignmentService;
import com.project.appz.service.StatisticService;
import com.project.appz.utils.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StatisticServiceImpl implements StatisticService {
    private final PollRepository pollRepository;
    private final ResponseRepository responseRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final UserRepository userRepository;
    private final StatisticRepository statisticRepository;
    private final PollAssignmentService pollAssignmentService;

    Logger logger;

    @Autowired
    public StatisticServiceImpl(PollRepository pollRepository, ResponseRepository responseRepository, QuestionRepository questionRepository, AnswerRepository answerRepository, UserRepository userRepository, StatisticRepository statisticRepository, PollAssignmentService pollAssignmentService) {
        this.pollRepository = pollRepository;
        this.responseRepository = responseRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
        this.userRepository = userRepository;
        this.statisticRepository = statisticRepository;
        this.pollAssignmentService = pollAssignmentService;
    }

    @Override
    public void saveData(ResponseDto responseDto) {
        User user = userRepository.findById(responseDto.getUserId()).orElseThrow(() -> new NullPointerException("Poll not found with ID: "));
        Poll poll = pollRepository.findById(responseDto.getPollId()).orElseThrow(() -> new NullPointerException("Poll not found with ID: "));
        Statistic statistic = Statistic.builder().build();
        statistic.setUser(user);
        statistic.setPoll(poll);
        int result = 0;
        Map<Long, Long> questions = responseDto.getQuestionAnswer();
        for (Long key : questions.keySet()) {
            Question question = questionRepository.findById(key).orElseThrow(() -> new NullPointerException("Poll not found with ID: "));
            Answer answerUser = answerRepository.findById(questions.get(key)).orElseThrow(() -> new NullPointerException("Poll not found with ID: "));
            if (question.getCorrectAnswer().equals(answerUser)) {
                result++;
            }
        }
        statistic.setResult(Long.valueOf(result / questions.size()));
        statisticRepository.save(statistic);
//        pollAssignmentService.save(responseDto);

    }

    @Override
    public StatisticDto filterByPoll(Long statisticId) {
        Statistic statistic = statisticRepository.findById(statisticId).orElseThrow();

        StatisticDto statisticDto = new StatisticDto();

        statisticDto.getStatisticMap().replace(StatisticVariants.GOOD.getDisplayName(), Double.valueOf(statistic.getResult()));
        statisticDto.getStatisticMap().replace(StatisticVariants.BAD.getDisplayName(), Double.valueOf(100 - statistic.getResult()));

        return statisticDto;
    }

    @Override
    public StatisticDto filterByBlockAndPoll(Long patient, Long statisticpollId, Long blockId) {
        Statistic statistics = statisticRepository.findById(statisticpollId).orElseThrow();

        List<Response> responses = responseRepository.findByUserIdAndPollId(patient, statistics.getPoll().getId())
                .stream()
                .filter(response -> response.getPoll().getQuestions()
                        .stream()
                        .anyMatch(question -> blockId.equals(question.getQuestionBlock().getId())))
                .collect(Collectors.toList());
        int result = 0;
        for (int i = 0; i < responses.size(); i++) {
            Response response = responses.get(i);
            if (response.getAnswer().equals(response.getQuestion().getCorrectAnswer())) {
                result++;
            }
        }
        Double statistic = Double.valueOf((result / responses.size()) * 100);
        StatisticDto statisticDto = new StatisticDto();

        statisticDto.getStatisticMap().replace(StatisticVariants.GOOD.getDisplayName(), statistic);
        statisticDto.getStatisticMap().replace(StatisticVariants.BAD.getDisplayName(), 100 - statistic);

        return statisticDto;
    }

    @Override
    public StatisticDto filterByBlock(Long patient, Long blockId) {
        List<Response> responses = responseRepository.findByUserId(patient)
                .stream()
                .filter(response -> response.getPoll().getQuestions()
                        .stream()
                        .anyMatch(question -> blockId.equals(question.getQuestionBlock().getId())))
                .collect(Collectors.toList());
        int result = 0;
        for (int i = 0; i < responses.size(); i++) {
            Response response = responses.get(i);
            if (response.getAnswer().equals(response.getQuestion().getCorrectAnswer())) {
                result++;
            }
        }
        Double statistic = Double.valueOf((result / responses.size()) * 100);
        StatisticDto statisticDto = new StatisticDto();

        statisticDto.getStatisticMap().replace(StatisticVariants.GOOD.getDisplayName(), statistic);
        statisticDto.getStatisticMap().replace(StatisticVariants.BAD.getDisplayName(), 100 - statistic);

        return statisticDto;
    }

    @Override
    public List<StatisticDto> filterByDisease(Long patient, String disease) {
        return null;
    }

    @Override
    public List<Integer> getStatistic(User user, Disease disease) {
        return null;
    }

    @Override
    public List<Integer> getStatistic(User user, Disease disease, Poll poll) {
        return null;
    }

    @Override
    public List<Integer> getStatistic(User user, Disease disease, Poll poll, Date date) {
        return null;
    }

}
