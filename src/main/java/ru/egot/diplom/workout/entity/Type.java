package ru.egot.diplom.workout.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Type {

    SLEEP("sleep"),
    TRAINING("training"),
    CALORIES("calories");

    private final String name;

}
