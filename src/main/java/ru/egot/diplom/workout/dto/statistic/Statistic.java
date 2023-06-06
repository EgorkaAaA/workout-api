package ru.egot.diplom.workout.dto.statistic;

import java.time.LocalDate;

public interface Statistic {

    Long getUserId();

    LocalDate getDate();

    Double getActual();

    Double getPlan();

    Double getPlanAvg();

    Double getActualAvg();

    void setPlanAvg(Double avg);

    void setActualAvg(Double avg);

}
