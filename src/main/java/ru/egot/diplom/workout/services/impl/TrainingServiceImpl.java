package ru.egot.diplom.workout.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.egot.diplom.workout.dto.training.TrainingDto;
import ru.egot.diplom.workout.entity.TrainingEntity;
import ru.egot.diplom.workout.exceptions.NotFoundException;
import ru.egot.diplom.workout.repositories.TrainingRepo;
import ru.egot.diplom.workout.services.TrainingService;
import ru.egot.diplom.workout.services.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainingServiceImpl implements TrainingService {

    private final TrainingRepo trainingRepo;

    private final UserService userService;



    @Override
    public TrainingEntity createTraining(TrainingDto trainingDto) {
        return trainingRepo.save(
                new TrainingEntity().toBuilder()
                        .user(userService.getUserByName(trainingDto.getUserId()))
                        .exercises(null)
                        .comment(trainingDto.getComment())
                        .enabled(trainingDto.getEnabled())
                .build()
        );
    }

    @Override
    public TrainingEntity updateTraining(Long trainingId, TrainingDto trainingDto) throws NotFoundException {
        TrainingEntity trainingEntity = trainingRepo.findById(trainingId).orElseThrow(() -> new NotFoundException("Training with id: %s not found".formatted(trainingId)));
        trainingEntity.setComment(trainingDto.getComment());
        trainingEntity.setEnabled(trainingDto.getEnabled());
        trainingEntity.setExercises(null);
        return trainingRepo.save(trainingEntity);
    }

    @Override
    public List<TrainingEntity> getAllTrainingByUserId(String userId) {
        return trainingRepo.findAllByUserAndEnabledIsTrueAndDeletedDateIsNullOrderByCreatedDateDesc(userService.getUserByName(userId));
    }

    @Override
    public TrainingEntity getById(String trainingId) throws NotFoundException {
        return null;
    }
}
