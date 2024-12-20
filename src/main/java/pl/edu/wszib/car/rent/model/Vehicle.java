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
    private int id;
    private String brand;
    private String model;
    private int year;
    private String color;
    private String plate;
    private boolean rent;

    public Vehicle(int id, String brand, String model, int year, String color, String plate) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.plate = plate;
        this.rent = false;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(this.brand)
                .append(" ")
                .append(this.model)
                .append(" Rok: ")
                .append(this.year)
                .append(" Kolor: ")
                .append(this.color)
                .append(" Nr rejestracyjny: ")
                .append(this.plate)
                .append(" Dostepny: ")
                .append(this.rent ? "Nie" : "Tak")
                .toString();
    }
}
