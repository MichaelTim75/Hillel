package edu.hillel.Lesson9;

public class Apple extends Fruit{
    private final static double WEIGHT=1.5; //constant weight of each apple
    @Override
    public double getWeight() {
        return WEIGHT;
    }

}
