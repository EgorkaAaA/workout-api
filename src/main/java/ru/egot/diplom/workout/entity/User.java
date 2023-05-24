package ru.egot.diplom.workout.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
@Table(name = "USER_TABLE")
public class User extends BaseEntity {

    @NotNull
    @Column(name = "NAME")
    private String name;

    @NotNull
    @Column(name = "PASSWORD")
    private String password;

}
