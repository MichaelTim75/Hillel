package edu.hillel.lesson9.variant_1;

import edu.hillel.lesson9.Fruit;

import java.util.ArrayList;
import java.util.Objects;

public class Box <T extends Fruit>{
    private final ArrayList<T> fruits;
    final private T fruitType;

    public Box(T fruitType) {
        fruits=new ArrayList<>();
        this.fruitType=fruitType;
    }

    public ArrayList<T> getFruits() {
        return fruits;
    }

    public void fruitAdd (T fruitToAdd) {
        fruits.add(fruitToAdd);
    }

    public void fruitsAdd(ArrayList<T> fruitsToAdd){
        fruits.addAll(fruitsToAdd);
    }
    public void fruitsAddIter(ArrayList<T> fruitsToAdd){
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

    public void merge(Box<? extends Fruit> box){
        if (box.fruits.isEmpty()) {
            System.out.println("Input box is empty! Nothing to merge");
        }
        else if (!compareFruitTypes(box)) {
            System.out.println("Input box is a different type of fruits! We can't merge different fruits");
        }
        else{
            fruits.addAll((ArrayList<T>)box.getFruits());
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

    public T getFruitType() {
        return fruitType;
    }

    private boolean compareFruitTypes(Box<? extends Fruit> o) {
        return (getFruitType().getClass()==o.getFruitType().getClass());
    }
}
