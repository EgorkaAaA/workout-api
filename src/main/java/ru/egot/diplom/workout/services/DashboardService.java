package ru.egot.diplom.workout.services;

import org.springframework.stereotype.Service;
import ru.egot.diplom.workout.dto.statistic.Dashboard;
import ru.egot.diplom.workout.dto.statistic.DashboardDataDto;

import java.time.LocalDate;
import java.util.List;

@Service
public interface DashboardService {

    List<Dashboard> getDashboardStatistic(String username, LocalDate localDateStart, LocalDate localDateFinish);

    Dashboard setDashboardStatistic(DashboardDataDto dataDto);

}
