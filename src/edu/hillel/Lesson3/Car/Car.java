package edu.hillel.Lesson3.Car;

public class Car {
    public Car() {
    }

    public void start(){
        startElectricity();
        startCommand();
        startFuelSystem();
    }
    private void startElectricity(){
        System.out.println("Electricity started!");
    }
    private void startCommand(){
        System.out.println("Command Started!");
    }

    private void startFuelSystem(){
        System.out.println("Fuel System started!");
    }
}
