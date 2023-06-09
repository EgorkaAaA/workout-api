package ru.egot.diplom.workout.dto.training;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@AllArgsConstructor
@Accessors(chain = true)
@NoArgsConstructor
public class ExerciseDto {

    private String userId;

    private Long exerciseId;

    private String name;

    private Integer sets;

    private Integer repeats;

    private String duration;

    private Integer wight;

    private String comment;

    private Long trainingId;
}
