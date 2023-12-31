package edu.hillel.lesson8;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Main {
    public static void main(String[] args) {

        ArrayValueCalculator arrayValueCalculator=new ArrayValueCalculator();
        //demonstration of ArraySizeException
        String[][] arr={{"12","24","48","7"},{"12","5","3","99"},{"1","2","as","7"},{"12","24","as","7","22"}};
        try {
            System.out.println("Result of total sum in dimension is "+arrayValueCalculator.doCalc(arr));
        } catch (ArraySizeException|ArrayDataException e) {
            System.out.println("Throwed exception "+e.getClass()+", message = "+e.getMessage());
            printStackTrace(e);
        }
        catch (Exception e){
            System.out.println("Got an exception of "+e.getClass());
            printStackTrace(e);
        }

        //demonstration of ArrayDataException
        String[][] arr2={{"12","24","48","7"},{"12","5","3","99"},{"1","2","as","7"},{"12","24","as","7"}};
        try {
            System.out.println("Result of total sum in dimension is "+arrayValueCalculator.doCalc(arr2));
        } catch (ArraySizeException|ArrayDataException e) {
            System.out.println("Throwed exception "+e.getClass()+", message = "+e.getMessage());
            printStackTrace(e);
        }
        catch (Exception e){
            System.out.println("Got an exception of "+e.getClass());
            printStackTrace(e);
        }

        //correct version
        String[][] arr3={{"12","24","48","7"},{"12","5","3","99"},{"1","2","5","7"},{"12","24","96","7"}};
        try {
            System.out.println("Result of total sum in dimension is "+arrayValueCalculator.doCalc(arr3));
        } catch (ArraySizeException|ArrayDataException e) {
            System.out.println("Throwed exception "+e.getClass()+", message = "+e.getMessage());
            printStackTrace(e);
        }
        catch (Exception e){
            System.out.println("Got an exception of "+e.getClass());
            printStackTrace(e);
        }

        //throw Exception
        String[][] arr4={};
        try {
            System.out.println("Result of total sum in dimension is "+arrayValueCalculator.doCalc(arr4));
        } catch (ArraySizeException|ArrayDataException e) {
            System.out.println("Throwed exception "+e.getClass()+", message = "+e.getMessage());
            printStackTrace(e);
        }
        catch (Exception e){
            System.out.println("Got an exception of "+e.getClass());
            printStackTrace(e);
        }

        //throws division by zero
        String[][] arr5={{"12","24","48","7"},{"1","0","3","99"},{"1","2","5","7"},{"12","24","96","7"}};
        try {
            System.out.println("Result of total sum in dimension is "+arrayValueCalculator.doCalc(arr5));
        } catch (ArraySizeException|ArrayDataException e) {
            System.out.println("Throwed exception "+e.getClass()+", message = "+e.getMessage());
            printStackTrace(e);
        }
        catch (Exception e){
            System.out.println("Got an exception of "+e.getClass());
            printStackTrace(e);
        }

    }

    private static void printStackTrace(Exception e){
        StringWriter stringWriter=new StringWriter();
        PrintWriter printWriter=new PrintWriter(stringWriter);
        e.printStackTrace(printWriter);
        System.out.println(stringWriter.toString());
    }
}
