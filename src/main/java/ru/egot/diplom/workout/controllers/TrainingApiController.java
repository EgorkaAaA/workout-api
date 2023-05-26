package ru.egot.diplom.workout.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.egot.diplom.workout.dto.plan.training.api.TrainingApiDifficulty;
import ru.egot.diplom.workout.dto.plan.training.api.TrainingApiMuscle;
import ru.egot.diplom.workout.dto.plan.training.api.TrainingApiResponse;
import ru.egot.diplom.workout.dto.plan.training.api.TrainingApiType;
import ru.egot.diplom.workout.services.TrainingApiSender;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recommendations")
public class TrainingApiController {

    private final TrainingApiSender sender;

    @GetMapping
    public List<TrainingApiResponse> getTrainingRecommendations(
            @RequestParam(name = "type", required = false) String type,
            @RequestParam(name = "muscle") String muscle,
            @RequestParam(name = "difficulty", required = false) String difficulty,
            @RequestParam(name = "offset", defaultValue = "0", required = false) Integer offset
    ) {
        return sender.getExercises(TrainingApiType.getTypeByName(type), TrainingApiMuscle.getMuscleByName(muscle), TrainingApiDifficulty.getDifficultyByName(difficulty), offset);
    }
}
