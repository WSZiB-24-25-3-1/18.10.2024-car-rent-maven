package pl.edu.wszib.car.rent.model;

import lombok.*;

@Getter
@Setter
public class Car extends Vehicle {
    public Car(String brand, String model, int year,
               String color, String plate) {
        super(brand, model, year, color, plate, false);
    }
}
