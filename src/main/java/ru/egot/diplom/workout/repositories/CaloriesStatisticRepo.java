package ru.egot.diplom.workout.repositories;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.egot.diplom.workout.entity.CaloriesEntity;

import java.time.LocalDate;
import java.util.List;

public interface CaloriesStatisticRepo extends JpaRepository<CaloriesEntity, Long> {

    List<CaloriesEntity> findAllByDateBetweenAndUserId(@NotNull LocalDate start, @NotNull LocalDate end, @NotNull Long userId);

}
