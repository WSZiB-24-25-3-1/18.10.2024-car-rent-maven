package pl.edu.wszib.car.rent.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Motorcycle extends Vehicle {
    private boolean passenger;

    public Motorcycle(String brand, String model, int year,
                      String color, String plate, boolean passenger) {
        super(brand, model, year, color, plate, false);
        this.passenger = passenger;
    }

    @Override
    public String toString() {
        return super.toString() + " Passenger: " + (passenger ? "Yes" : "No");
    }
}
