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

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExerciseEntity extends BaseEntity {

    @JoinColumn(name = "USER_ID")
    @NotNull
    @ManyToOne
    private User user;

    @Column(name = "NAME")
    @NotNull
    private String name;

    @Column(name = "SETS")
    @NotNull
    private Integer sets;

    @Column(name = "REPEATS")
    @NotNull
    private Integer repeats;

    @Column(name = "COMMENT")
    private String comment;

}