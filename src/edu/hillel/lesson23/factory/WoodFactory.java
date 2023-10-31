package edu.hillel.lesson23.factory;

public class WoodFactory implements Factory {
    @Override
    public Bed createBed() {
        return new WoodBed();
    }

    @Override
    public Table createTable() {
        return new WoodTable();
    }
}
