package com.project.appz;
import com.project.appz.models.entities.Poll;
import com.project.appz.models.entities.Question;
import com.project.appz.models.entities.QuestionBlock;
import com.project.appz.repository.PollRepository;
import com.project.appz.service.impl.QuestionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

class QuestionServiceImplTest {
@InjectMocks
    private QuestionServiceImpl questionService;

    @Mock
    private PollRepository pollRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        questionService = new QuestionServiceImpl(pollRepository);
    }

    @Test
    void getQuestionBlockByPoll_Success() {
        // Arrange
        Long pollId = 1L;
        Poll poll = new Poll(); // Assuming a constructor or builder is available
        QuestionBlock questionBlock1 = QuestionBlock.builder().id(1L).blockName("Block 1").build();
        QuestionBlock questionBlock2 = QuestionBlock.builder().id(2L).blockName("Block 2").build();
        poll.setQuestions(Arrays.asList(
                new Question(questionBlock1),
                new Question(questionBlock2)
        ));

        when(pollRepository.findById(pollId)).thenReturn(Optional.of(poll));

        // Act
        Set<QuestionBlock> result = questionService.getQuestionBlockByPoll(123L, pollId);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains(questionBlock1));
        assertTrue(result.contains(questionBlock2));
    }

    @Test
    void getQuestionBlockByPoll_PollNotFound() {
        // Arrange
        Long pollId = 1L;
        when(pollRepository.findById(pollId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            questionService.getQuestionBlockByPoll(123L, pollId);
        });
    }
}
