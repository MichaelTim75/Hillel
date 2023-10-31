package edu.hillel.lesson9.variant_3;

import edu.hillel.lesson9.Apple;
import edu.hillel.lesson9.Orange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Box<Apple> appleBox = new Box<>();
        //add two apples one-by-one
        appleBox.fruitAdd(new Apple());
        appleBox.fruitAdd(new Apple());

        //add four apples by array
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple());
        apples.add(new Apple());
        apples.add(new Apple());
        apples.add(new Apple());

        appleBox.fruitsAdd(apples);

        System.out.println(appleBox);
        System.out.println("Apple box - count: "+appleBox.getCount()+", total weight: "+appleBox.getWeight());

        Box<Orange> orangeBox = new Box<>();
        //add three oranges one-by-one
        orangeBox.fruitAdd(new Orange());
        orangeBox.fruitAdd(new Orange());
        orangeBox.fruitAdd(new Orange());

        //add five oranges by array (through Arrays.asList
        List<Orange> oranges = new ArrayList<>(Arrays.asList(new Orange(),new Orange(),new Orange(),new Orange(),new Orange()));
        orangeBox.fruitsAdd(oranges);

        System.out.println(orangeBox);
        System.out.println("Orange box - count: "+orangeBox.getCount()+", total weight: "+orangeBox.getWeight());

        //compare two boxes - need get false
        System.out.println("comparing two boxes. Result is "+appleBox.compare(orangeBox));

        //add one orange to second box in order to get equal weight
        orangeBox.fruitAdd(new Orange());

        //compare two boxes - need get true
        System.out.println("comparing two boxes. Result is "+appleBox.compare(orangeBox));

        //Create another box of apple (with three apples)
        Box<Apple> appleBox1 = new Box<>();
        appleBox1.fruitAdd(new Apple());
        appleBox1.fruitAdd(new Apple());
        appleBox1.fruitAdd(new Apple());

        System.out.println("Before 2 merge");
        System.out.println("Apple box - count: "+appleBox.getCount()+", total weight: "+appleBox.getWeight());
        System.out.println("Apple box 1 - count: "+appleBox1.getCount()+", total weight: "+appleBox1.getWeight());
        appleBox.merge(appleBox1);
        System.out.println("After 2 merge");
        System.out.println("Apple box - count: "+appleBox.getCount()+", total weight: "+appleBox.getWeight());
        System.out.println("Apple box 1 - count: "+appleBox1.getCount()+", total weight: "+appleBox1.getWeight());

    }
}
