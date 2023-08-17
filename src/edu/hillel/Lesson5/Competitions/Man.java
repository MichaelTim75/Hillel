package edu.hillel.Lesson5.Competitions;

public class Man implements Participant{
    private final double runBarrierThreshold;
    private final double jumpBarrierThreshold;

    public Man(double runBarrierThreshold, double jumpBarrierThreshold) {
        this.runBarrierThreshold = runBarrierThreshold;
        this.jumpBarrierThreshold = jumpBarrierThreshold;
    }

    @Override
    public double getRunBarrierThreshold() {
        return runBarrierThreshold;
    }

    @Override
    public double getJumpBarrierThreshold() {
        return jumpBarrierThreshold;
    }

    @Override
    public void run() {
        System.out.println(this+" runs");
    }

    @Override
    public void jump() {
        System.out.println(this+" jumps");
    }

    @Override
    public String toString() {
        return "Man {" +
                "runBarrierThreshold=" + runBarrierThreshold +
                ", jumpBarrierThreshold=" + jumpBarrierThreshold +
                '}';
    }
}
