package ru.egot.diplom.workout.dto.statistic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class DashboardData {

    private String date;

    private int plan;

    private int actual;

    private int planAvg;

    private int actualAvg;
}
