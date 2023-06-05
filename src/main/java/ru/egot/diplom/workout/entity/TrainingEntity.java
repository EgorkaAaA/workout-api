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
	@JoinTable(
			name = "TRAINING_EXERCISE",
			joinColumns = @JoinColumn(name = "TRAINING_ID"),
			inverseJoinColumns = @JoinColumn(name = "EXERCISE_ID"))
	protected List<ExerciseEntity> exercises;

	@Column(name = "NAME")
	@NotNull
	protected String name;

	@Column(name = "COMMENT")
	protected String comment;


	@Column(name = "ENABLED")
	protected boolean enabled;

}
