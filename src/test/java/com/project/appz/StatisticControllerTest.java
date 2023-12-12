package com.project.appz;

import com.project.appz.controller.StatisticController;
import com.project.appz.models.dto.BigStatisticDto;
import com.project.appz.models.dto.ShortPollDto;
import com.project.appz.models.dto.StatisticDto;
import com.project.appz.models.entities.Poll;
import com.project.appz.models.entities.Statistic;
import com.project.appz.repository.PollRepository;
import com.project.appz.service.PollAssignmentService;
import com.project.appz.service.QuestionService;
import com.project.appz.service.StatisticService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(MockitoExtension.class)
class StatisticControllerTest {

    private MockMvc mockMvc;

    @Mock
    private StatisticService statisticService;

    @Mock
    private PollAssignmentService pollAssignmentService;

    @Mock
    private QuestionService questionService;

    @Mock
    private PollRepository pollRepository;

    @InjectMocks
    private StatisticController statisticController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(statisticController).build();
    }

    @Test
    void filterMedicalRecordForUserbyDiseaseTest() throws Exception {
        // Arrange
        StatisticDto statisticDto = new StatisticDto();
        when(statisticService.filterByBlock(anyLong(), anyLong())).thenReturn(statisticDto);

        // Act & Assert
        mockMvc.perform(get("/statistic/{blockId}", 1L).param("userId", "1"))
                .andExpect(status().isOk());
        // You might want to add more expectations here to verify the response
    }

    @Test
    void gettCompletedPollsTest() throws Exception {
        // Arrange
        List<ShortPollDto> shortPollDtos = List.of(new ShortPollDto());
        when(pollAssignmentService.findAllRESULTSByUser(anyLong())).thenReturn(shortPollDtos);

        // Act & Assert
        mockMvc.perform(get("/statistic/allpolls").param("userId", "1"))
                .andExpect(status().isOk());
        // You might want to add more expectations here to verify the response
    }





    // Additional helper methods for creating mocks can be added as needed
}
