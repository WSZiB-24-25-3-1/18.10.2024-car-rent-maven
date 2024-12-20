package pl.edu.wszib.car.rent.db.impl.sql;

import lombok.Getter;
import pl.edu.wszib.car.rent.db.IUserRepository;
import pl.edu.wszib.car.rent.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepositorySQL implements IUserRepository {
    @Getter
    private static final UserRepositorySQL instance = new UserRepositorySQL();

    private final String GET_ALL_USERS_SQL = "select * from tuser";
    private final String GET_USER_BY_LOGIN_SQL = "select * from tuser where login = ?";

    private UserRepositorySQL() {
    }

    @Override
    public Optional<User> getUser(String login) {
        try {
            PreparedStatement preparedStatement =
                    Constants.CONNECTION.prepareStatement(GET_USER_BY_LOGIN_SQL);
            preparedStatement.setString(1, login);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return Optional.of(new User(
                        rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("password")
                ));
            }
        } catch (SQLException e) {
            System.out.println("get user by login failed");
        }

        return Optional.empty();
    }

    @Override
    public List<User> getUsers() {
        List<User> result = new ArrayList<>();
        try {
            PreparedStatement preparedStatement =
                    Constants.CONNECTION.prepareStatement(GET_ALL_USERS_SQL);

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {
                result.add(new User(
                        rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("password")
                ));
            }
        } catch (SQLException e) {
            System.out.println("get users failed");
        }

        return result;
    }
}
