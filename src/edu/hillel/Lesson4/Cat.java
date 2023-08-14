package edu.hillel.Lesson4;

public class Cat extends Animal{

    public Cat(Counter counter,String name) {
        super(counter,name,200,0);
        counter.catIncrement();
    }

    @Override
    public String toString() {
        return "Cat"+getName();
    }
}
