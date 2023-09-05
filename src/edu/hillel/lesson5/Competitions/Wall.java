package edu.hillel.lesson5.Competitions;

public class Wall implements Barrier{
    final private double height;

    public Wall(double height) {
        this.height = height;
    }

    @Override
    public boolean overcome(double threshold) {
        return (threshold>=height);
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Wall{" +
                "height=" + height +
                '}';
    }
}
