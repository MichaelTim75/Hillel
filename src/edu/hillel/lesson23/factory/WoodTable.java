package edu.hillel.lesson23.factory;

public class WoodTable implements TableI {
    @Override
    public String getMaterial() {
        return "I made from wood";
    }

    @Override
    public int getLegsCount() {
        return 4;
    }
}
