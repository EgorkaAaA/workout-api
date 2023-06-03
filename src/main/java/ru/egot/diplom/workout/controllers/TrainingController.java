package ru.egot.diplom.workout.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.egot.diplom.workout.dto.plan.TrainingPlan;
import ru.egot.diplom.workout.dto.training.TrainingDto;
import ru.egot.diplom.workout.entity.TrainingEntity;
import ru.egot.diplom.workout.entity.TrainingPlanEntity;
import ru.egot.diplom.workout.services.TrainingPlanService;
import ru.egot.diplom.workout.services.TrainingService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/public/training")
public class TrainingController {

	private final TrainingPlanService trainingPlanService;

	private final TrainingService trainingService;

	@PostMapping("/plan")
	public TrainingPlanEntity setTrainingPlanForUser(@RequestBody TrainingPlan trainingPlan) {
		return trainingPlanService.setTrainingPlanForUser(trainingPlan);
	}

	@PostMapping
	public TrainingEntity createTraining(@RequestBody TrainingDto training) {
		return trainingService.createTraining(training);
	}
}
