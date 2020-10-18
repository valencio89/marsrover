package com.lme.robot;

import com.lme.rover.Coordinates;
import com.lme.rover.Rover;
import org.apache.commons.math3.util.Precision;

import java.math.BigDecimal;

/**
 * A generic Rover which can move by any amount (not just by a single unit) at any angle
 */
public abstract class Robot implements Rover {
    private String name;
    private Coordinates coordinates;

    public Robot(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }

    @Override
    public void turn(double angle) {
        coordinates.addTheta(angle);
    }

    @Override
    public void move(double distance) {
        double angle = coordinates.getTheta();
        double radians = Math.toRadians(angle);

        double x = distance * Math.cos(radians);
        x = Precision.round(x, 8, BigDecimal.ROUND_DOWN);

        double y = distance * Math.sin(radians);
        y = Precision.round(y, 8, BigDecimal.ROUND_DOWN);

        coordinates.addX(x);
        coordinates.addY(y);
    }

    @Override
    public String tellCoordinates() {
        StringBuilder s = new StringBuilder();
        s.append(coordinates.getX());
        s.append(" ");
        s.append(coordinates.getY());
        s.append(" ");
        s.append(coordinates.getTheta());
        return s.toString();
    }

    public double getX() {
        return coordinates.getX();
    }

    public double getY() {
        return coordinates.getY();
    }

    public double getTheta() {
        return coordinates.getTheta();
    }


}
