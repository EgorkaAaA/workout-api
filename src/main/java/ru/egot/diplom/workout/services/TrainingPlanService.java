package ru.egot.diplom.workout.services;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.egot.diplom.workout.dto.training.TrainingCompleteDto;
import ru.egot.diplom.workout.dto.training.TrainingPlanDto;
import ru.egot.diplom.workout.entity.TrainingCompleteEntity;
import ru.egot.diplom.workout.entity.TrainingPlanEntity;

import java.util.List;

public interface TrainingPlanService {

    List<TrainingPlanEntity> setTrainingPlanForUser(TrainingPlanDto trainingPlans) throws UsernameNotFoundException;

    TrainingCompleteEntity setTrainingCompleteForUser(TrainingCompleteDto trainingCompleteDto) throws UsernameNotFoundException;

}
