package ru.egot.diplom.workout.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TRAINING_COMPLETE")
public class TrainingCompleteEntity extends BaseEntity {

		@NotNull
		@JoinColumn(name = "USER_ID")
		@ManyToOne
		private User userId;

		@NotNull
		@JoinColumn(name = "TRAINING_ID")
		@ManyToOne
		private TrainingEntity trainingId;

		@NotNull
		@Column(name = "COMPLETE_DATE")
		private LocalDateTime date;
}
