package edu.hillel.lesson23.builder;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@NoArgsConstructor
@ToString
public class SportCar {
    private int maxSpeed;
    private int seats;
    private double engineVolume;
    private String color;
}
