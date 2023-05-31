package ru.egot.diplom.workout.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.egot.diplom.workout.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

		User findByNameAndDeletedDateIsNull(String name);

}
