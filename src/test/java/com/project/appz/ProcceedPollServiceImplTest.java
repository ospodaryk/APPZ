//package com.project.appz;
//
//import com.project.appz.models.entities.Poll;
//import com.project.appz.models.entities.Statistic;
//import com.project.appz.repository.PollRepository;
//import com.project.appz.repository.ResponsePollRepository;
//import com.project.appz.repository.UserRepository;
//import com.project.appz.service.impl.PollManagerImpl;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@ExtendWith(MockitoExtension.class)
//public class ProcceedPollServiceImplTest {
//    @InjectMocks
//    private PollManagerImpl service;
//
//    @Mock
//    private PollRepository pollRepository;
//
//    @Mock
//    private ResponsePollRepository responseRepository;
//
//    @Mock
//    private UserRepository userRepository;
//
//    @Test
//    void testIsPollAssignedToUser_Assigned_ReturnsTrue() {
//        long pollId = 1L;
//        long userId = 1L;
//        Mockito.when(pollRepository.findById(pollId)).thenReturn(Optional.of(ModelUtils.getPoll()));
//
//        boolean result = service.isPollAssignedToUser(pollId, userId);
//        assertTrue(result);
//    }
//
//    @Test
//    void testIsPollAssignedToUser_NotAssigned_ReturnsFalse() {
//        long pollId = 1L;
//        long userId = 2L;
//        Mockito.when(pollRepository.findById(pollId)).thenReturn(Optional.of(ModelUtils.getPoll()));
//
//        boolean result = service.isPollAssignedToUser(pollId, userId);
//        assertFalse(result);
//    }
//
//    @Test
//    void testIsPollAssignedToUser_NonExistentPoll_ThrowsNotFoundException() {
//        long nonExistentPollId = 123L;
//        long userId = 1L;
//        assertThrows(NullPointerException.class, () -> service.isPollAssignedToUser(nonExistentPollId, userId));
//    }
//
//    @Test
//    void testIsPollAssignedToUser_NonExistentUser_ThrowsNotFoundException() {
//        long pollId = 1L;
//        long nonExistentUserId = 999L;
//        Poll poll = ModelUtils.getPoll();
//        //poll.setUser(null);
//        Mockito.when(pollRepository.findById(pollId)).thenReturn(Optional.of(poll));
//        //assertThrows(NullPointerException.class, () -> service.isPollAssignedToUser(pollId, nonExistentUserId));
//    }
//
//    @Test
//    void testGetPollById_Found_ReturnsPoll() {
//        long pollId = 123L;
//        Poll mockPoll = ModelUtils.getPoll();
//        Mockito.when(pollRepository.findById(pollId)).thenReturn(Optional.of(mockPoll));
//
//        Poll result = pollRepository.findById(pollId).get();
//        assertEquals(mockPoll, result);
//    }
//
//    @Test
//    void testGetPollById_NotFound_ReturnsNull() {
//        long pollId = 123L;
//        Poll result = pollRepository.findById(pollId).orElse(new Poll());
//        assertNotNull(result);
//    }
//
//    @Test
//    void testSavePollResults_ValidData_NoExceptions() {
//        long pollId = 1L;
//        Statistic statistic = ModelUtils.getResponsePoll();
//        Mockito.when(pollRepository.findById(pollId)).thenReturn(Optional.of(ModelUtils.getPoll()));
//
//        service.savePollResults(pollId, statistic);
//    }
//
//    @Test
//    void testSavePollResults_NonExistentPoll_ThrowsNotFoundException() {
//        long nonExistentPollId = 123L;
//        Statistic statistic = new Statistic();
//        assertThrows(NullPointerException.class, () -> service.savePollResults(nonExistentPollId, statistic));
//    }
//
//    @Test
//    void testSavePollResults_NoData_ThrowsIllegalArgumentException() {
//        long pollId = 1L;
//        Statistic statistic = null;
//        assertThrows(NullPointerException.class, () -> service.savePollResults(pollId, statistic));
//    }
//
//}
