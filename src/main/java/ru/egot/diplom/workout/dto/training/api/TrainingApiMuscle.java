package ru.egot.diplom.workout.dto.training.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum TrainingApiMuscle {

    ABDOMINALS("abdominals"),
    ABDUCTORS("abductors"),
    ADDUCTORS("adductors"),
    BICEPS("biceps"),
    CALVES("calves"),
    CHEST("chest"),
    FOREARMS("forearms"),
    GLUTES("glutes"),
    HAMSTRINGS("hamstrings"),
    LATS("lats"),
    LOWER_BACK("lower_back"),
    MIDDLE_BACK("middle_back"),
    NECK("neck"),
    QUADRICEPS("quadriceps"),
    TRAPS("traps"),
    TRICEPS("triceps");

    private final String name;

    public static TrainingApiMuscle getMuscleByName(String name) {
        if (name == null) {
            return null;
        }
        return Arrays.stream(TrainingApiMuscle.values())
                .map(TrainingApiMuscle::getName)
                .filter(n -> n.equals(name.toLowerCase()))
                .findFirst()
                .map(n -> TrainingApiMuscle.valueOf(name.toUpperCase()))
                .orElseThrow(() -> new RuntimeException("Muscle not found!"));
    }
}
