package com.project.appz.service.impl;

import com.project.appz.models.dto.PollAssignmentDto;
import com.project.appz.models.dto.ResponseDto;
import com.project.appz.models.entities.*;
import com.project.appz.repository.*;
import com.project.appz.service.notification.Notification;
import com.project.appz.service.notification.NotificationManager;
import com.project.appz.repository.*;
import com.project.appz.service.PollManager;
import com.project.appz.utils.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PollManagerImpl implements PollManager {
    Logger logger;
    PollRepository pollRepository;
    PollAssignmentRepository pollAssignmentRepository;
    DoctorRepository doctorRepository;
    UserRepository userRepository;
    NotificationManager notificationManager;
    ResponseRepository responseRepository;
    private final PollRepository pollRepository;
    private final ResponseRepository responseRepository;
    private final AssignedPollRepository assignedPollRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final UserRepository userRepository;

    @Autowired

    public PollManagerImpl(PollRepository pollRepository, ResponseRepository responseRepository, AssignedPollRepository assignedPollRepository, QuestionRepository questionRepository, AnswerRepository answerRepository, UserRepository userRepository) {
        this.pollRepository = pollRepository;
        this.responseRepository = responseRepository;
        this.assignedPollRepository = assignedPollRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
        this.userRepository = userRepository;
    }


    @Autowired
    public PollManagerImpl(PollRepository pollRepository, PollAssignmentRepository pollAssignmentRepository,
                           DoctorRepository doctorRepository, UserRepository userRepository,
                           NotificationManager notificationManager, ResponseRepository responseRepository) {
        this.pollRepository = pollRepository;
        this.pollAssignmentRepository = pollAssignmentRepository;
        this.doctorRepository = doctorRepository;
        this.userRepository = userRepository;
        this.notificationManager = notificationManager;
        this.responseRepository = responseRepository;
    }

    @Override
    public void createPoll(Poll poll) {
        // Implementation to create a poll
    }

    @Override
    public void assignPoll(PollAssignmentDto pollAssignmentDto) {
        // Retrieve the Doctor, User, and Poll from the database using the provided IDs
        Doctor doctor = doctorRepository.findById(pollAssignmentDto.doctorId)
                .orElseThrow(() -> new IllegalArgumentException("Doctor not found with ID: " + pollAssignmentDto.doctorId));
        User user = userRepository.findById(pollAssignmentDto.userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + pollAssignmentDto.userId));
        Poll poll = pollRepository.findById(pollAssignmentDto.pollId)
                .orElseThrow(() -> new IllegalArgumentException("Poll not found with ID: " + pollAssignmentDto.pollId));
        // Create a new PollAssignment entity using the retrieved objects and the deadline from the DTO
        PollAssignment pollAssignment = PollAssignment.builder()
                .doctor(doctor)
                .user(user)
                .poll(poll)
                .deadline(pollAssignmentDto.deadline)
                .createdDate(LocalDateTime.now()) // Assuming you want to set the created date to the current date
                .isCompleted(false) // Assuming you want to initialize this as false
                .build();

        // Save the PollAssignment entity to the database
        pollAssignmentRepository.save(pollAssignment);

        Notification notification = notificationManager.createNotification(pollAssignment);
        notificationManager.sendMessage(notification);
        Notification scheduledNotification = notificationManager.createDeadlineNotification(pollAssignment);
        notificationManager.scheduleNotification(scheduledNotification);
        // Optionally, log the assignment
        //logger.log("Assigned poll id " + poll.getId() + " to user id " + user.getId());
    }



    @Override
    public List<Statistic> getPollResults(Poll poll) {
        // Implementation to get poll results
        return new ArrayList<>();
    }

    public boolean isPollAssignedToUser(Poll poll, Long userId) {
        //User user = poll.getUser();
        AssignedPoll assignedPoll = assignedPollRepository.findByPollId(poll.getId());
        if (assignedPoll == null) {
            throw new NullPointerException("assignedPoll not found with ID: " + poll.getId());
        }
        User user = assignedPoll.getUser();
        if (user == null) {
            throw new NullPointerException("user not found with ID: " + userId);
        }
        return user.getId().equals(userId);
    }

    @Override
    public Poll findPollById(Long pollId, Long userId) {
        Poll poll = pollRepository.findById(pollId).orElseThrow(() -> new NullPointerException("Poll not found with ID: " + pollId));
        if (isPollAssignedToUser(poll, userId)) {
            return poll;
        } else throw new NullPointerException("user not found with ID: " + pollId);

    }

    @Override

    public void savePollResults(ResponseDto responsePollDto) {
        User user = userRepository.findById(responsePollDto.getUserId()).orElseThrow(() -> new NullPointerException("Poll not found with ID: "));
        Poll poll = pollRepository.findById(responsePollDto.getPollId()).orElseThrow(() -> new NullPointerException("Poll not found with ID: "));

        Map<Long, Long> questions = responsePollDto.getQuestionAnswer();
        for (Long key : questions.keySet()) {
            Response response = Response.builder()
                    .user(user)
                    .poll(poll)
                    .question(questionRepository.findById(key).orElseThrow(() -> new NullPointerException("Poll not found with ID: ")))
                    .answer(answerRepository.findById(questions.get(key)).orElseThrow(() -> new NullPointerException("Poll not found with ID: ")))
                    .responseDate(LocalDate.now())
                    .build();
            responseRepository.save(response);
        }
    }

}
