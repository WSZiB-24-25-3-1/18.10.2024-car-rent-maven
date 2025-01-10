package pl.edu.wszib.car.rent.core.impl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.edu.wszib.car.rent.authentication.impl.Authenticator;
import pl.edu.wszib.car.rent.authentication.IAuthenticator;
import pl.edu.wszib.car.rent.core.ICore;
import pl.edu.wszib.car.rent.db.IVehicleRepository;
import pl.edu.wszib.car.rent.db.impl.sql.VehicleRepositorySQL;
import pl.edu.wszib.car.rent.gui.impl.GUI;
import pl.edu.wszib.car.rent.gui.IGUI;

@RequiredArgsConstructor
@Component
public class Core implements ICore {

    private final IVehicleRepository vehicleRepository;
    private final IGUI gui;
    private final IAuthenticator authenticator;

    @Override
    public void run() {
        boolean running = false;
        int trys = 0;
        while(!running && trys < 3) {
            running = this.authenticator.authenticate(this.gui.aksForCredentials());
            trys++;
        }
        while (running) {
            switch (this.gui.showMenuAndReadChoice()) {
                case "1":
                    this.gui.listVehicles();
                    break;
                case "2":
                    this.gui.showResultMessage(this.vehicleRepository.rent(this.gui.readPlate()));
                    break;
                case "3":
                    running = false;
                    break;
                default:
                    System.out.println("Incorrect choice !!");
                    break;
            }
        }
    }
}
