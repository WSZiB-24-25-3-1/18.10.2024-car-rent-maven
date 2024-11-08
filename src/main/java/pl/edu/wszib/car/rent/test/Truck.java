package pl.edu.wszib.car.rent.test;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@EqualsAndHashCode
//@Log4j2
public class Truck {
    private String brand;
    private String model;
    private int year;
    private String color;
    private String plate;
    private boolean rent;
    private int capacity;
}
