package ru.egot.diplom.workout.repositories;

import jakarta.validation.constraints.NotNull;
import ru.egot.diplom.workout.entity.CaloriesEntity;

import java.time.LocalDate;
import java.util.List;

public interface CaloriesStatisticRepo extends BaseRepo<CaloriesEntity> {

    List<CaloriesEntity> findAllByDateBetweenAndUserId(@NotNull LocalDate date, @NotNull LocalDate date2, Long user_id);

}
