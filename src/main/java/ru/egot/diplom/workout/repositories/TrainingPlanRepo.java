package ru.egot.diplom.workout.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.egot.diplom.workout.entity.TrainingPlanEntity;

public interface TrainingPlanRepo extends JpaRepository<TrainingPlanEntity, Long> {

}
