package com.lme.robot.mars;

import com.lme.robot.Robot;
import com.lme.rover.Coordinates;

/**
 * MarsRover - a specific Rover which can only move by a single unit and
 * turn by only 90 degrees
 */
public class MarsRobot extends Robot {
    private final MarsGrid marsGrid;
    private boolean isLost = false;

    private MarsRobot(String name, Coordinates coordinates, MarsGrid marsGrid) {
        super(name, coordinates);
        this.marsGrid = marsGrid;
    }

    public static MarsRobot init(String name, Coordinates coordinates, MarsGrid marsGrid) {
        return new MarsRobot(name, coordinates, marsGrid);
    }

    @Override
    public void turn(double angle) {
        if ((angle == 90) || (angle == -90))
            super.turn(angle);
        else
            throw new IllegalArgumentException();
    }



    public boolean isLost() {
        return this.isLost;
    }

}
