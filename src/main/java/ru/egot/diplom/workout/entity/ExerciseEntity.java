package ru.egot.diplom.workout.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "EXERCISE")
@Accessors(chain = true)
public class ExerciseEntity extends BaseEntity {

    @JoinColumn(name = "USER_ID")
    @NotNull
    @ManyToOne
    private User user;

    @ManyToMany
    @JoinTable(
        name = "TRAINING_EXERCISE",
        joinColumns = @JoinColumn(name = "EXERCISE_ID"),
        inverseJoinColumns = @JoinColumn(name = "TRAINING_ID"))
    private List<TrainingEntity> trainingEntities;

    @Column(name = "NAME")
    @NotNull
    private String name;

    @Column(name = "SETS")
    @NotNull
    private Integer sets;

    @Column(name = "REPEATS")
    private Integer repeats;

    @Column(name = "TIME")
    private LocalTime time;

    @Column(name = "WEIGHT")
    private Integer weight;

    @Column(name = "COMMENT")
    private String comment;

}
