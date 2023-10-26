package edu.hillel.lesson23.factory;

public class MetalFactory implements FactoryI {
    @Override
    public BedI createBed() {
        return new MetalBed();
    }

    @Override
    public TableI createTable() {
        return new MetalTable();
    }
}
