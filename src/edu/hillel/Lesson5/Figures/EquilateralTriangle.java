package edu.hillel.Lesson5.Figures;

public class EquilateralTriangle implements Figure{

    final private double side;

    public EquilateralTriangle(double side) {
        this.side = side;
    }

    @Override
    public double getSquare() {
        return Math.pow(side,2)*Math.sqrt(side);
    }

    @Override
    public String toString() {
        return "Equilateral triangle {side="+side+"}";
    }
}
