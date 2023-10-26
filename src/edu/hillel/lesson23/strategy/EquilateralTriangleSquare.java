package edu.hillel.lesson23.strategy;

public class EquilateralTriangleSquare implements SquareStrategy {
    @Override
    public double getSquare(int a) {
        return 1d*a*a*Math.sqrt(3)/4;
    }
}
