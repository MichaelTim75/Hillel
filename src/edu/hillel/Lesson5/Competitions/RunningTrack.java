package edu.hillel.Lesson5.Competitions;

public class RunningTrack implements Barrier{
    final private double length;

    public RunningTrack(double length) {
        this.length = length;
    }

    @Override
    public boolean overcome(double threshold) {
        return (threshold>=length);
    }

    public double getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "RunningTrack{" +
                "length=" + length +
                '}';
    }
}
