package edu.hillel.lesson23.factory;

public class MetalBed implements Bed {
    @Override
    public String getMaterial() {
        return "I made from metal";
    }

    @Override
    public boolean isAntic() {
        return false;
    }
}
