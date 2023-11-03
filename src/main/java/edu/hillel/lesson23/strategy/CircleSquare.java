package edu.hillel.lesson23.strategy;

public class CircleSquare implements SquareStrategy {
    @Override
    public double getSquare(int a) {
        return 1d*a*a*Math.PI;
    }
}
