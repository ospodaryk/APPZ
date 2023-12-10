package com.project.appz.service.impl;

import com.project.appz.models.dto.ResponseDto;
import com.project.appz.models.dto.StatisticDto;
import com.project.appz.models.entities.*;
import com.project.appz.models.enums.Disease;
import com.project.appz.models.enums.StatisticVariants;
import com.project.appz.repository.*;
import com.project.appz.service.StatisticService;
import com.project.appz.utils.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StatisticServiceImpl implements StatisticService {
    Logger logger;
    private final PollRepository pollRepository;
    private final ResponseRepository responseRepository;
    private final AssignedPollRepository assignedPollRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final UserRepository userRepository;
    private final StatisticRepository statisticRepository;

    @Autowired
    public StatisticServiceImpl(PollRepository pollRepository, ResponseRepository responseRepository, AssignedPollRepository assignedPollRepository, QuestionRepository questionRepository, AnswerRepository answerRepository, UserRepository userRepository, StatisticRepository statisticRepository) {
        this.pollRepository = pollRepository;
        this.responseRepository = responseRepository;
        this.assignedPollRepository = assignedPollRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
        this.userRepository = userRepository;
        this.statisticRepository = statisticRepository;
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
        statistic.setResult(Long.valueOf(result/questions.size()));
        statisticRepository.save(statistic);
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

    @Override
    public List<StatisticDto> filterByBlock(Long patient, String disease) {
        return null;
    }

    @Override
    public List<StatisticDto> filterByDisease(Long patient, String disease) {
        return null;
    }

//    @Override
//    public List<Statistic> filterByBlock(Long patient, String disease) {
//        return null;
//    }
//
//    @Override
//    public List<Statistic> filterByDisease(Long patient, String disease) {
//        List<Statistic> statistics = statisticRepository.findByUserId(patient)
//                .stream()
//                .filter(obj -> obj.getPoll().getDisease().equals(disease))
//                .collect(Collectors.toList());
//        List<StatisticDto> statisticDtos = new ArrayList<>();
//        for (int i = 0; i < statistics.size(); i++) {
//            StatisticDto statisticDto = new StatisticDto();
//            statisticDto.getStatisticMap().replace(StatisticVariants.GOOD.getDisplayName(), statistics.get(i).getResult());
//            statisticDtos.add(statisticDto);
//        }
//        return
//    }
//    @Override
//    public List<Statistic> filterByDisease(Long patient, String disease) {
//        List<Statistic> statistics=    statisticRepository.findByUserId(patient)
//                .stream()
//                .filter(obj -> obj.getPoll().getDisease().equals(disease))
//                .collect(Collectors.toList());
//        List<StatisticDto> statisticDtos=new ArrayList<>();
//        for (int i = 0; i < statistics.size(); i++) {
//            StatisticDto statisticDto=new StatisticDto();
//            statisticDto.getStatisticMap().replace(StatisticVariants.GOOD.getDisplayName(),statistics.get(i).getResult());
//            statisticDtos.add(statisticDto);
//        }
//        return
//    }
}
