package ru.egot.diplom.workout.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

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

    @Column(name = "NAME")
    @NotNull
    private String name;

    @Column(name = "SETS")
    @NotNull
    private Integer sets;

    @Column(name = "REPEATS")
    private Integer repeats;

    @Column(name = "TIME")
    private String time;

    @Column(name = "WEIGHT")
    private Integer weight;

    @Column(name = "COMMENT")
    private String comment;

}
