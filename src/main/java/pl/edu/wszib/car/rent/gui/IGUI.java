package pl.edu.wszib.car.rent.gui;

import pl.edu.wszib.car.rent.model.User;

public interface IGUI {
    String showMenuAndReadChoice();
    void listVehicles();
    String readPlate();
    void showResultMessage(boolean result);
    User aksForCredentials();
}
