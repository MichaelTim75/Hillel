package edu.hillel.Lesson4;

public class Dog extends Animal{

    final static int RUN_THRESHOLD=200;
    final static int SWIM_THRESHOLD=10;

    public Dog(Counter counter,String name) {
        super(counter,name,RUN_THRESHOLD,SWIM_THRESHOLD);
        counter.dogIncrement();
    }

    @Override
    public String toString() {
        return "Dog "+getName();
    }
}
