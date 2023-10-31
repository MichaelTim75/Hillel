package edu.hillel.lesson23.builder;

public interface Builder {
    void createNew();
    void setMaxSpeed(int maxSpeed);
    void setSeats(int seats);
    void setEngineVolume(double engineVolume);
    void setColor(String color);

}
