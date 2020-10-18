package com.lme.robot;

import com.lme.rover.Coordinates;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RobotTest {
    @Test
    public void roverShouldMoveCorrectlyFromOrigin() {
        Coordinates coor = new Coordinates();

        // create an instance of an anonymous class of Rover abstract class, in order to test its move() method
        Robot robot = new Robot("Rover-A", coor) {
        };

        //turn 45 degree and move 4 units
        robot.turn(45);
        robot.move(4);

        Assertions.assertEquals(2.82842712, robot.getX());
        Assertions.assertEquals(2.82842712, robot.getY());
        Assertions.assertEquals(45, robot.getTheta());
    }

    @Test
    public void roverShouldMoveCorrectlyFromAnywhere() {
        Coordinates coor = new Coordinates(3, 4, 0);

        // create an instance of an anonymous class of Rover abstract class, in order to test its move() method
        Robot robot = new Robot("Rover-A", coor) {
        };

        //turn 30 degree and move 5 units
        robot.turn(30);
        robot.move(5);

        Assertions.assertEquals(7.33012701, robot.getX());
        Assertions.assertEquals(6.49999999, robot.getY());
        Assertions.assertEquals(30, robot.getTheta());
    }

    @Test
    public void roverShouldMoveCorrectlyFromAnywhereFromAnyInitialAngle() {
        Coordinates coor = new Coordinates(3, 4, 30);

        // create an instance of an anonymous class of Rover abstract class, in order to test its move() method
        Robot robot = new Robot("Rover-A", coor) {
        };

        //turn 30 degree and move 5 units
        robot.turn(30);
        robot.move(5);

        Assertions.assertEquals(5.50000000, robot.getX());
        Assertions.assertEquals(8.33012701, robot.getY());
        Assertions.assertEquals(60, robot.getTheta());
    }

}
