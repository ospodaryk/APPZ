package com.project.appz;

import com.project.appz.models.DiagramType;
import com.project.appz.models.Statistic;
import com.project.appz.repository.StatisticRepository;
import com.project.appz.service.impl.StatisticServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StatisticServiceImplTest {

    @InjectMocks
    private StatisticServiceImpl service;

    @Mock
    private StatisticRepository statisticRepository;

    @Test
    void testFilterDataByBlockAndDate_ValidBlockAndDate_ReturnsData() {
        String block = "BlockA";
        Date startDate = new Date(2023, 1, 1);
        Date endDate = new Date(2023, 1, 31);
        when(statisticRepository.findByBlockAndDateRange(block, startDate, endDate))
                .thenReturn(List.of(new Statistic()));

        List<Statistic> result = service.filterDataByBlockAndDate(block, startDate, endDate);
        assertFalse(result.isEmpty());
    }

    @Test
    void testGenerateDiagram_Type1WithData_ReturnsDiagram() {
        List<Statistic> data = List.of(new Statistic());
        DiagramType diagramType = DiagramType.TYPE1;

        assertNotNull(service.generateDiagram(diagramType, data));
    }

    @Test
    void testGenerateDiagram_Type2WithData_ReturnsDiagram() {
        List<Statistic> data = List.of(new Statistic());
        DiagramType diagramType = DiagramType.TYPE2;

        assertNotNull(service.generateDiagram(diagramType, data));
    }

    @Test
    void testGenerateDiagram_InvalidType_ThrowsIllegalArgumentException() {
        List<Statistic> data = List.of(new Statistic());
        DiagramType invalidDiagramType = DiagramType.UNKNOWN;

        assertThrows(IllegalArgumentException.class, () -> service.generateDiagram(invalidDiagramType, data));
    }
}
