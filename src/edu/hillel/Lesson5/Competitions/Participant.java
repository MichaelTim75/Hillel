package edu.hillel.Lesson5.Competitions;

public interface Participant {
    void run();
    void jump();
    double getRunBarrierThreshold();
    double getJumpBarrierThreshold();
    String toString();
}
