package pl.edu.wszib.car.rent.db.impl.sql;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import pl.edu.wszib.car.rent.db.ICarRepository;
import pl.edu.wszib.car.rent.db.IMotorcycleRepository;
import pl.edu.wszib.car.rent.db.IVehicleRepository;
import pl.edu.wszib.car.rent.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class VehicleRepositorySQL implements IVehicleRepository {

    private final ICarRepository carRepository;
    private final IMotorcycleRepository motorcycleRepository;

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
