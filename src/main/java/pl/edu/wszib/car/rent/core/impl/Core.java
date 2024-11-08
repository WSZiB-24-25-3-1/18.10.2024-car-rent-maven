package pl.edu.wszib.car.rent.core.impl;

import pl.edu.wszib.car.rent.authentication.impl.Authenticator;
import pl.edu.wszib.car.rent.authentication.IAuthenticator;
import pl.edu.wszib.car.rent.core.ICore;
import pl.edu.wszib.car.rent.db.IVehicleRepository;
import pl.edu.wszib.car.rent.db.impl.VehicleRepository;
import pl.edu.wszib.car.rent.gui.impl.GUI;
import pl.edu.wszib.car.rent.gui.IGUI;

public class Core implements ICore {
    private IVehicleRepository vehicleRepository = VehicleRepository.getInstance();
    private IGUI gui = GUI.getInstance();
    private IAuthenticator authenticator = Authenticator.getInstance();
    private static final Core instance = new Core();

    private Core() {
    }

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
                    this.gui.showResultMessage(this.vehicleRepository.rentVehicle(this.gui.readPlate()));
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

    public static Core getInstance() {
        return instance;
    }
}
