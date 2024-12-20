package pl.edu.wszib.car.rent.db;

import pl.edu.wszib.car.rent.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    Optional<User> getUser(String login);
    List<User> getUsers();
    default void persist(User user) {
        throw new UnsupportedOperationException();
    }
}
