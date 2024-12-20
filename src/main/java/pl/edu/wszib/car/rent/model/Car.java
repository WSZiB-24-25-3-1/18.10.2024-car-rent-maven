package pl.edu.wszib.car.rent.model;

public class Car extends Vehicle {
    public Car(int id, String brand, String model, int year, String color, String plate) {
        super(id, brand, model, year, color, plate);
    }

    public Car(int id, String brand, String model, int year, String color, String plate, boolean rent) {
        super(id, brand, model, year, color, plate, rent);
    }

    public Car() {
    }
}
