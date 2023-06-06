package ru.egot.diplom.workout.dto.statistic;

import lombok.Getter;
import lombok.Setter;
import ru.egot.diplom.workout.entity.SleepEntity;

import java.time.LocalDate;

@Setter
@Getter
public class SleepStatisticImpl implements Statistic {

    private final SleepEntity sleepEntity;

    private Double planAvg;

    private Double actualAvg;

    public SleepStatisticImpl(SleepEntity sleepEntity) {
        this.sleepEntity = sleepEntity;
    }

    @Override
    public Long getUserId() {
        return sleepEntity.getUserId().getId();
    }

    @Override
    public LocalDate getDate() {
        return sleepEntity.getDate();
    }

    @Override
    public Double getActual() {
        return sleepEntity.getHourActual();
    }

    @Override
    public Double getPlan() {
        return sleepEntity.getHourPlan();
    }
}
