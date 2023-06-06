package ru.egot.diplom.workout.dto.statistic;

import lombok.*;
import lombok.experimental.Accessors;
import ru.egot.diplom.workout.entity.Type;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Accessors(chain = true)
public class DashboardDataDto {

    private String username;

    private Type type;

    private String date;

    private double plan;

    private double actual;

}
