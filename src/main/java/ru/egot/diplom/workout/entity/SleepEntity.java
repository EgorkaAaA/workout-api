package ru.egot.diplom.workout.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SleepEntity extends BaseEntity {

    @NotNull
    private Long userId;

    @NotNull
    private LocalDate date;

    @NotNull
    @Range(max = 24, message = "Время сна не может быть отрицательным или больше 24 часов!")
    private int hourActual;

    @NotNull
    @Range(max = 24, message = "Время сна не может быть отрицательным или больше 24 часов!")
    private int hourPlan;

}
