package edu.hillel.lesson14;

import java.util.Objects;

public class Order {
    private final String name;
    private final int number;

    public Order(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
