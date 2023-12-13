package com.project.appz;

import com.project.appz.models.dto.PollAssignmentDto;
import com.project.appz.models.dto.ResponseDto;
import com.project.appz.models.dto.ResponseQuestionPollDto;
import com.project.appz.models.entities.Poll;
import com.project.appz.models.entities.PollAssignment;
import com.project.appz.repository.*;
import com.project.appz.service.impl.PollManagerImpl;
import com.project.appz.service.notification.NotificationManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PollServiceTest {

    @Mock
    private PollAssignmentRepository pollAssignmentRepository;

    @Mock
    private DoctorRepository doctorRepository;

    @Mock
    private NotificationManager notificationManager;

    @Mock
    private PollRepository pollRepository;

    @Mock
    private ResponseRepository responseRepository;

    @Mock
    private QuestionRepository questionRepository;

    @Mock
    private AnswerRepository answerRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private PollManagerImpl pollManager;

    private PollAssignmentDto pollAssignmentDto;
    private ResponseDto responseDto;

    @BeforeEach
    public void setUp() {
        // Initialize your test data here
        pollAssignmentDto = new PollAssignmentDto();
        // Populate pollAssignmentDto with test data

        responseDto = new ResponseDto();
        responseDto.setAnswers(Arrays.asList(ResponseQuestionPollDto.builder().answerId(1L).build()));
        // Populate responseDto with test data
    }

    @Test
    public void testAssignPoll() {
        // Mocking dependencies
        when(doctorRepository.findById(anyLong())).thenReturn(Optional.of(ModelUtils.getDoctor()));
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(ModelUtils.getUser()));
        when(pollRepository.findById(anyLong())).thenReturn(Optional.of(ModelUtils.getPoll()));

        // Perform the action
        pollManager.assignPoll(pollAssignmentDto);

        // Verify interactions and state
        verify(pollAssignmentRepository, times(1)).save(any(PollAssignment.class));
        verify(notificationManager, times(1)).createNotification(any(PollAssignment.class));
        verify(notificationManager, times(1)).createDeadlineNotification(any(PollAssignment.class));
    }

    @Test
    public void testFindPollById() {
        // Mocking dependencies
        when(pollRepository.findById(anyLong())).thenReturn(Optional.of(new Poll()));

        // Perform the action
        Poll result = pollManager.findPollById(1L, 1L);
        assertNotNull(result);
    }

    @Test
    public void testSavePollResults() {
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(ModelUtils.getUser()));
        when(pollRepository.findById(anyLong())).thenReturn(Optional.of(ModelUtils.getPoll()));
        when(questionRepository.findById(null)).thenReturn(Optional.of(ModelUtils.getQuestion()));

        when(answerRepository.findById(anyLong())).thenReturn(Optional.of(ModelUtils.getAnswer()));

        pollManager.savePollResults(responseDto);
        verify(userRepository, times(1)).findById(anyLong());

        verify(pollRepository, times(1)).findById(anyLong());
        verify(questionRepository, times(1)).findById(null);

        verify(answerRepository, times(1)).findById(anyLong());

    }

    @Test
    public void testAssignPollWithInvalidDoctorId() {
        // Mocking behavior for an invalid doctor ID
        when(doctorRepository.findById(anyLong())).thenReturn(Optional.empty());

        // Expect an exception when the doctor ID is invalid
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            pollManager.assignPoll(pollAssignmentDto);
        });

        // Verify the exception message
        assertEquals("Doctor not found with ID: " + pollAssignmentDto.doctorId, thrown.getMessage());
    }

    @Test
    public void testAssignPollWithInvalidUserId() {
        // Mock valid doctor and invalid user
        when(doctorRepository.findById(anyLong())).thenReturn(Optional.of(ModelUtils.getDoctor()));
        when(userRepository.findById(anyLong())).thenReturn(Optional.empty());

        // Expect an exception when the user ID is invalid
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            pollManager.assignPoll(pollAssignmentDto);
        });

        assertEquals("User not found with ID: " + pollAssignmentDto.userId, thrown.getMessage());
    }

    @Test
    public void testFindPollByIdNotFound() {
        // Mocking behavior for a non-existent poll
        when(pollRepository.findById(anyLong())).thenReturn(Optional.empty());

        // Expect a NullPointerException when the poll ID is not found
        NullPointerException thrown = assertThrows(NullPointerException.class, () -> {
            pollManager.findPollById(1L, 1L);
        });

        assertEquals("Poll not found with ID: " + 1L, thrown.getMessage());
    }

    @Test
    public void testSavePollResultsWithInvalidUserId() {
        NullPointerException thrown = assertThrows(NullPointerException.class, () -> {
            pollManager.savePollResults(responseDto);
        });
    }


}
