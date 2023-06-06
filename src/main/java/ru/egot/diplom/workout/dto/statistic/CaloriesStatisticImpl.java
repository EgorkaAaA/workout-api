package ru.egot.diplom.workout.dto.statistic;

import lombok.Getter;
import lombok.Setter;
import ru.egot.diplom.workout.entity.CaloriesEntity;

import java.time.LocalDate;

@Getter
@Setter
public class CaloriesStatisticImpl implements Statistic {

    private CaloriesEntity caloriesEntity;

    private Double planAvg;

    private Double actualAvg;


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
    public Double getActual() {
        return caloriesEntity.getCaloriesActual();
    }

    @Override
    public Double getPlan() {
        return caloriesEntity.getCaloriesPlan();
    }
}
