package edu.hillel.lesson23.strategy;

public class SquareSquare implements SquareStrategy {
    @Override
    public double getSquare(int a) {
        return 1d*a*a;
    }
}
