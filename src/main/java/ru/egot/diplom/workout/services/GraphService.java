package ru.egot.diplom.workout.services;

import org.springframework.stereotype.Service;
import ru.egot.diplom.workout.dto.statistic.Dashboard;

import java.util.List;

@Service
public interface GraphService {

    List<Dashboard> getDashboardStatistic();

}
