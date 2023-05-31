package ru.egot.diplom.workout.services.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.egot.diplom.workout.dto.statistic.Dashboard;
import ru.egot.diplom.workout.dto.statistic.DashboardData;
import ru.egot.diplom.workout.entity.Type;
import ru.egot.diplom.workout.services.DashboardService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class MockDashboardServiceImpl implements DashboardService {

    @Override
    public List<Dashboard> getDashboardStatistic() {
        return List.of(
                new Dashboard(
                        Type.SLEEP.getName(),
                        createDashboardData()
                )
        );
    }

    private List<DashboardData> createDashboardData() {
        ArrayList<DashboardData> list = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            list.add(
                    new DashboardData(
                            LocalDate.now().minusDays(i).toString(),
                            20 * i,
                            20 * i,
                            20 * i,
                            20 * i
                    )
            );
        }
        return list;
    }

}
