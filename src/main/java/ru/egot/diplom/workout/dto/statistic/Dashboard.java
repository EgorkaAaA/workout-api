package ru.egot.diplom.workout.dto.statistic;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Dashboard {

    private final String type;

    private final List<DashboardData> data;

}
