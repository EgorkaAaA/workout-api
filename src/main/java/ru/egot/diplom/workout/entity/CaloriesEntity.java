package ru.egot.diplom.workout.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CaloriesEntity extends BaseEntity{

    @NotNull
    private Long userId;

    @NotNull
    private LocalDate date;

    @NotNull
    private long caloriesActual;

    @NotNull
    private long caloriesPlan;

}
