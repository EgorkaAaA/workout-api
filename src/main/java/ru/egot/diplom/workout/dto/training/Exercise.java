package ru.egot.diplom.workout.dto.training;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Exercise {

    private final String name;

    private final Integer sets;

    private final Integer repeats;

    private final String comment;
}
