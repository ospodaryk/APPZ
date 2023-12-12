package com.project.appz;

import com.project.appz.models.dto.ShortPollDto;
import com.project.appz.models.entities.Poll;
import com.project.appz.models.entities.Statistic;
import com.project.appz.service.impl.PollAssignmentImplAssignment;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;


import com.project.appz.models.dto.ResponseDto;
import com.project.appz.models.entities.PollAssignment;
import com.project.appz.models.entities.Response;
import com.project.appz.repository.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PollAssignmentTest {

    @Mock
    private PollRepository pollRepository;
    @Mock
    private PollAssignmentRepository pollAssignmentRepository;
    @Mock
    private ResponseRepository responseRepository;
    @Mock
    private QuestionRepository questionRepository;
    @Mock
    private AnswerRepository answerRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private StatisticRepository statisticRepository;

    @InjectMocks
    private PollAssignmentImplAssignment pollAssignmentImplAssignment;

    @Test
    public void testSave() {
        Long userId = 1L;
        Long pollId = 1L;
        ResponseDto responseDto = new ResponseDto();
        responseDto.setUserId(userId);
        responseDto.setPollId(pollId);

        PollAssignment mockPollAssignment = new PollAssignment();
        when(pollAssignmentRepository.findByPollIdAndUserId(userId, pollId)).thenReturn(mockPollAssignment);

        pollAssignmentImplAssignment.save(responseDto);

        assertTrue(mockPollAssignment.getIsCompleted());
        verify(pollAssignmentRepository, times(1)).save(mockPollAssignment);
    }

    @Test
    public void testFindAllByUser() {
        Long userId = 1L;
        List<PollAssignment> mockPollAssignments = List.of(/* Mock PollAssignment instances */);
        when(pollAssignmentRepository.findByUserId(userId)).thenReturn(mockPollAssignments);

        List<ShortPollDto> result = pollAssignmentImplAssignment.findAllByUser(userId);

        assertEquals(mockPollAssignments.size(), result.size());
        // Additional assertions to verify the contents of result
    }

    @Test
    public void testFindAllRESULTSByUser() {
        Long userId = 1L;
        List<Statistic> mockStatistics = List.of(/* Mock Statistic instances */);
        when(statisticRepository.findByUserId(userId)).thenReturn(mockStatistics);

        for (Statistic statistic : mockStatistics) {
            when(responseRepository.findByUserIdAndPollId(userId, statistic.getPoll().getId())).thenReturn(List.of(new Response()));
        }

        List<ShortPollDto> results = pollAssignmentImplAssignment.findAllRESULTSByUser(userId);

        assertEquals(mockStatistics.size(), results.size());
    }

    @Test
    public void testFindAllByUserWithPollAssignments() {
        Long userId = 1L;
        List<PollAssignment> mockPollAssignments = List.of(
                createMockPollAssignment(1L, "Poll Title 1"),
                createMockPollAssignment(2L, "Poll Title 2")
        );
        when(pollAssignmentRepository.findByUserId(userId)).thenReturn(mockPollAssignments);

        List<ShortPollDto> result = pollAssignmentImplAssignment.findAllByUser(userId);

        assertEquals(2, result.size());
        assertEquals(1L, result.get(0).getId());
        assertEquals("Poll Title 1", result.get(0).getPollTitle());
        assertEquals(2L, result.get(1).getId());
        assertEquals("Poll Title 2", result.get(1).getPollTitle());
    }

    @Test
    public void testFindAllByUserWithNoPollAssignments() {
        Long userId = 1L;
        when(pollAssignmentRepository.findByUserId(userId)).thenReturn(new ArrayList<>());

        List<ShortPollDto> result = pollAssignmentImplAssignment.findAllByUser(userId);

        assertTrue(result.isEmpty());
    }

    private PollAssignment createMockPollAssignment(Long id, String pollTitle) {
        PollAssignment mockAssignment = mock(PollAssignment.class);
        Poll mockPoll = mock(Poll.class);
        when(mockAssignment.getId()).thenReturn(id);
        when(mockAssignment.getPoll()).thenReturn(mockPoll);
        when(mockPoll.getPollTitle()).thenReturn(pollTitle);
        return mockAssignment;
    }

    @Test
    public void testSaveWithNonExistentPollAssignment() {
        Long userId = 1L;
        Long pollId = 1L;
        ResponseDto responseDto = new ResponseDto();
        responseDto.setUserId(userId);
        responseDto.setPollId(pollId);

        when(pollAssignmentRepository.findByPollIdAndUserId(userId, pollId)).thenReturn(null);

        assertThrows(NullPointerException.class, () -> pollAssignmentImplAssignment.save(responseDto));
    }

    @Test
    public void testFindAllByUserWithNoAssignments() {
        Long userId = 1L;
        when(pollAssignmentRepository.findByUserId(userId)).thenReturn(new ArrayList<>());

        List<ShortPollDto> result = pollAssignmentImplAssignment.findAllByUser(userId);

        assertTrue(result.isEmpty());
    }

    @Test
    public void testFindAllRESULTSByUserWithNoStatistics2() {
        Long userId = 1L;
        when(statisticRepository.findByUserId(userId)).thenReturn(new ArrayList<>());

        List<ShortPollDto> results = pollAssignmentImplAssignment.findAllRESULTSByUser(userId);

        assertTrue(results.isEmpty());
    }

    @Test
    public void testFindAllRESULTSByUserWithNoResponses2() {
        Long userId = 1L;
        List<Statistic> mockStatistics = List.of(/* Mock Statistic instances */);
        when(statisticRepository.findByUserId(userId)).thenReturn(mockStatistics);

        for (Statistic statistic : mockStatistics) {
            when(responseRepository.findByUserIdAndPollId(userId, statistic.getPoll().getId())).thenReturn(new ArrayList<>());
        }

        List<ShortPollDto> results = pollAssignmentImplAssignment.findAllRESULTSByUser(userId);

        assertTrue(results.isEmpty());
    }

    @Test
    public void testFindAllRESULTSByUserWithResponses() {
        Long userId = 1L;
        List<Statistic> mockStatistics = List.of(
                createMockStatistic(1L, "Poll Title 1", userId),
                createMockStatistic(2L, "Poll Title 2", userId)
        );
        when(statisticRepository.findByUserId(userId)).thenReturn(mockStatistics);

        // Assume each statistic has a corresponding non-empty response list
        mockStatistics.forEach(statistic ->
                when(responseRepository.findByUserIdAndPollId(userId, statistic.getPoll().getId()))
                        .thenReturn(List.of(createMockResponse()))
        );

        List<ShortPollDto> result = pollAssignmentImplAssignment.findAllRESULTSByUser(userId);

        assertEquals(mockStatistics.size(), result.size());
        // Additional assertions to verify the contents of result
    }

    @Test
    public void testFindAllRESULTSByUserWithNoStatistics() {
        Long userId = 1L;
        when(statisticRepository.findByUserId(userId)).thenReturn(new ArrayList<>());

        List<ShortPollDto> result = pollAssignmentImplAssignment.findAllRESULTSByUser(userId);

        assertTrue(result.isEmpty());
    }


    // Helper methods to create mock Statistic and Response objects
    private Statistic createMockStatistic(Long id, String pollTitle, Long userId) {
        Statistic statistic = mock(Statistic.class);
        Poll poll = mock(Poll.class);
        when(statistic.getId()).thenReturn(id);
        when(statistic.getPoll()).thenReturn(poll);
        when(poll.getPollTitle()).thenReturn(pollTitle);
        when(poll.getId()).thenReturn(userId);
        return statistic;
    }

    private Response createMockResponse() {
        Response response = mock(Response.class);
        // Setup mock response as per your requirements
        return response;
    }


}
