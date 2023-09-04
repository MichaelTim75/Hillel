package edu.hillel.lesson9.Variant_2_better;

import edu.hillel.lesson9.Fruit;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

public class Box <T extends Fruit> {
    private final List<T> fruits;

    public Box() {
        this.fruits=new CopyOnWriteArrayList<>();
    }

    public List<T> getFruits() {
        return fruits;
    }

    private boolean isFruitValid(T fruit){
        //this method give us answer - valid this fruit for this box or not.
        //if box is empty or if class of it == class of first element
        return fruits.isEmpty() || fruits.get(0).getClass()==fruit.getClass();
    }

    public boolean fruitAdd (T fruitToAdd) {
        boolean needAdd=(isFruitValid(fruitToAdd) && !fruits.contains(fruitToAdd)); //we don't add fruit if it exists in this box.
        if (needAdd) {
            fruits.add(fruitToAdd);
        }
        else {
            System.out.println("Fruit is not valid. Skip");
        }
        return needAdd;//return true if we have added new fruit
    }

    public int fruitsAdd(List<T> fruitsToAdd){
        int i=0;
        for (T fruit : fruitsToAdd) {
            if (fruitAdd(fruit)) i+=1;
        }
        return i;//return count of added fruits
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
            int countAdded=this.fruitsAdd(box.getFruits());
            if (countAdded>0) {
                box.fruitsRemoveAll();//if we successfully merge fruits from source box - we clear source box.
            }
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
