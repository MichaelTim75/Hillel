package edu.hillel.lesson23.builderV3;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@Builder
public class Car {
    private final int maxSpeed;
    private final int seats;
    private final double engineVolume;
    private final String color;

}
