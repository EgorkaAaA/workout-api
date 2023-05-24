package ru.egot.diplom.workout.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User userId;

    @NotNull
    @Column(name = "DATE")
    private LocalDate date;

    @NotNull
    @Range(max = 24, message = "Время сна не может быть отрицательным или больше 24 часов!")
    @Column(name = "HOUR_ACTUAL")
    private int hourActual;

    @NotNull
    @Range(max = 24, message = "Время сна не может быть отрицательным или больше 24 часов!")
    @Column(name = "HOUR_PLAN")
    private int hourPlan;

}
