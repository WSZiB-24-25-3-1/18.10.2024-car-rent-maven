package pl.edu.wszib.car.rent.db.impl;

import org.apache.commons.codec.digest.DigestUtils;
import pl.edu.wszib.car.rent.db.IUserRepository;
import pl.edu.wszib.car.rent.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository implements IUserRepository {
    private List<User> users = new ArrayList<>();
    private static UserRepository instance = new UserRepository();

    private UserRepository() {
        this.users.add(new User(
                1,
                "admin",
                DigestUtils.md5Hex("adminsy2eL273fTUxQoH3Zlm7wM4ZzK3bR4Gh")));
        this.users.add(new User(
                2,
                "janusz",
                DigestUtils.md5Hex("janusz123sy2eL273fTUxQoH3Zlm7wM4ZzK3bR4Gh")));
    }

    public static UserRepository getInstance() {
        return instance;
    }

    @Override
    public Optional<User> getUser(String login) {
        for(User user : this.users) {
            if(user.getLogin().equals(login)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<User> getUsers() {
        return users;
    }
}
