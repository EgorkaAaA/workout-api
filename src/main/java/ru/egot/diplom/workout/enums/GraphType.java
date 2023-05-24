package ru.egot.diplom.workout.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GraphType {

    SLEEP("sleep"),
    CALORIES("calories");

    private final String name;

}
