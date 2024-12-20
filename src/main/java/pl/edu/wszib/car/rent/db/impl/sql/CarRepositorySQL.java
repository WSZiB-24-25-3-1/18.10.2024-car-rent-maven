package pl.edu.wszib.car.rent.db.impl.sql;

import lombok.Getter;
import pl.edu.wszib.car.rent.db.ICarRepository;
import pl.edu.wszib.car.rent.model.Car;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarRepositorySQL implements ICarRepository {

    @Getter
    private static final CarRepositorySQL instance = new CarRepositorySQL();

    private final String RENT_SQL = "UPDATE tcar SET rent = true WHERE plate = ? AND rent = false";
    private final String GET_ALL_SQL = "SELECT * FROM tcar";

    private CarRepositorySQL() {
    }

    @Override
    public boolean rentCar(String plate) {
        try {
            PreparedStatement preparedStatement =
                    Constants.CONNECTION.prepareStatement(RENT_SQL);
            preparedStatement.setString(1, plate);

            int updatedRows = preparedStatement.executeUpdate();
            return updatedRows == 1;
        } catch (SQLException e) {
            System.out.println("rent car failed");
            return false;
        }
    }

    @Override
    public List<Car> getCars() {
        List<Car> result = new ArrayList<>();
        try {
            PreparedStatement preparedStatement =
                    Constants.CONNECTION.prepareStatement(GET_ALL_SQL);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {
                result.add(new Car(
                        rs.getInt("id"),
                        rs.getString("brand"),
                        rs.getString("model"),
                        rs.getInt("year"),
                        rs.getString("color"),
                        rs.getString("plate"),
                        rs.getBoolean("rent")));
            }
        } catch (SQLException e) {
            System.out.println("get cars failed");
        }

        return result;
    }
}
