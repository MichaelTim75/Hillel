package edu.hillel.Lesson9.Variant_3;

import edu.hillel.Lesson9.Fruit;

import java.util.ArrayList;
import java.util.Objects;
import java.util.List;

public class Box <T extends Fruit>{
    private final List<T> fruits;

    public Box() {
        fruits=new ArrayList<>();
    }

    public List<T> getFruits() {
        return fruits;
    }

    public void fruitAdd (T fruitToAdd) {
        fruits.add(fruitToAdd);
    }

    public void fruitsAdd(List<T> fruitsToAdd){
        fruits.addAll(fruitsToAdd);
    }
    public void fruitsAddIter(List<T> fruitsToAdd){
        //second type of method using iteration and method of add by one
        for (T fruit : fruitsToAdd) {
            fruitAdd(fruit);
        }
    }
    public void fruitsRemoveAll(){
        fruits.clear();
    }
    public double getWeight() {
        double totalWeight=0;
        for (T fruit : fruits) {
            totalWeight += fruit.getWeight();
        }
        return totalWeight;
    }

    public int getCount(){
        return fruits.size();
    }

    public boolean compare(Box<?> box){
        return (getWeight()==box.getWeight());
    }

    public void merge(Box<T> box){
        if (box.fruits.isEmpty()) {
            System.out.println("Input box is empty! Nothing to merge");
        }
        else{
            fruits.addAll((List<T>)box.getFruits());
            box.fruitsRemoveAll();
        }

    }
    @Override
    public String toString() {
        //override toString in order to print list of ids
        return "Box {" +
                "fruits=" + fruits.stream().map(Fruit::getId).toList() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Box<?> box = (Box<?>) o;
        return fruits.equals(box.fruits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fruits);
    }

}
