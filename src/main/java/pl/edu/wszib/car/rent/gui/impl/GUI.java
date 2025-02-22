package pl.edu.wszib.car.rent.gui.impl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import pl.edu.wszib.car.rent.db.IVehicleRepository;
import pl.edu.wszib.car.rent.db.impl.sql.VehicleRepositorySQL;
import pl.edu.wszib.car.rent.gui.IGUI;
import pl.edu.wszib.car.rent.model.User;
import pl.edu.wszib.car.rent.model.Vehicle;

import java.util.Scanner;

@RequiredArgsConstructor
@Component
public class GUI implements IGUI {

    private final Scanner scanner;
    private final IVehicleRepository vehicleRepository;

    @Override
    public String showMenuAndReadChoice() {
        System.out.println("1. List vehicles");
        System.out.println("2. Rent vehicle");
        System.out.println("3. Exit");

        return this.scanner.nextLine();
    }

    @Override
    public void listVehicles() {
        for(Vehicle vehicle : this.vehicleRepository.getAll()) {
            System.out.println(vehicle);
        }
    }

    @Override
    public String readPlate() {
        System.out.println("Enter plate:");
        return this.scanner.nextLine();
    }

    @Override
    public void showResultMessage(boolean result) {
        System.out.println(result ? "Success !!" : "Error !!");
    }

    @Override
    public User aksForCredentials() {
        User user = new User();
        System.out.println("Enter login:");
        user.setLogin(this.scanner.nextLine());
        System.out.println("Enter password:");
        user.setPassword(this.scanner.nextLine());
        return user;
    }
}
