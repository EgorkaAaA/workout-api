package ru.egot.diplom.workout.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Table(name = "TRAINING")
public class TrainingEntity extends BaseEntity {

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
