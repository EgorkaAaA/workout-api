package ru.egot.diplom.workout.dto.training.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum TrainingApiType {

    CARDIO("cardio"),
    OLYMPIC_WEIGHTLIFTING("olympic_weightlifting"),
    PLYOMETRICS("plyometrics"),
    POWERLIFTING("powerlifting"),
    STRENGTH("strength"),
    STRETCHING("stretching"),
    STRONGMAN("stretching");

    private final String name;

    public static TrainingApiType getTypeByName(String name) {
        if (name == null) {
            return null;
        }
        return Arrays.stream(TrainingApiType.values())
                .map(TrainingApiType::getName)
                .filter(n -> n.equals(name.toLowerCase()))
                .findFirst()
                .map(n -> TrainingApiType.valueOf(name.toUpperCase()))
                .orElseThrow(() -> new RuntimeException("Type not found!"));
    }

}
