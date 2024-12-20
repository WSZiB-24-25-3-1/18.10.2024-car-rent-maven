package pl.edu.wszib.car.rent.db.impl.sql;

import lombok.Getter;
import pl.edu.wszib.car.rent.db.ICarRepository;
import pl.edu.wszib.car.rent.db.IMotorcycleRepository;
import pl.edu.wszib.car.rent.db.IVehicleRepository;
import pl.edu.wszib.car.rent.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleRepositorySQL implements IVehicleRepository {

    @Getter
    private final static VehicleRepositorySQL instance = new VehicleRepositorySQL();

    private final ICarRepository carRepository = CarRepositorySQL.getInstance();
    private final IMotorcycleRepository motorcycleRepository = MotorcycleRepositorySQL.getInstance();

    private VehicleRepositorySQL() {
    }

    @Override
    public boolean rent(String plate) {
        if(this.carRepository.rentCar(plate)) {
            return this.motorcycleRepository.rent(plate);
        }
        return true;
    }

    @Override
    public List<Vehicle> getAll() {
        List<Vehicle> result = new ArrayList<>();
        result.addAll(this.carRepository.getCars());
        result.addAll(this.motorcycleRepository.getAll());
        return result;
    }
}
