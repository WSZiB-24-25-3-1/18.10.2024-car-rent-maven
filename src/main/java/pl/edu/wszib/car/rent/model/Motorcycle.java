package pl.edu.wszib.car.rent.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Motorcycle extends Vehicle {
    private boolean additionalSeat;

    public Motorcycle(int id, String brand, String model, int year, String color, String plate, boolean rent, boolean additionalSeat) {
        super(id, brand, model, year, color, plate, rent);
        this.additionalSeat = additionalSeat;
    }

    public Motorcycle(int id, String brand, String model, int year, String color, String plate, boolean additionalSeat) {
        super(id, brand, model, year, color, plate);
        this.additionalSeat = additionalSeat;
    }

    public Motorcycle() {
    }

    @Override
    public String toString() {
        return super.toString() +
                " dodatkowe miejsce: " +
                (additionalSeat ? "Tak" : "Nie");
    }
}
