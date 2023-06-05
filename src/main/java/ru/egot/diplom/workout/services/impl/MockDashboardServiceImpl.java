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
import java.util.Random;

@Service
@Primary
public class MockDashboardServiceImpl implements DashboardService {

    @Override
    public List<Dashboard> getDashboardStatistic() {
        return List.of(
                new Dashboard(
                        Type.SLEEP.getName(),
                        createDashboardData()
                ),
                new Dashboard(
                        Type.CALORIES.getName(),
                        createDashboardData()
                )
        );
    }

    private List<DashboardData> createDashboardData() {
        ArrayList<DashboardData> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            int actual = random.nextInt(0, 12);
            list.add(
                    new DashboardData(
                            LocalDate.now().minusDays(i).toString(),
                            8,
                            actual,
                            8,
                            0
                    )
            );
        }
        double avg = list.stream().mapToDouble(DashboardData::getActual).average().orElse(0);
        return list.stream().map(r -> r.setActualAvg(Integer.parseInt(String.valueOf(avg)))).toList();
    }

}
