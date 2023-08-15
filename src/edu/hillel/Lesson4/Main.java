package edu.hillel.Lesson4;

import edu.hillel.Lesson3.Car.Car;

public class Main {
    public static void main(String[] args) {
        Counter counter=new Counter();
        Dog dogBobik=new Dog(counter,"Бобик");
        dogBobik.run(10);
        dogBobik.swim(150);

        Dog dogBarbos=new Dog(counter,"Барбос");
        dogBarbos.run(250);
        dogBarbos.swim(10);

        Cat catZhuzha=new Cat(counter,"Жужа");
        catZhuzha.run(10);
        catZhuzha.swim(10);

        Cat catMurka=new Cat(counter,"Мурка");
        catMurka.run(250);
        catMurka.swim(150);

        System.out.println("Animals count="+counter.getAnimalsCount());
        System.out.println("Dogs count="+counter.getDogsCount());
        System.out.println("Cats count="+counter.getCatsCount());
    }
}
