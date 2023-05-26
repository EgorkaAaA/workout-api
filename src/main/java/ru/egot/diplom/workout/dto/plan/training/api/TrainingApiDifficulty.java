package ru.egot.diplom.workout.dto.plan.training.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum TrainingApiDifficulty {

    BEGINNER("beginner"),
    INTERMEDIATE("intermediate"),
    EXPERT("expert");

    private final String name;

    public static TrainingApiDifficulty getDifficultyByName(String name) {
        return Arrays.stream(TrainingApiDifficulty.values())
                .map(TrainingApiDifficulty::getName)
                .filter(n -> n.equals(name.toLowerCase()))
                .findFirst()
                .map(n -> TrainingApiDifficulty.valueOf(name.toUpperCase()))
                .orElseThrow(() -> new RuntimeException("Difficulty not found!"));
    }
}
