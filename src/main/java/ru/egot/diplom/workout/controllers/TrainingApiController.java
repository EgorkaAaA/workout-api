package ru.egot.diplom.workout.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.egot.diplom.workout.dto.training.api.TrainingApiDifficulty;
import ru.egot.diplom.workout.dto.training.api.TrainingApiMuscle;
import ru.egot.diplom.workout.dto.training.api.TrainingApiResponse;
import ru.egot.diplom.workout.dto.training.api.TrainingApiType;
import ru.egot.diplom.workout.services.TrainingApiSender;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/public/recommendations")
public class TrainingApiController {

		private final TrainingApiSender sender;

		@GetMapping
		public ResponseEntity<List<TrainingApiResponse>> getTrainingRecommendations(
				@RequestParam(name = "muscle") String muscle,
				@RequestParam(name = "type", required = false) String type,
				@RequestParam(name = "difficulty", required = false) String difficulty,
				@RequestParam(name = "offset", defaultValue = "0", required = false) Integer offset
		) {
				return ResponseEntity.ok(sender.getExercises(TrainingApiType.getTypeByName(type), TrainingApiMuscle.getMuscleByName(muscle), TrainingApiDifficulty.getDifficultyByName(difficulty), offset));
		}

		@GetMapping("/muscles")
		public ResponseEntity<TrainingApiMuscle[]> getMuscles() {
				return ResponseEntity.ok(TrainingApiMuscle.values());
		}

		@GetMapping("/types")
		public ResponseEntity<TrainingApiType[]> getTypes() {
				return ResponseEntity.ok(TrainingApiType.values());
		}

		@GetMapping("/difficulties")
		public ResponseEntity<TrainingApiDifficulty[]> getDifficulties() {
				return ResponseEntity.ok(TrainingApiDifficulty.values());
		}

}
