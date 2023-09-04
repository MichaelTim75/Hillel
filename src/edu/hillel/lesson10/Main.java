package edu.hillel.lesson10;

import edu.hillel.MathMethods;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;

import static edu.hillel.MathMethods.*;

public class Main {
    public static void main(String[] args) {

        //getting random int in a range without getting an Exception and with getting
        try {
            System.out.println("Random int in a range 1-16:"+intRandomInRange(1,16));
            System.out.println("Random int in a range 16-1:"+intRandomInRange(16,1));
        } catch (MathMethods.NonCorrectRangeException e) {
            System.out.println("Got an exception of "+e.getClass());
            printStackTrace(e);
        }

        //multiplication
        System.out.println("1.12*6.3="+Multiplication(BigDecimal.valueOf(1.12), BigDecimal.valueOf(6.3)));
        //addition
        System.out.println("1.3+5="+Addition(BigDecimal.valueOf(1.3),BigDecimal.valueOf(5d)));
        //subtraction
        System.out.println("18-5.12="+Subtraction(BigDecimal.valueOf(18d),BigDecimal.valueOf(5.12)));
    }

    private static void printStackTrace(Exception e){
        StringWriter stringWriter=new StringWriter();
        PrintWriter printWriter=new PrintWriter(stringWriter);
        e.printStackTrace(printWriter);
        System.out.println(stringWriter.toString());
    }

}
