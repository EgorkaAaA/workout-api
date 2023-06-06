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

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CaloriesEntity extends BaseEntity {

		@NotNull
		@JoinColumn(name = "USER_ID")
		@ManyToOne
		private User user;

		@NotNull
		@Column(name = "DATE")
		private LocalDate date;

    @NotNull
    @Column(name = "CALORIES_ACTUAL")
    private double caloriesActual;

    @NotNull
    @Column(name = "CALORIES_PLAN")
    private double caloriesPlan;

}
