package ru.egot.diplom.workout.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.util.List;

@Entity
@Getter
@Setter
public class TrainingPlanEntity extends TrainingBase {

    public TrainingPlanEntity(@NotNull User user, @NotNull List<ExerciseEntity> exercises, String comment, boolean enabled, List<DayOfWeek> days) {
        super(user, exercises, comment, enabled);
        this.days = days;
    }

    @NotNull
    @Column(name = "DAYS")
    private List<DayOfWeek> days;

    public TrainingPlanEntity() {
        super();
    }
}
