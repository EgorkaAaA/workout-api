package ru.egot.diplom.workout.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.egot.diplom.workout.dto.plan.TrainingPlan;

@RestController
@RequiredArgsConstructor
@RequestMapping("/plan/training")
public class TrainingPlanController {

		@PostMapping
		public TrainingPlan setTrainingPlanForUser(@RequestBody TrainingPlan trainingPlan) {
				return trainingPlan;
		}
}
