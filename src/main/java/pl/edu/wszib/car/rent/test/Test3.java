package pl.edu.wszib.car.rent.test;

import pl.edu.wszib.car.rent.model.Car;

public class Test3 {
    public static void main(String[] args) {
        int x = 5;
        int y = 5;

        System.out.println(x == y);

        Car car = new Car("Toyota",  "Corolla",
                2020,  "Red",  "KR11");
        Car car2 = new Car("Toyota",  "Corolla",
                2020,  "Red",  "KR11");
        //Car car2 = car;

        System.out.println(car.equals(car2));

        String s1 = "ABC";
        String s2 = "ABC";

        System.out.println(s1);
        System.out.println(s2);

        s2 = s2 + "X";

        System.out.println(s1);
        System.out.println(s2);
        Truck.TruckBuilder truckBuilder = new Truck.TruckBuilder();
        truckBuilder.brand("Toyota").model("Corolla");

        //???
        //??

        truckBuilder.year(2020);

        Truck t = truckBuilder.build();

    }
}
