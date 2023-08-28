package edu.hillel.Lesson8;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        ArrayValueCalculator arrayValueCalculator=new ArrayValueCalculator();
        //demonstration of ArraySizeException
        String[][] arr={{"12","24","48","7"},{"12","5","3","99"},{"1","2","as","7"},{"12","24","as","7","22"}};
        try {
            System.out.println("Result of total sum in dimension is "+arrayValueCalculator.doCalc(arr));
        } catch (ArraySizeException|ArrayDataException e) {
            System.out.println("Throwed exception "+e.getClass()+", message = "+e.getMessage());
        }

        //demonstration of ArrayDataException
        String[][] arr2={{"12","24","48","7"},{"12","5","3","99"},{"1","2","as","7"},{"12","24","as","7"}};
        try {
            System.out.println("Result of total sum in dimension is "+arrayValueCalculator.doCalc(arr2));
        } catch (ArraySizeException|ArrayDataException e) {
            System.out.println("Throwed exception "+e.getClass()+", message = "+e.getMessage());
        }

        //correct version
        String[][] arr3={{"12","24","48","7"},{"12","5","3","99"},{"1","2","5","7"},{"12","24","96","7"}};
        try {
            System.out.println("Result of total sum in dimension is "+arrayValueCalculator.doCalc(arr3));
        } catch (ArraySizeException|ArrayDataException e) {
            System.out.println("Throwed exception "+e.getClass()+", message = "+e.getMessage());
        }

    }

}
