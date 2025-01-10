package pl.edu.wszib.car.rent.db.impl.sql;

import lombok.Getter;
import org.springframework.stereotype.Component;
import pl.edu.wszib.car.rent.db.IMotorcycleRepository;
import pl.edu.wszib.car.rent.model.Motorcycle;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class MotorcycleRepositorySQL implements IMotorcycleRepository {

    private final String RENT_SQL = "UPDATE tmotorcycle SET rent = true WHERE plate = ? AND rent = false";
    private final String GET_ALL_SQL = "SELECT * FROM tmotorcycle";


    @Override
    public boolean rent(String plate) {
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
    public List<Motorcycle> getAll() {
        List<Motorcycle> result = new ArrayList<>();
        try {
            PreparedStatement preparedStatement =
                    Constants.CONNECTION.prepareStatement(GET_ALL_SQL);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {
                result.add(new Motorcycle(
                        rs.getInt("id"),
                        rs.getString("brand"),
                        rs.getString("model"),
                        rs.getInt("year"),
                        rs.getString("color"),
                        rs.getString("plate"),
                        rs.getBoolean("rent"),
                        rs.getBoolean("additionalSeat")));
            }
        } catch (SQLException e) {
            System.out.println("get cars failed");
        }

        return result;
    }
}
