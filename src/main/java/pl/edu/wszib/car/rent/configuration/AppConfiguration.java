package pl.edu.wszib.car.rent.configuration;

import org.springframework.context.annotation.*;
import pl.edu.wszib.car.rent.db.ICarRepository;
import pl.edu.wszib.car.rent.db.IMotorcycleRepository;
import pl.edu.wszib.car.rent.db.IVehicleRepository;
import pl.edu.wszib.car.rent.db.impl.sql.VehicleRepositorySQL;

import java.util.Scanner;

@Configuration
@ComponentScan("pl.edu.wszib.car.rent")
public class AppConfiguration {

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }
}
