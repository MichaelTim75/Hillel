package edu.hillel.Lesson9;

import java.util.UUID;

public abstract class Fruit {

    final private UUID id; //I added id to each fruit - each of type uuid - in order to do it unique.

    public Fruit() {
        id=UUID.randomUUID();
    }

    public abstract double getWeight() ;

    public UUID getId() {
        return id;
    }
}
