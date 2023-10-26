package edu.hillel.lesson23.factory;

public class MetalTable implements TableI {
    @Override
    public String getMaterial() {
        return "I made from metal";
    }

    @Override
    public int getLegsCount() {
        return 1;
    }
}
