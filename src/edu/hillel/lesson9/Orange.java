package edu.hillel.lesson9;

public class Orange extends Fruit{
    private final static double WEIGHT=1.0; //constant weight of each orange
    @Override
    public double getWeight() {
        return WEIGHT;
    }
}
