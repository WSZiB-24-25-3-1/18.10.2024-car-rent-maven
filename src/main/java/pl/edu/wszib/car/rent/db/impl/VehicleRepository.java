package pl.edu.wszib.car.rent.db.impl;

import pl.edu.wszib.car.rent.db.IVehicleRepository;
import pl.edu.wszib.car.rent.model.Car;
import pl.edu.wszib.car.rent.model.Motorcycle;
import pl.edu.wszib.car.rent.model.Truck;
import pl.edu.wszib.car.rent.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleRepository implements IVehicleRepository {
    List<Vehicle> vehicles = new ArrayList<>();
    private static VehicleRepository instance = new VehicleRepository();

    private VehicleRepository() {
        this.vehicles.add(new Car(1,"Toyota",  "Corolla",
                2020,  "Red",  "KR11"));
        this.vehicles.add(new Car(2,"Kia",  "Ceed",
                2021,  "Yellow",  "KR22"));
        this.vehicles.add(new Car(3,"BMW",  "5",
                2022,  "Black",  "KR33"));
        this.vehicles.add(new Car(4,"Mercedes",  "C",
                2019,  "White",  "KR44"));
        this.vehicles.add(new Car(5,"Honda",  "Civic",
                2020,  "Red", "KR55"));
        this.vehicles.add(new Truck(6, "Volvo", "Super", 2021,
                "Black", "KR666", 1000));
        this.vehicles.add(new Truck(7, "Scania", "Jakas", 2020,
                "Black", "KR777", 800));
        this.vehicles.add(new Motorcycle(1,"Honda", "1000", 2010,
                "Yellow", "KR8888", false));
    }

    @Override
    public boolean rent(String plate) {
        for(Vehicle vehicle : this.vehicles) {
            if(vehicle.getPlate().equals(plate) && !vehicle.isRent()) {
                vehicle.setRent(true);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Vehicle> getAll() {
        return this.vehicles;
    }

    public static VehicleRepository getInstance() {
        return instance;
    }
}
