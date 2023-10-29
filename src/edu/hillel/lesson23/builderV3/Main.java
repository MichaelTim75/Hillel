package edu.hillel.lesson23.builderV3;

public class Main {
    public static void main(String[] args) {

        Car car1 = Car
                .builder()
                .engineVolume(1.5d)
                .seats(4)
                .color("white")
                .maxSpeed(100)
                .build();
        System.out.println(car1);

        //without maxspeed and seats
        Car car2 = Car
                .builder()
                .engineVolume(2.5d)
                .color("red")
                .build();
        System.out.println(car2);
    }
}
