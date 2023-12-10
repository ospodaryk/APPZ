package com.project.appz.service;

import com.project.appz.models.entities.QuestionBlock;

import java.util.Set;

public interface QuestionService {
    Set<QuestionBlock> getQuestionBlockByPoll(long userId, Long pollId);
}
