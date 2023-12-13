package com.project.appz;

import com.project.appz.models.dto.ResponseDto;
import com.project.appz.models.dto.ResponseQuestionPollDto;
import com.project.appz.models.dto.StatisticDto;
import com.project.appz.models.entities.*;
import com.project.appz.repository.*;
import com.project.appz.service.PollAssignmentService;
import com.project.appz.service.impl.StatisticServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.orm.ObjectOptimisticLockingFailureException;

import java.util.*;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StatisticServiceImplTest {

    @Mock
    private PollRepository pollRepository;
    @Mock
    private ResponseRepository responseRepository;

    @Mock
    private UserRepository userRepository;
    @Mock
    private StatisticRepository statisticRepository;
    @Mock
    private QuestionRepository questionRepository;
    @Mock
    private AnswerRepository answerRepository;
    @Mock
    private PollAssignmentService pollAssignmentService;
    @InjectMocks
    private StatisticServiceImpl statisticService;


    @Test
    void testFindById() {
        // Prepare test data
        Long statisticId = 1L;
        Statistic expectedStatistic = new Statistic(); // Populate with test data

        // Setup mocks
        when(statisticRepository.findById(statisticId)).thenReturn(Optional.of(expectedStatistic));

        // Call the method under test
        Statistic resultStatistic = statisticService.findById(statisticId);

        // Assertions
        assertEquals(expectedStatistic, resultStatistic);
    }

    @Test
    void testFindByIdNotFound() {
        // Prepare test data
        Long invalidStatisticId = 99L;

        // Setup mocks
        when(statisticRepository.findById(invalidStatisticId)).thenReturn(Optional.empty());

        // Assertions
        assertThrows(NoSuchElementException.class, () -> statisticService.findById(invalidStatisticId));
    }

    @Test
    void testFindByIdWithValidId() {
        Long statisticId = 1L;
        Statistic mockStatistic = new Statistic();
        mockStatistic.setId(statisticId);
        when(statisticRepository.findById(statisticId)).thenReturn(Optional.of(mockStatistic));

        Statistic result = statisticService.findById(statisticId);

        assertNotNull(result);
        assertEquals(statisticId, result.getId());
    }

    @Test
    void testFindByIdWithInvalidId() {
        Long statisticId = 99L;
        when(statisticRepository.findById(statisticId)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> statisticService.findById(statisticId));
    }

    @Test
    void testFilterByPollWithValidId() {
        Long statisticId = 1L;
        Statistic mockStatistic = new Statistic();
        mockStatistic.setId(statisticId);
        mockStatistic.setResult(80L); // Example result
        when(statisticRepository.findById(statisticId)).thenReturn(Optional.of(mockStatistic));

        StatisticDto result = statisticService.filterByPoll(statisticId);

        assertNotNull(result);
        assertEquals(80.0, result.getPositive());
        assertEquals(20.0, result.getNegative());
    }

    @Test
    void testFilterByPollWithInvalidId() {
        Long statisticId = 99L;
        when(statisticRepository.findById(statisticId)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> statisticService.filterByPoll(statisticId));
    }

    @Test
    void testFilterByBlockAndPollNoMatchingResponses() {
        Long patientId = 1L;
        Long statisticPollId = 1L;
        Long blockId = 1L;
        Statistic mockStatistic = new Statistic();
        Poll mockPoll = new Poll();
        mockStatistic.setPoll(mockPoll);
        mockPoll.setId(statisticPollId);

        when(statisticRepository.findById(statisticPollId)).thenReturn(Optional.of(mockStatistic));
        when(responseRepository.findByUserIdAndPollId(patientId, mockPoll.getId())).thenReturn(Collections.emptyList());

        StatisticDto result = statisticService.filterByBlockAndPoll(patientId, statisticPollId, blockId);

        assertNotNull(result);
        assertEquals(0.0, result.getPositive());
        assertEquals(100.0, result.getNegative());
    }

    @Test
    void testFilterByBlockAndPollMatchingResponses() {
        Long patientId = 1L;
        Long statisticPollId = 1L;
        Long blockId = 1L;
        Statistic mockStatistic = new Statistic();
        Poll mockPoll = new Poll();
        mockStatistic.setPoll(mockPoll);
        mockPoll.setId(statisticPollId);

        when(statisticRepository.findById(statisticPollId)).thenReturn(Optional.of(mockStatistic));
        Response response = ModelUtils.getResponse();
        Question question = ModelUtils.getQuestion();
//        question.setCorrectAnswe;
        response.setQuestion(question);

        when(responseRepository.findByUserIdAndPollId(patientId, mockPoll.getId())).thenReturn(Arrays.asList(response));

        StatisticDto result = statisticService.filterByBlockAndPoll(patientId, statisticPollId, blockId);

        assertNotNull(result);
        assertEquals(0.0, result.getPositive());
        assertEquals(100.0, result.getNegative());
    }

    @Test
    void testFilterByBlockAndPollStatisticNotFound() {
        Long patientId = 1L;
        Long statisticPollId = 99L; // Assuming this ID does not exist
        Long blockId = 1L;

        when(statisticRepository.findById(statisticPollId)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> statisticService.filterByBlockAndPoll(patientId, statisticPollId, blockId));
    }


    @Test
    void testSaveDataPollNotFound() {
        ResponseDto responseDto = new ResponseDto(); // Set up your ResponseDto
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(new User()));
        when(pollRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(NullPointerException.class, () -> statisticService.saveData(responseDto));
    }
    @Test
    void testSaveDataPollNotFound_Success() {
        ResponseDto responseDto = new ResponseDto(); // Set up your ResponseDto
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(ModelUtils.getUser()));
        when(pollRepository.findById(anyLong())).thenReturn(Optional.of(ModelUtils.getPoll()));
        when(questionRepository.findById(null)).thenReturn(Optional.of(ModelUtils.getQuestion()));

        when(answerRepository.findById(anyLong())).thenReturn(Optional.of(ModelUtils.getAnswer()));

        assertThrows(NullPointerException.class, () -> statisticService.saveData(responseDto));
    }
    @Test
    void testSaveDataUserNotFound() {
        ResponseDto responseDto = new ResponseDto(); // Set up your ResponseDto
        when(userRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(NullPointerException.class, () -> statisticService.saveData(responseDto));
    }



    @Test
    void testFilterByBlockWithResponsesNoMatch() {
        Long patientId = 1L;
        Long blockId = 1L;

        when(responseRepository.findByUserId(patientId)).thenReturn(Arrays.asList(ModelUtils.getResponse()));

        StatisticDto result = statisticService.filterByBlock(patientId, blockId);

        assertNotNull(result);
        assertEquals(0.0, result.getPositive());
        assertEquals(100.0, result.getNegative());
    }


    @Test
    void testFilterByBlockWithResponses() {
        Long patientId = 1L;
        Long blockId = 1L;
        when(responseRepository.findByUserId(patientId)).thenReturn(Arrays.asList(ModelUtils.getResponse()));

        StatisticDto result = statisticService.filterByBlock(patientId, blockId);

        assertNotNull(result);
        // Assertions based on your statistic calculation logic
    }

}
