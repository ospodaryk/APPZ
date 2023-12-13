package com.project.appz.service.impl;

import com.project.appz.models.dto.PollAssignmentDto;
import com.project.appz.models.dto.ResponseDto;
import com.project.appz.models.dto.ResponseQuestionPollDto;
import com.project.appz.models.entities.*;
import com.project.appz.repository.*;
import com.project.appz.service.PollManager;
import com.project.appz.service.notification.Notification;
import com.project.appz.service.notification.NotificationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PollManagerImpl implements PollManager {
    private final PollAssignmentRepository pollAssignmentRepository;
    private final DoctorRepository doctorRepository;
    private final NotificationManager notificationManager;
    private final PollRepository pollRepository;
    private final ResponseRepository responseRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final UserRepository userRepository;

    @Autowired
    public PollManagerImpl(PollRepository pollRepository, PollAssignmentRepository pollAssignmentRepository,
                           DoctorRepository doctorRepository, UserRepository userRepository,
                           NotificationManager notificationManager, ResponseRepository responseRepository,
                           QuestionRepository questionRepository, AnswerRepository answerRepository) {
        this.pollAssignmentRepository = pollAssignmentRepository;
        this.doctorRepository = doctorRepository;
        this.notificationManager = notificationManager;
        this.pollRepository = pollRepository;
        this.responseRepository = responseRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
        this.userRepository = userRepository;

    }

    @Override
    public void assignPoll(PollAssignmentDto pollAssignmentDto) {
        Doctor doctor = doctorRepository.findById(pollAssignmentDto.doctorId)
                .orElseThrow(() -> new IllegalArgumentException("Doctor not found with ID: " + pollAssignmentDto.doctorId));
        User user = userRepository.findById(pollAssignmentDto.userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + pollAssignmentDto.userId));
        Poll poll = pollRepository.findById(pollAssignmentDto.pollId)
                .orElseThrow(() -> new IllegalArgumentException("Poll not found with ID: " + pollAssignmentDto.pollId));
        PollAssignment pollAssignment = PollAssignment.builder()
                .doctor(doctor)
                .user(user)
                .poll(poll)
                .deadline(pollAssignmentDto.deadline)
                .createdDate(LocalDateTime.now()) // Assuming you want to set the created date to the current date
                .isCompleted(false) // Assuming you want to initialize this as false
                .build();

        pollAssignmentRepository.save(pollAssignment);

        Notification notification = notificationManager.createNotification(pollAssignment);
        notificationManager.sendMessage(notification);
        Notification scheduledNotification = notificationManager.createDeadlineNotification(pollAssignment);
        notificationManager.scheduleNotification(scheduledNotification);
    }


    @Override
    public Poll findPollById(Long pollId, Long userId) {
        return pollRepository.findById(pollId).orElseThrow(() -> new NullPointerException("Poll not found with ID: " + pollId));
    }

    @Override

    public void savePollResults(ResponseDto responsePollDto) {

        User user = userRepository.findById(responsePollDto.getUserId()).orElseThrow(() -> new NullPointerException("Poll not found with ID: "));
        Poll poll = pollRepository.findById(responsePollDto.getPollId()).orElseThrow(() -> new NullPointerException("Poll not found with ID: "));
        List<ResponseQuestionPollDto> answerDtoList = responsePollDto.getAnswers();

        Map<Long, Long> questions = new HashMap<>();
        for (int i = 0; i < answerDtoList.size(); i++) {
            ResponseQuestionPollDto responseQuestionPollDto = answerDtoList.get(i);
            questions.put(responseQuestionPollDto.getQuestionId(), responseQuestionPollDto.getAnswerId());
        }
        for (Long key : questions.keySet()) {
            Response response = Response.builder()
                    .user(user)
                    .poll(poll)
                    .question(questionRepository.findById(key).orElseThrow(() -> new NullPointerException("Question not found with ID: ")))
                    .answer(answerRepository.findById(questions.get(key)).orElseThrow(() -> new NullPointerException("Answer not found with ID: ")))
                    .responseDate(LocalDate.now())
                    .build();
            responseRepository.save(response);
        }
    }

}
