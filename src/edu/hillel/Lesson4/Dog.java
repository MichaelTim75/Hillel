package edu.hillel.Lesson4;

public class Dog extends Animal{


    public Dog(Counter counter,String name) {
        super(counter,name,200,10);
        counter.dogIncrement();
    }

    @Override
    public String toString() {
        return "Dog "+getName();
    }
}
