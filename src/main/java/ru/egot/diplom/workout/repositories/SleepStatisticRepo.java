package ru.egot.diplom.workout.repositories;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.egot.diplom.workout.entity.SleepEntity;

import java.time.LocalDate;
import java.util.List;

public interface SleepStatisticRepo extends JpaRepository<SleepEntity, Long> {

    List<SleepEntity> findAllByDateBetweenAndUserId(@NotNull LocalDate start, @NotNull LocalDate end, @NotNull Long userId);

}
