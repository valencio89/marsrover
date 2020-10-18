package com.lme.rover;

public interface Rover {
    void turn(double angle);

    void move(double distance);

    String tellCoordinates();
}
