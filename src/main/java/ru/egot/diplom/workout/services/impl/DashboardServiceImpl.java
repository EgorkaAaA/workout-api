package ru.egot.diplom.workout.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.egot.diplom.workout.dto.statistic.*;
import ru.egot.diplom.workout.entity.CaloriesEntity;
import ru.egot.diplom.workout.entity.SleepEntity;
import ru.egot.diplom.workout.entity.Type;
import ru.egot.diplom.workout.repositories.CaloriesStatisticRepo;
import ru.egot.diplom.workout.repositories.SleepStatisticRepo;
import ru.egot.diplom.workout.services.DashboardService;
import ru.egot.diplom.workout.services.UserService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {

    private final SleepStatisticRepo sleepStatisticRepo;

    private final CaloriesStatisticRepo caloriesStatisticRepo;

    private final UserService userService;

    private final Map<Type, TriFunction<String, LocalDate, LocalDate, List<Statistic>>> map = Map.of(
            Type.SLEEP, this::getSleepStatistic,
            Type.CALORIES, this::getCaloriesStatistic
    );

    @Override
    public List<Dashboard> getDashboardStatistic(String username, LocalDate localDateStart, LocalDate localDateFinish) {
        final List<Dashboard> dashboards = new ArrayList<>();
        for (Type type : Type.values()) {
            if (Type.TRAINING.equals(type)) {
                continue;
            }
            dashboards.add(
                    new Dashboard(
                            type.getName(),
                            map.get(type).apply(username, localDateStart, localDateFinish)
                                    .stream()
                                    .map(
                                            s -> new DashboardData().toBuilder()
                                                    .date(s.getDate().toString())
                                                    .actual(s.getActual())
                                                    .plan(s.getPlan())
                                                    .actualAvg(s.getActualAvg())
                                                    .planAvg(s.getPlanAvg())
                                                    .build()
                                    )
                                    .collect(Collectors.toList())
                    )
            );

        }
        return dashboards;
    }

    @Override
    public Dashboard setDashboardStatistic(DashboardDataDto dataDto) {
        if (Type.SLEEP.equals(dataDto.getType())) {
            SleepEntity save = sleepStatisticRepo.save(
                    new SleepEntity(
                            userService.getUserByName(dataDto.getUsername()),
                            LocalDate.parse(dataDto.getDate()),
                            dataDto.getActual(),
                            dataDto.getPlan()
                    )
            );
            return new Dashboard(
                    Type.SLEEP.getName(),
                    List.of(
                            new DashboardData(
                                    dataDto.getDate(),
                                    save.getHourPlan(),
                                    save.getHourActual(),
                                    save.getHourPlan(),
                                    save.getHourActual()
                            )
                    )
            );
        }
        if (Type.CALORIES.equals(dataDto.getType())) {
            CaloriesEntity save = caloriesStatisticRepo.save(
                    new CaloriesEntity(
                            userService.getUserByName(dataDto.getUsername()),
                            LocalDate.parse(dataDto.getDate()),
                            dataDto.getActual(),
                            dataDto.getPlan()
                    )
            );
            return new Dashboard(
                    Type.SLEEP.getName(),
                    List.of(
                            new DashboardData(
                                    dataDto.getDate(),
                                    save.getCaloriesPlan(),
                                    save.getCaloriesActual(),
                                    save.getCaloriesPlan(),
                                    save.getCaloriesActual()
                            )
                    )
            );
        }
        return null;
    }


    private List<Statistic> getSleepStatistic(String username, LocalDate localDateTime, LocalDate localDateTime1) {
        List<SleepEntity> sleepEntities = sleepStatisticRepo.findAllByDateBetweenAndUserId(localDateTime, localDateTime1, userService.getUserByName(username));
        double actualAvg = getAvg(sleepEntities.stream().mapToDouble(SleepEntity::getHourActual));
        double planAvg = getAvg(sleepEntities.stream().mapToDouble(SleepEntity::getHourPlan));
        return sleepEntities.stream()
                .map(SleepStatisticImpl::new)
                .peek(sleepStatistic -> sleepStatistic.setActualAvg(actualAvg))
                .peek(sleepStatistic -> sleepStatistic.setPlanAvg(planAvg))
                .collect(Collectors.toList());
    }

    private List<Statistic> getCaloriesStatistic(String username, LocalDate localDateTime, LocalDate localDateTime1) {
        List<CaloriesEntity> caloriesEntities = caloriesStatisticRepo.findAllByDateBetweenAndUserId(localDateTime, localDateTime1, userService.getUserByName(username).getId());
        double actualAvg = getAvg(caloriesEntities.stream().mapToDouble(CaloriesEntity::getCaloriesActual));
        double planAvg = getAvg(caloriesEntities.stream().mapToDouble(CaloriesEntity::getCaloriesPlan));
        return caloriesEntities.stream()
                .map(CaloriesStatisticImpl::new)
                .peek(caloriesStatistic -> caloriesStatistic.setActualAvg(actualAvg))
                .peek(caloriesStatistic -> caloriesStatistic.setPlanAvg(planAvg))
                .collect(Collectors.toList());
    }

    private double getAvg(DoubleStream stream) {
        return stream.average().orElse(0);
    }

    @FunctionalInterface
    private interface TriFunction<T, U, V, R> {
        R apply(T t, U u, V v);
    }


}
