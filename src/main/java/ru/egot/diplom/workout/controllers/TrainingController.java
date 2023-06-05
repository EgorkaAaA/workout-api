package ru.egot.diplom.workout.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.egot.diplom.workout.dto.training.ExerciseDto;
import ru.egot.diplom.workout.dto.training.TrainingCompleteDto;
import ru.egot.diplom.workout.dto.training.TrainingDto;
import ru.egot.diplom.workout.dto.training.TrainingPlanDto;
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
@CrossOrigin
public class TrainingController {

		private final TrainingPlanService trainingPlanService;

		private final TrainingService trainingService;

		private final ExerciseService exerciseService;

		@PostMapping("/plan")
		public ResponseEntity<List<TrainingPlanEntity>> setTrainingPlanForUser(@RequestBody TrainingPlanDto trainingPlan) {
				return ResponseEntity.ok(trainingPlanService.setTrainingPlanForUser(trainingPlan));
		}

		@PostMapping("/complete")
		public ResponseEntity<TrainingCompleteEntity> setTrainingCompleteForUser(@RequestBody TrainingCompleteDto trainingCompleteDto) {
				return ResponseEntity.ok(trainingPlanService.setTrainingCompleteForUser(trainingCompleteDto));
		}

		@PostMapping
		public ResponseEntity<TrainingEntity> createTraining(@RequestBody TrainingDto training) {
				return ResponseEntity.ok(trainingService.createTraining(training));
		}

		@GetMapping("/{id}")
		public ResponseEntity<TrainingEntity> getTrainingById(@PathVariable Long id) {
				return ResponseEntity.ok(trainingService.getById(id));
		}

		@GetMapping
		public ResponseEntity<List<TrainingEntity>> getAllTrainingByUserId(@RequestParam String userId) {
				return ResponseEntity.ok(trainingService.getAllTrainingByUserId(userId));
		}

		@PutMapping("/{id}")
		public ResponseEntity<TrainingEntity> updateTraining(@PathVariable Long id, @RequestBody TrainingDto training) {
				return ResponseEntity.ok(trainingService.updateTraining(id, training));
		}

		@PostMapping("/{id}/exercises")
		public ResponseEntity<ExerciseEntity> createExercise(@PathVariable(name = "id") Long trainingId, @RequestBody ExerciseDto exerciseDto) {
				return ResponseEntity.ok(exerciseService.createExercise(exerciseDto.setTrainingId(trainingId)));
		}

		@GetMapping("/exercises")
		public ResponseEntity<List<ExerciseEntity>> findAllExerciseByUserId(@RequestParam String userId) {
				return ResponseEntity.ok(exerciseService.findAllByUserId(userId));
		}

		@GetMapping("/{id}/exercises")
		public ResponseEntity<List<ExerciseEntity>> findAllExerciseByUserIdAndTrainingId(@PathVariable(name = "id") Long trainingId, @RequestParam String userId) {
				return ResponseEntity.ok(exerciseService.findAllByUserIdAndTrainingId(userId, trainingId));
		}

		@PutMapping("/exercises/{exerciseId}")
		public ResponseEntity<ExerciseEntity> updateExerciseById(@PathVariable Long exerciseId, @RequestBody ExerciseDto exerciseDto) {
				return ResponseEntity.ok(exerciseService.updateById(exerciseId, exerciseDto));
		}

}
