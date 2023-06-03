package ru.egot.diplom.workout.repositories;

import jakarta.validation.constraints.NotNull;
import ru.egot.diplom.workout.entity.CaloriesEntity;
import ru.egot.diplom.workout.entity.User;

import java.time.LocalDate;
import java.util.List;

public interface CaloriesStatisticRepo extends BaseRepo<CaloriesEntity> {

    List<CaloriesEntity> findAllByDateBetweenAndUserId(@NotNull LocalDate start, @NotNull LocalDate end, @NotNull User userId);

}
