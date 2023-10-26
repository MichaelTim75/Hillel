package edu.hillel.lesson23.builder;

public class Main {
    public static void main(String[] args) {
        CarBuilder carBuilder = new CarBuilder();
        carBuilder.createNew();
        carBuilder.setEngineVolume(1.5d);
        carBuilder.setMaxSpeed(120);
        carBuilder.setColor("white");
        Car car = carBuilder.getCar();
        System.out.println(car);

        SportCarBuilder sportCarBuilder = new SportCarBuilder();
        sportCarBuilder.createNew();
        sportCarBuilder.setSeats(2);
        sportCarBuilder.setEngineVolume(5d);
        sportCarBuilder.setMaxSpeed(350);
        sportCarBuilder.setColor("red");
        SportCar car1 = sportCarBuilder.getCar();
        System.out.println(car1);
    }
}
