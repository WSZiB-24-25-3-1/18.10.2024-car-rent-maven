package pl.edu.wszib.car.rent.authentication.impl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.wszib.car.rent.authentication.IAuthenticator;
import pl.edu.wszib.car.rent.db.IUserRepository;
import pl.edu.wszib.car.rent.db.impl.sql.UserRepositorySQL;
import pl.edu.wszib.car.rent.model.User;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class Authenticator implements IAuthenticator {
    private final IUserRepository userRepository;

    private String seed = "sy2eL273fTUxQoH3Zlm7wM4ZzK3bR4Gh";

    @Override
    public boolean authenticate(User user) {
        Optional<User> userBox = this.userRepository.getUser(user.getLogin());
        return userBox.isPresent() &&
                userBox.get().getPassword()
                        .equals(DigestUtils.md5Hex(user.getPassword()+seed));
    }
}
