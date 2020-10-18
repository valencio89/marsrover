package com.lme.rover;

/**
 * Cooardinates class is designed keeping in mind the extensibility.
 * It can be used by any rover which may have an ability to turn at any angle (not just 90 degree)
 * and can move by any amount (not just by a single unit)
 * TODO : the double fields should be switched to BigDecimal
 */

public class Coordinates {
    private double x;
    private double y;
    private double theta;

    public Coordinates() {
        this(0, 0, 0);
    }

    public Coordinates(double x, double y, double theta) {
        this.x = x;
        this.y = y;
        this.theta = theta;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getTheta() {
        return theta;
    }

    public void addX(double x) {
        this.x = this.x + x;
    }

    public void addY(double y) {
        this.y = this.y + y;
    }

    public void addTheta(double theta) {
        this.theta = this.theta + theta;
    }

}
