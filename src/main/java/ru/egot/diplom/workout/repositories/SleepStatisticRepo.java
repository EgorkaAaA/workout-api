package ru.egot.diplom.workout.repositories;

import jakarta.validation.constraints.NotNull;
import ru.egot.diplom.workout.entity.SleepEntity;
import ru.egot.diplom.workout.entity.User;

import java.time.LocalDate;
import java.util.List;

public interface SleepStatisticRepo extends BaseRepo<SleepEntity> {

    List<SleepEntity> findAllByDateBetweenAndUserId(@NotNull LocalDate start, @NotNull LocalDate end, @NotNull User userId);

}
