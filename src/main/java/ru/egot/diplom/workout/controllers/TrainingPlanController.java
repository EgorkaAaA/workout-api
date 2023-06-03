package ru.egot.diplom.workout.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.egot.diplom.workout.dto.plan.TrainingPlan;
import ru.egot.diplom.workout.entity.TrainingPlanEntity;
import ru.egot.diplom.workout.services.TrainingPlanService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/public/plan/training")
public class TrainingPlanController {

	private final TrainingPlanService trainingPlanService;

	@PostMapping
	public TrainingPlanEntity setTrainingPlanForUser(@RequestBody TrainingPlan trainingPlan) {
		return trainingPlanService.setTrainingPlanForUser(trainingPlan);
	}
}
