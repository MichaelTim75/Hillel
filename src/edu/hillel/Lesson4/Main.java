package edu.hillel.Lesson4;

import edu.hillel.Lesson3.Car.Car;

public class Main {
    public static void main(String[] args) {
        Counter counter=new Counter();
        Dog dogBobik=new Dog(counter,"Бобик");
        dogBobik.Run(10);
        dogBobik.Swim(150);

        Dog dogBarbos=new Dog(counter,"Барбос");
        dogBarbos.Run(250);
        dogBarbos.Swim(10);

        Cat catZhuzha=new Cat(counter,"Жужа");
        catZhuzha.Run(10);
        catZhuzha.Swim(10);

        Cat catMurka=new Cat(counter,"Мурка");
        catMurka.Run(250);
        catMurka.Swim(150);

        System.out.println("Animals count="+counter.getAnimalsCount());
        System.out.println("Dogs count="+counter.getDogsCount());
        System.out.println("Cats count="+counter.getCatsCount());
    }
}
