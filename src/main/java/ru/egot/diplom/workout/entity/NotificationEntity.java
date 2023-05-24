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
import ru.egot.diplom.workout.enums.GraphType;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NotificationEntity extends BaseEntity {

    @JoinColumn(name = "USER_ID")
    @NotNull
    @ManyToOne
    private User user;

    @Column(name = "TYPE")
    @NotNull
    private GraphType type;

    @Column(name = "ENABLED")
    @NotNull
    private boolean enabled;

}
