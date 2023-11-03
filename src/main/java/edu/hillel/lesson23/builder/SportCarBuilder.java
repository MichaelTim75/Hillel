package edu.hillel.lesson23.builder;

import lombok.Getter;

@Getter
public class SportCarBuilder implements Builder {
    private SportCar car;

    @Override
    public void createNew() {
        car = new SportCar();
    }

    @Override
    public void setMaxSpeed(int maxSpeed) {
        car.setMaxSpeed(maxSpeed);
    }

    @Override
    public void setSeats(int seats) {
        car.setSeats(seats);
    }

    @Override
    public void setEngineVolume(double engineVolume) {
        car.setEngineVolume(engineVolume);
    }

    @Override
    public void setColor(String color) {
        car.setColor(color);
    }


}
