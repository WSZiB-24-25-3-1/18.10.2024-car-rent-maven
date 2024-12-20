package pl.edu.wszib.car.rent.db;

import pl.edu.wszib.car.rent.model.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    boolean rent(String plate);
    List<Vehicle> getAll();
}
