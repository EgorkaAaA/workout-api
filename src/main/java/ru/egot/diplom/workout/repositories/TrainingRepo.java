package ru.egot.diplom.workout.repositories;

import ru.egot.diplom.workout.entity.TrainingEntity;
import ru.egot.diplom.workout.entity.User;

import java.util.List;
import java.util.Optional;

public interface TrainingRepo extends BaseRepo<TrainingEntity> {

    List<TrainingEntity> findAllByUserAndEnabledIsTrueAndDeletedDateIsNullOrderByCreatedDateDesc(User user);

    Optional<TrainingEntity> findByIdAndUserAndDeletedDateIsNull(Long id, User user);
}
