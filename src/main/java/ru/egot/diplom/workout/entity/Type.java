package ru.egot.diplom.workout.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Type {

    SLEEP("sleep"),
    CALORIES("calories");

    private final String name;

}
