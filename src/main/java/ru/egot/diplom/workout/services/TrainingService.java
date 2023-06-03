package ru.egot.diplom.workout.services;

import ru.egot.diplom.workout.dto.training.TrainingDto;
import ru.egot.diplom.workout.entity.TrainingEntity;
import ru.egot.diplom.workout.exceptions.NotFoundException;

import java.util.List;

public interface TrainingService {

    TrainingEntity createTraining(TrainingDto trainingDto);

    TrainingEntity updateTraining(Long trainingId, TrainingDto trainingDto) throws NotFoundException;

    List<TrainingEntity> getAllTrainingByUserId(String userId);

    TrainingEntity getById(Long trainingId) throws NotFoundException;

}
