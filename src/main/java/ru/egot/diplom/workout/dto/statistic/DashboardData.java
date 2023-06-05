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

    private double plan;

    private double actual;

    private double planAvg;

    private double actualAvg;
}
