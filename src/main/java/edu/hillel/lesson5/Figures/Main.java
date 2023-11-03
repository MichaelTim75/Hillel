package edu.hillel.lesson5.Figures;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Figure> figures = new ArrayList<>();

        Circle circle1=new Circle(15);
        figures.add(circle1);
        Circle circle2=new Circle(25);
        figures.add(circle2);

        EquilateralTriangle triangle1=new EquilateralTriangle(15);
        figures.add(triangle1);
        EquilateralTriangle triangle2=new EquilateralTriangle(25);
        figures.add(triangle2);

        Square square1=new Square(15);
        figures.add(square1);
        Square square2=new Square(25);
        figures.add(square2);

        double totalSquare=0;
        double square;
        for(Figure figure:figures){
            square=figure.getSquare();
            System.out.println("figure "+figure+", square="+square);
            totalSquare+=square;
        }
        System.out.println("total square="+totalSquare);
    }
}
