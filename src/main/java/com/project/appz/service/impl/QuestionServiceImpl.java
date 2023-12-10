package com.project.appz.service.impl;

import com.project.appz.models.entities.Poll;
import com.project.appz.models.entities.Question;
import com.project.appz.models.entities.QuestionBlock;
import com.project.appz.repository.*;
import com.project.appz.service.QuestionService;
import com.project.appz.utils.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService {
    private final PollRepository pollRepository;
    private final ResponseRepository responseRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final UserRepository userRepository;
    private final StatisticRepository statisticRepository;
    private final PollAssignmentRepository pollAssignmentRepository;
    Logger logger;

    @Autowired
    public QuestionServiceImpl(PollRepository pollRepository, ResponseRepository responseRepository, QuestionRepository questionRepository, AnswerRepository answerRepository, UserRepository userRepository, StatisticRepository statisticRepository, PollAssignmentRepository pollAssignmentRepository) {
        this.pollRepository = pollRepository;
        this.responseRepository = responseRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
        this.userRepository = userRepository;
        this.statisticRepository = statisticRepository;
        this.pollAssignmentRepository = pollAssignmentRepository;
    }

    @Override
    public Set<QuestionBlock> getQuestionBlockByPoll(long userId, Long pollId) {
        Poll poll = pollRepository.findById(pollId).orElseThrow();
        List<Question> questions = poll.getQuestions();
        Set<QuestionBlock> questionsBlock = new HashSet<>();
        for (int i = 0; i < questions.size(); i++) {
            questionsBlock.add(QuestionBlock.builder()
                    .id(questions.get(i).getQuestionBlock().getId())
                    .blockName(questions.get(i).getQuestionBlock().getBlockName())
                    .build());
        }
        return questionsBlock;
    }
}
