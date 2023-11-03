package edu.hillel.lesson23.builderV2;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Car {
    private final int maxSpeed;
    private final int seats;
    private final double engineVolume;
    private final String color;

    public Car(CarBuilder carBuilder) {
        this.maxSpeed = carBuilder.maxSpeed;
        this.seats = carBuilder.seats;
        this.engineVolume = carBuilder.engineVolume;
        this.color = carBuilder.color;
    }

    public static class CarBuilder
    {
        private  int maxSpeed;//optional
        private  int seats;//optional
        private final double engineVolume;//requirement
        private  String color;//optional

        public CarBuilder(double engineVolume) {
            this.engineVolume = engineVolume;
        }
        public CarBuilder maxSpeed(int maxSpeed) {
            this.maxSpeed = maxSpeed;
            return this;
        }
        public CarBuilder seats(int seats) {
            this.seats = seats;
            return this;
        }
        public CarBuilder color(String color) {
            this.color = color;
            return this;
        }

        public Car build() {
            return new Car(this);
        }

    }
}
