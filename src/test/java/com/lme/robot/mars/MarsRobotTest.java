package com.lme.robot.mars;

import com.lme.rover.Coordinates;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class MarsRobotTest {

    private final MarsGrid marsGrid = new MarsGrid(30, 40);

    @Test
    public void roverShouldTurnLeftFromOriginCorrectly() {
        Coordinates coor = new Coordinates();

        // create an instance of an anonymous class of Rover abstract class, in order to test its move() method
        MarsRobot robot = MarsRobot.init("MarsRobot-A", coor, marsGrid);

        //turn Left and move
        robot.turn(90);
        robot.move(1);

        Assertions.assertEquals("0 1 N", robot.tellCoordinates());
    }

    @Test
    public void roverShouldTurnRightFromOriginCorrectly() {
        Coordinates coor = new Coordinates();

        // create an instance of an anonymous class of Rover abstract class, in order to test its move() method
        MarsRobot robot = MarsRobot.init("MarsRobot-A", coor, marsGrid);

        //turn Left and move
        robot.turn(-90);
        Assertions.assertEquals("0 0 S", robot.tellCoordinates());
    }

    @Test
    public void roverShouldMoveForwardFromOriginCorrectly() {
        Coordinates coor = new Coordinates();

        // create an instance of an anonymous class of Rover abstract class, in order to test its move() method
        MarsRobot robot = MarsRobot.init("MarsRobot-A", coor, marsGrid);

        //turn Left and move
        robot.move(1);

        Assertions.assertEquals("1 0 E", robot.tellCoordinates());
    }

    @Test
    public void roverShouldMoveAndTurnCorrectly() {
        Coordinates coor = new Coordinates(3, 4, 90);

        MarsRobot robot = MarsRobot.init("MarsRobot-A", coor, marsGrid);
        robot.move(1);
        Assertions.assertEquals("3 5 N", robot.tellCoordinates());

        // turn right and move
        robot.turn(-90);
        robot.move(1);
        Assertions.assertEquals("4 5 E", robot.tellCoordinates());

        // turn left and move
        robot.turn(90);
        robot.move(1);
        Assertions.assertEquals("4 6 N", robot.tellCoordinates());

    }

    @Test
    public void roverShouldNotTurnPartially() {
        Coordinates coor = new Coordinates(3, 4, 90);

        MarsRobot robot = MarsRobot.init("MarsRobot-A", coor, marsGrid);

        // turn Partial left, must throw IllegalArgumentException
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    robot.turn(25);
                });

        // turn Partial right, must throw IllegalArgumentException
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    robot.turn(-45);
                });
    }

    @Test
    public void roverShouldOnlyMoveByOneUnit() {
        Coordinates coor = new Coordinates(3, 4, 90);

        MarsRobot robot = MarsRobot.init("MarsRobot-A", coor, marsGrid);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    robot.move(2);
                });

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    robot.move(0.5);
                });

    }

    @Test
    public void robotShouldBeLostAndGridBeScentedOnceRobotCrossesMaxGrid() {
        Coordinates coor = new Coordinates(29, 39, 90);
        MarsGrid marsGrid = new MarsGrid(30, 40);

        // test robot getting lost in North direction
        MarsRobot robot = MarsRobot.init("MarsRobot-A", coor, marsGrid);
        robot.move(1);
        robot.move(1);

        Assertions.assertEquals("29 40 N LOST", robot.tellCoordinates());
        Assertions.assertTrue(robot.isLost());
        Assertions.assertTrue(marsGrid.isScented(29, 40, MarsOrientation.N));

        // test robot getting lost in East direction
        coor = new Coordinates(29, 39, 90);
        robot = MarsRobot.init("MarsRobot-B", coor, marsGrid);
        robot.turn(-90);
        robot.move(1);
        robot.move(1);

        Assertions.assertEquals("30 39 E LOST", robot.tellCoordinates());
        Assertions.assertTrue(robot.isLost());
        Assertions.assertTrue(marsGrid.isScented(30, 39, MarsOrientation.E));

        // test robot getting lost in West direction
        coor = new Coordinates(0, 2, 180);
        robot = MarsRobot.init("MarsRobot-C", coor, marsGrid);
        robot.move(1);

        Assertions.assertEquals("0 2 W LOST", robot.tellCoordinates());
        Assertions.assertTrue(robot.isLost());
        Assertions.assertTrue(marsGrid.isScented(0, 2, MarsOrientation.W));

        // test robot getting lost in South direction
        coor = new Coordinates(2, 0, 270);
        robot = MarsRobot.init("MarsRobot-D", coor, marsGrid);
        robot.move(1);

        Assertions.assertEquals("2 0 S LOST", robot.tellCoordinates());
        Assertions.assertTrue(robot.isLost());
        Assertions.assertTrue(marsGrid.isScented(2, 0, MarsOrientation.S));

    }

    @Test
    public void robotShouldAvoidTheMoveAtScentedGrid() {
        MarsGrid marsGrid = new MarsGrid(30, 30);

        Coordinates coorA = new Coordinates(30, 2, 0);
        MarsRobot robotA = MarsRobot.init("MarsRobot-A", coorA, marsGrid);
        robotA.move(1);
        Assertions.assertEquals("30 2 E LOST", robotA.tellCoordinates());
        Assertions.assertTrue(marsGrid.isScented(30, 2, MarsOrientation.E));

        Coordinates coorB = new Coordinates(28, 2, 0);
        MarsRobot robotB = MarsRobot.init("MarsRobot-B", coorB, marsGrid);
        robotB.move(1);
        robotB.move(1);
        robotB.move(1);
        Assertions.assertEquals("30 2 E", robotB.tellCoordinates());

    }

}
