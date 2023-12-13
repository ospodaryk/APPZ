package com.project.appz;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.appz.controller.PollController;
import com.project.appz.models.dto.PollAssignmentDto;
import com.project.appz.models.dto.PollDto;
import com.project.appz.models.dto.ResponseDto;
import com.project.appz.models.dto.ShortPollDto;
import com.project.appz.models.entities.Poll;
import com.project.appz.service.PollAssignmentService;
import com.project.appz.service.PollManager;
import com.project.appz.service.StatisticService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class PollControllerTest {

    private MockMvc mockMvc;

    @Mock
    private PollManager pollManager;

    @Mock
    private StatisticService statisticService;

    @Mock
    private PollAssignmentService pollAssignmentService;

    @InjectMocks
    private PollController pollController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(pollController).build();
    }

    @Test
    void getAllPollForUserByIdTest() throws Exception {
        List<ShortPollDto> shortPollDtos = List.of(new ShortPollDto()); // Mock your data accordingly
        when(pollAssignmentService.findAllByUser(anyLong())).thenReturn(shortPollDtos);

        mockMvc.perform(get("/poll")
                        .param("userId", "1"))
                .andExpect(status().isOk());
        // Add more expectations to verify the response content if necessary
    }

    @Test
    void submitResponseTest() throws Exception {
        ResponseDto responseDto = new ResponseDto(); // Mock your ResponseDto accordingly

        mockMvc.perform(post("/poll/response")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(responseDto)))
                .andExpect(status().isOk());
        // Verify that the pollManager and statisticService methods are called
    }

    @Test
    void assignPollToUserTest() throws Exception {
        PollAssignmentDto pollAssignmentDto = new PollAssignmentDto(); // Mock your PollAssignmentDto accordingly

        mockMvc.perform(post("/poll/assign")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(pollAssignmentDto)))
                .andExpect(status().isCreated());
        // Verify that the pollManager.assignPoll method is called
    }

    // Helper method to convert an object into JSON string representation
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
