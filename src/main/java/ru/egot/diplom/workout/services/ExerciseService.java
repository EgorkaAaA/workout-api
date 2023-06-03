package ru.egot.diplom.workout.services;

import ru.egot.diplom.workout.dto.training.ExerciseDto;
import ru.egot.diplom.workout.entity.ExerciseEntity;

import java.util.List;

public interface ExerciseService {

		ExerciseEntity createExercise(ExerciseDto exerciseDto);

		List<ExerciseEntity> createExerciseList(List<ExerciseDto> exerciseDtoList);

		List<ExerciseEntity> findAllByUserId(String userId);

		List<ExerciseEntity> findAllByUserIdAndTrainingId(String userId, Long trainingId);

		ExerciseEntity findById(Long id);

		ExerciseEntity updateById(Long id, ExerciseDto exerciseDto);

		ExerciseEntity map(ExerciseDto exerciseDto);

		List<ExerciseEntity> mapAll(List<ExerciseDto> exerciseDtoList);

}
