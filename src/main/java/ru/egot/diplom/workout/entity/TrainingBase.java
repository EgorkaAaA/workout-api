package ru.egot.diplom.workout.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public abstract class TrainingBase extends BaseEntity {

		@NotNull
		@JoinColumn(name = "USER_ID")
		@ManyToOne
		protected User user;

		@NotNull
		@ManyToMany
		@Column(name = "EXERCISES")
		protected List<ExerciseEntity> exercises;

		@Column(name = "COMMENT")
		protected String comment;

		@Column(name = "ENABLED")
		protected boolean enabled;


}
