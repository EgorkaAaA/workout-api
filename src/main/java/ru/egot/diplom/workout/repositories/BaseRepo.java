package ru.egot.diplom.workout.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.egot.diplom.workout.entity.BaseEntity;

public interface BaseRepo<T extends BaseEntity> extends JpaRepository<T, Long> {
}
