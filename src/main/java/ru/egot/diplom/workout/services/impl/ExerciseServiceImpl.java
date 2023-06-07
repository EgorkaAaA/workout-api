package ru.egot.diplom.workout.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.egot.diplom.workout.dto.training.ExerciseDto;
import ru.egot.diplom.workout.entity.ExerciseEntity;
import ru.egot.diplom.workout.exceptions.NotFoundException;
import ru.egot.diplom.workout.repositories.ExerciseRepo;
import ru.egot.diplom.workout.services.ExerciseService;
import ru.egot.diplom.workout.services.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepo exerciseRepo;

    private final UserService userService;

    @Override
    public ExerciseEntity createExercise(ExerciseDto exerciseDto) {
        return exerciseRepo.save(map(exerciseDto));
    }

    @Override
    public List<ExerciseEntity> createExerciseList(List<ExerciseDto> exerciseDtoList) {
        return exerciseRepo.saveAll(mapAll(exerciseDtoList));
    }

    @Override
    public List<ExerciseEntity> findAllByUserId(String userId) {
        return exerciseRepo.findAllByUserAndDeletedDateIsNull(userService.getUserByName(userId));
    }

    @Override
    public List<ExerciseEntity> findAllByUserIdAndTrainingId(String userId, Long trainingId) {
        return exerciseRepo.findAllByUserAndTrainingEntities(userId, trainingId);
    }

    @Override
    public ExerciseEntity findByIdAndUser(Long id, String username) {
        return exerciseRepo.findByIdAndUserAndDeletedDateIsNull(id, userService.getUserByName(username)).orElseThrow(() -> new NotFoundException("Exercise with id: %s not found".formatted(id)));
    }

    @Override
    public ExerciseEntity updateById(Long id, ExerciseDto exerciseDto) {
        return findByIdAndUser(id, exerciseDto.getUserId()).setName(exerciseDto.getName())
                .setSets(exerciseDto.getSets())
                .setRepeats(exerciseDto.getRepeats())
                .setWeight(exerciseDto.getWight())
                .setDuration(exerciseDto.getDuration())
                .setComment(exerciseDto.getComment());
    }

    @Override
    public ExerciseEntity map(ExerciseDto exerciseDto) {
        return new ExerciseEntity().setUser(userService.getUserByName(exerciseDto.getUserId()))
                .setName(exerciseDto.getName())
                .setSets(exerciseDto.getSets())
                .setRepeats(exerciseDto.getRepeats())
                .setWeight(exerciseDto.getWight())
                .setDuration(exerciseDto.getDuration())
                .setComment(exerciseDto.getComment());
    }

    @Override
    public List<ExerciseEntity> mapAll(List<ExerciseDto> exerciseDtoList) {
        return exerciseDtoList.stream()
                .map(this::map)
                .toList();
    }
}
