package edu.hillel.lesson4;

public class Counter {
    private int animalsCount;
    private int catsCount;
    private int dogsCount;

    public Counter() {
        dogsCount=0;
        animalsCount=0;
        catsCount=0;
    }

    public void animalIncrement(){
        ++animalsCount;
    }

    public void dogIncrement(){
        ++dogsCount;
    }

    public void catIncrement(){
        ++catsCount;
    }

    public int getAnimalsCount() {
        return animalsCount;
    }

    public void setAnimalsCount(int animalsCount) {
        this.animalsCount = animalsCount;
    }

    public int getCatsCount() {
        return catsCount;
    }

    public void setCatsCount(int catsCount) {
        this.catsCount = catsCount;
    }

    public int getDogsCount() {
        return dogsCount;
    }

    public void setDogsCount(int dogsCount) {
        this.dogsCount = dogsCount;
    }
}
