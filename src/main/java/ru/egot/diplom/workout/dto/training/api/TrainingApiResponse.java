package ru.egot.diplom.workout.dto.training.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class TrainingApiResponse {

    private String name;

    private String type;

    private String muscle;

    private String equipment;

    private String difficulty;

    private String instructions;

}
