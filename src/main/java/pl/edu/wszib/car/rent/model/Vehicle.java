package pl.edu.wszib.car.rent.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    private String brand;
    private String model;
    private int year;
    private String color;
    private String plate;
    private boolean rent;

    @Override
    public String toString() {
        return new StringBuilder().append(this.getBrand())
                .append(" ")
                .append(this.getModel())
                .append(" ")
                .append(this.getColor())
                .append(" ")
                .append(this.getYear())
                .append(" ")
                .append(this.getPlate())
                .append(" ")
                .append(this.isRent() ? "Not Available" : "Available")
                .toString();
    }
}
