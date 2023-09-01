package edu.hillel.Lesson9;

import java.util.UUID;

public abstract class Fruit {

    final private UUID id;

    public Fruit() {
        id=UUID.randomUUID();
    }

    public abstract double getWeight() ;

    public UUID getId() {
        return id;
    }
}
