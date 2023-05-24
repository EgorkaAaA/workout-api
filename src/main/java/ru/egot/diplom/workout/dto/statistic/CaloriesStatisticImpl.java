package ru.egot.diplom.workout.dto.statistic;

import ru.egot.diplom.workout.entity.CaloriesEntity;

import java.time.LocalDate;

public class CaloriesStatisticImpl implements Statistic {

    private final CaloriesEntity caloriesEntity;

    public CaloriesStatisticImpl(CaloriesEntity caloriesEntity) {
        this.caloriesEntity = caloriesEntity;
    }

    @Override
    public Long getUserId() {
        return caloriesEntity.getUser().getId();
    }

    @Override
    public LocalDate getDate() {
        return caloriesEntity.getDate();
    }

    @Override
    public Integer getActual() {
        return (int) caloriesEntity.getCaloriesActual();
    }

    @Override
    public Integer getPlan() {
        return (int) caloriesEntity.getCaloriesPlan();
    }
}
