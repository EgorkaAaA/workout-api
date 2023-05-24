package ru.egot.diplom.workout.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.DayOfWeek;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TrainingPlanEntity extends BaseEntity {

    @NotNull
    @Column(name = "USER_ID")
    @ManyToOne
    private User user;

    @NotNull
    @ManyToMany
    @Column(name = "EXERCISES")
    private List<ExerciseEntity> exercises;

    @NotNull
    @Column(name = "DAYS")
    private List<DayOfWeek> days;

    @Column(name = "COMMENT")
    private String comment;

    @Column(name = "ENABLED")
    private boolean enabled;
}
