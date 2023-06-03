package ru.egot.diplom.workout.repositories;

import ru.egot.diplom.workout.entity.TrainingEntity;
import ru.egot.diplom.workout.entity.User;

import java.util.List;

public interface TrainingRepo extends BaseRepo<TrainingEntity> {

    List<TrainingEntity> findAllByUserAndEnabledIsTrueAndDeletedDateIsNullOrderByCreatedDateDesc(User user);

}
