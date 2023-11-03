package edu.hillel.lesson23.factory;

public class MetalFactory implements Factory {
    @Override
    public Bed createBed() {
        return new MetalBed();
    }

    @Override
    public Table createTable() {
        return new MetalTable();
    }
}
