package edu.hillel.lesson23.strategy;

public class Main {
    public static void main(String[] args) {
        SquareGetter squareGetter = new SquareGetter();
        //1 circle
        squareGetter.setSquareStrategy(new CircleSquare());
        System.out.println(squareGetter.getSquare(5));

        //2 square
        squareGetter.setSquareStrategy(new SquareSquare());
        System.out.println(squareGetter.getSquare(5));

        //3 EquilateralTriangle
        squareGetter.setSquareStrategy(new EquilateralTriangleSquare());
        System.out.println(squareGetter.getSquare(5));
    }
}
