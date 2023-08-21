package edu.hillel.Lesson5.Figures;

public class Circle implements Figure{
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getSquare() {
        return Math.PI*Math.pow(radius,2);
    }

    @Override
    public String toString() {
        return "Circle {radius="+radius+"}";
    }
}
