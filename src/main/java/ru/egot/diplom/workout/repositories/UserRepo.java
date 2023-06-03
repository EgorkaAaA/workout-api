package ru.egot.diplom.workout.repositories;

import ru.egot.diplom.workout.entity.User;

public interface UserRepo extends BaseRepo<User> {

		User findByNameAndDeletedDateIsNull(String name);

}
