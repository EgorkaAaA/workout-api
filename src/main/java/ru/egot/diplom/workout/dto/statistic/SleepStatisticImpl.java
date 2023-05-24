package ru.egot.diplom.workout.dto.statistic;

import ru.egot.diplom.workout.entity.SleepEntity;

import java.time.LocalDate;

public class SleepStatisticImpl implements Statistic {

    private final SleepEntity sleepEntity;

    public SleepStatisticImpl(SleepEntity sleepEntity) {
        this.sleepEntity = sleepEntity;
    }

    @Override
    public Long getUserId() {
        return sleepEntity.getUserId();
    }

    @Override
    public LocalDate getDate() {
        return sleepEntity.getDate();
    }

    @Override
    public Integer getActual() {
        return sleepEntity.getHourActual();
    }

    @Override
    public Integer getPlan() {
        return sleepEntity.getHourPlan();
    }
}
