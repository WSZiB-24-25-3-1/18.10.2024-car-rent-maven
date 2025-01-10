package pl.edu.wszib.car.rent.db.impl.sql;

import org.springframework.stereotype.Component;
import pl.edu.wszib.car.rent.db.IVehicleRepository;
import pl.edu.wszib.car.rent.model.Vehicle;

import java.util.List;

public class VehicleRepositoryV2SQL implements IVehicleRepository {
    @Override
    public boolean rent(String plate) {
        return false;
    }

    @Override
    public List<Vehicle> getAll() {
        return List.of();
    }
}
