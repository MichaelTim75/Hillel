package edu.hillel.Lesson9.Variant_2_better;

import edu.hillel.Lesson9.Apple;
import edu.hillel.Lesson9.Fruit;
import edu.hillel.Lesson9.Orange;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) {

        Box<Fruit> appleBox = new Box<>();
        //add two apples one-by-one
        appleBox.fruitAdd(new Apple());
        appleBox.fruitAdd(new Apple());
        appleBox.fruitAdd(new Orange());

        System.out.println(appleBox);
        System.out.println("Apple box - count: "+appleBox.getCount()+", total weight: "+appleBox.getWeight());

        //add four apples by array
        List<Fruit> apples = new CopyOnWriteArrayList<>();
        apples.add(new Apple());
        apples.add(new Apple());
        apples.add(new Apple());
        apples.add(new Apple());

        appleBox.fruitsAdd(apples);

        System.out.println(appleBox);
        System.out.println("Apple box - count: "+appleBox.getCount()+", total weight: "+appleBox.getWeight());

        Box<Fruit> orangeBox = new Box<>();
        //add three oranges one-by-one
        orangeBox.fruitAdd(new Orange());
        orangeBox.fruitAdd(new Orange());
        orangeBox.fruitAdd(new Orange());

        //add five oranges by array (through Arrays.asList
        List<Fruit> oranges = new CopyOnWriteArrayList<>(Arrays.asList(new Orange(),new Orange(),new Orange(),new Orange(),new Orange()));
        orangeBox.fruitsAdd(oranges);

        System.out.println(orangeBox);
        System.out.println("Orange box - count: "+orangeBox.getCount()+", total weight: "+orangeBox.getWeight());

        //compare two boxes - need get false
        System.out.println("comparing two boxes. Result is "+appleBox.compare(orangeBox));

        //add one orange to second box in order to get equal weight
        orangeBox.fruitAdd(new Orange());

        //compare two boxes - need get true
        System.out.println("comparing two boxes. Result is "+appleBox.compare(orangeBox));

        appleBox.merge(orangeBox);
        System.out.println("After merge");
        System.out.println("Apple box - count: "+appleBox.getCount()+", total weight: "+appleBox.getWeight());
        System.out.println("OrangeBox - count: "+orangeBox.getCount()+", total weight: "+orangeBox.getWeight());

        //Create another box of apple (with three apples)
        Box<Fruit> appleBox1 = new Box<>();
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

        //self-merging
        //It was interesting to do self-merge. But with ArrayList I got an ConcurrentModificationException
        // After googling I found that in this case (or in case of multithreading - we need to use CopyOnWriteArrayList
        //Then I've gotten a successfully self-merge
        System.out.println("Before self merge");
        System.out.println("Apple box - count: "+appleBox.getCount()+", total weight: "+appleBox.getWeight());
        appleBox.merge(appleBox);
        System.out.println("After self merge");
        System.out.println("Apple box - count: "+appleBox.getCount()+", total weight: "+appleBox.getWeight());

    }
}
