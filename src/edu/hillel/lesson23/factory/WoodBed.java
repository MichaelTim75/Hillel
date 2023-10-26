package edu.hillel.lesson23.factory;

public class WoodBed implements BedI {
    @Override
    public String getMaterial() {
        return "I made from wood";
    }

    @Override
    public boolean isAntic() {
        return true;
    }
}
