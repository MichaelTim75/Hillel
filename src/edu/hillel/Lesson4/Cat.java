package edu.hillel.Lesson4;

public class Cat extends Animal{

    static int RUN_THRESHOLD=200;
    static int SWIM_THRESHOLD=0;
    public Cat(Counter counter,String name) {
        super(counter,name,RUN_THRESHOLD,SWIM_THRESHOLD);
        counter.catIncrement();
    }

    @Override
    public String toString() {
        return "Cat "+getName();
    }
}
