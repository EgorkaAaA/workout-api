package ru.egot.diplom.workout.dto.statistic;

import java.time.LocalDate;

public interface Statistic {

    Long getUserId();

    LocalDate getDate();

    Integer getActual();

    Integer getPlan();

}
