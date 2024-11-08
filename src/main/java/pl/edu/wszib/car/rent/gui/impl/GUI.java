package pl.edu.wszib.car.rent.gui.impl;

import pl.edu.wszib.car.rent.db.IVehicleRepository;
import pl.edu.wszib.car.rent.db.impl.VehicleRepository;
import pl.edu.wszib.car.rent.gui.IGUI;
import pl.edu.wszib.car.rent.model.Car;
import pl.edu.wszib.car.rent.model.Truck;
import pl.edu.wszib.car.rent.model.User;
import pl.edu.wszib.car.rent.model.Vehicle;

import java.util.List;
import java.util.Scanner;

public class GUI implements IGUI {
    private Scanner scanner = new Scanner(System.in);
    private final IVehicleRepository vehicleRepository = VehicleRepository.getInstance();

    private static GUI instance = new GUI();

    private GUI() {
    }

    @Override
    public String showMenuAndReadChoice() {
        System.out.println("1. List vehicles");
        System.out.println("2. Rent vehicle");
        System.out.println("3. Exit");

        return scanner.nextLine();
    }

    @Override
    public void listVehicles() {
        for(Vehicle vehicle : vehicleRepository.getVehicles()) {
            System.out.println(vehicle);
        }
    }

    @Override
    public String readPlate() {
        System.out.println("Enter plate:");
        return scanner.nextLine();
    }

    @Override
    public void showResultMessage(boolean result) {
        System.out.println(result ? "Success !!" : "Error !!");
    }

    @Override
    public User aksForCredentials() {
        User user = new User();
        System.out.println("Enter login:");
        user.setLogin(scanner.nextLine());
        System.out.println("Enter password:");
        user.setPassword(scanner.nextLine());
        return user;
    }

    public static GUI getInstance() {
        return instance;
    }
}
