package com.project.appz.service.impl;

import com.project.appz.models.DiagramType;
import com.project.appz.models.Statistic;
import com.project.appz.repository.StatisticRepository;

import java.util.Date;
import java.util.List;

public class StatisticServiceImpl {

    private final StatisticRepository statisticRepository;

    public StatisticServiceImpl(StatisticRepository statisticRepository) {
        this.statisticRepository = statisticRepository;
    }

    public List<Statistic> filterDataByBlockAndDate(String block, Date startDate, Date endDate) {
        return statisticRepository.findByBlockAndDateRange(block, startDate, endDate);
    }

    public String generateDiagram(DiagramType diagramType, List<Statistic> data) {
        switch (diagramType) {
            case TYPE1:
                return generateType1Diagram(data);
            case TYPE2:
                return generateType2Diagram(data);
            default:
                throw new IllegalArgumentException("Invalid diagram type");
        }
    }

    private String generateType1Diagram(List<Statistic> data) {
        // Implement the logic to generate the first type of diagram
        // Placeholder implementation
        return "DiagramType1";
    }

    private String generateType2Diagram(List<Statistic> data) {
        // Implement the logic to generate the second type of diagram
        // Placeholder implementation
        return "DiagramType2";
    }
}
