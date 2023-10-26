package edu.hillel.lesson23.factory;

public class WoodFactory implements FactoryI {
    @Override
    public BedI createBed() {
        return new WoodBed();
    }

    @Override
    public TableI createTable() {
        return new WoodTable();
    }
}
