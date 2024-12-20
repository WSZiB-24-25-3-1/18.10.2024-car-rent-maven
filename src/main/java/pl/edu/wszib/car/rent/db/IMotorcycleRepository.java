package pl.edu.wszib.car.rent.db;

import pl.edu.wszib.car.rent.model.Motorcycle;

import java.util.List;

public interface IMotorcycleRepository {
    boolean rent(String plate);
    List<Motorcycle> getAll();
}
