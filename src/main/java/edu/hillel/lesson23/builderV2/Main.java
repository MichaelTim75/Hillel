package edu.hillel.lesson23.builderV2;

public class Main {
    public static void main(String[] args) {

        Car car1 = new Car.CarBuilder(1.5d)
                .seats(4)
                .color("white")
                .maxSpeed(100)
                .build();
        System.out.println(car1);

        //without maxspeed and seats
        Car car2 = new Car.CarBuilder(2.5d)
                .color("red")
                .build();
        System.out.println(car2);
    }
}
