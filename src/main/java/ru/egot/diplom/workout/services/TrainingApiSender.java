package ru.egot.diplom.workout.services;

import ru.egot.diplom.workout.dto.training.api.TrainingApiDifficulty;
import ru.egot.diplom.workout.dto.training.api.TrainingApiMuscle;
import ru.egot.diplom.workout.dto.training.api.TrainingApiResponse;
import ru.egot.diplom.workout.dto.training.api.TrainingApiType;

import java.util.List;

public interface TrainingApiSender {

    List<TrainingApiResponse> getExercises(TrainingApiType type, TrainingApiMuscle muscle, TrainingApiDifficulty difficulty, Integer offset);

}
