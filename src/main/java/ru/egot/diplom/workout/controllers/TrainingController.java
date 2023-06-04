package ru.egot.diplom.workout.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.egot.diplom.workout.dto.training.TrainingCompleteDto;
import ru.egot.diplom.workout.dto.training.TrainingPlanDto;
import ru.egot.diplom.workout.dto.training.ExerciseDto;
import ru.egot.diplom.workout.dto.training.TrainingDto;
import ru.egot.diplom.workout.entity.ExerciseEntity;
import ru.egot.diplom.workout.entity.TrainingCompleteEntity;
import ru.egot.diplom.workout.entity.TrainingEntity;
import ru.egot.diplom.workout.entity.TrainingPlanEntity;
import ru.egot.diplom.workout.services.ExerciseService;
import ru.egot.diplom.workout.services.TrainingPlanService;
import ru.egot.diplom.workout.services.TrainingService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/public/trainings")
public class TrainingController {

		private final TrainingPlanService trainingPlanService;

		private final TrainingService trainingService;

		private final ExerciseService exerciseService;

		@PostMapping("/plan")
		public List<TrainingPlanEntity> setTrainingPlanForUser(@RequestBody TrainingPlanDto trainingPlan) {
				return trainingPlanService.setTrainingPlanForUser(trainingPlan);
		}

		@PostMapping("/complete")
		public TrainingCompleteEntity setTrainingCompleteForUser(@RequestBody TrainingCompleteDto trainingCompleteDto) {
				return trainingPlanService.setTrainingCompleteForUser(trainingCompleteDto);
		}

		@PostMapping
		public TrainingEntity createTraining(@RequestBody TrainingDto training) {
				return trainingService.createTraining(training);
		}

		@GetMapping("/{id}")
		public TrainingEntity getTrainingById(@PathVariable Long id) {
				return trainingService.getById(id);
		}

		@GetMapping
		public List<TrainingEntity> getAllTrainingByUserId(@RequestParam String userId) {
				return trainingService.getAllTrainingByUserId(userId);
		}

		@PutMapping("/{id}")
		public TrainingEntity updateTraining(@PathVariable Long id, @RequestBody TrainingDto training) {
				return trainingService.updateTraining(id, training);
		}

		@PostMapping("/{id}/exercises")
		public ExerciseEntity createExercise(@PathVariable(name = "id") Long trainingId, @RequestBody ExerciseDto exerciseDto) {
				return exerciseService.createExercise(exerciseDto.setTrainingId(trainingId));
		}

		@GetMapping("/exercises")
		public List<ExerciseEntity> findAllExerciseByUserId(@RequestParam String userId) {
				return exerciseService.findAllByUserId(userId);
		}

		@GetMapping("/{id}/exercises")
		public List<ExerciseEntity> findAllExerciseByUserIdAndTrainingId(@PathVariable(name = "id") Long trainingId, @RequestParam String userId) {
				return exerciseService.findAllByUserIdAndTrainingId(userId, trainingId);
		}

		@PutMapping("/exercises/{exerciseId}")
		public ExerciseEntity updateExerciseById(@PathVariable Long exerciseId, @RequestBody ExerciseDto exerciseDto) {
				return exerciseService.updateById(exerciseId, exerciseDto);
		}

}
