package edu.hillel.lesson16;

import java.util.OptionalDouble;
import java.util.stream.LongStream;

public class Main {

    public static void main(String[] args) {
        ValueCalculator valueCalculator = new ValueCalculator();
        valueCalculator.method(true);

        OptionalDouble avgTiming1 = LongStream.rangeClosed(1, 100).
                map(time -> {
                    return valueCalculator.method(true);
                }).average();

        System.out.println("With synchronization, 100 times by 10 million - avg timing is " + avgTiming1.getAsDouble());

        OptionalDouble avgTiming2 = LongStream.rangeClosed(1, 100).
                map(time -> {
                    return valueCalculator.method(false);
                }).average();

        System.out.println("Without synchronization, 100 times by 10 million - avg timing is " + avgTiming2.getAsDouble());

    }
}
