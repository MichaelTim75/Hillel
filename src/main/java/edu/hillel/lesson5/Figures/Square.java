package edu.hillel.lesson5.Figures;

public class Square implements Figure{
    final private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getSquare() {
        return Math.pow(side,2);
    }

    @Override
    public String toString() {
        return "Square {side="+side+"}";
    }

}
