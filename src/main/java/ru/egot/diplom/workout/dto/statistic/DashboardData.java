package ru.egot.diplom.workout.dto.statistic;

import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Accessors(chain = true)
public class DashboardData {

    private String date;

    private int plan;

    private int actual;

    private int planAvg;

    private int actualAvg;
}
