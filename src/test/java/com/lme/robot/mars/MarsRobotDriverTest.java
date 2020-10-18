package com.lme.robot.mars;

import com.lme.robot.mars.client.MarsRobotDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MarsRobotDriverTest {
    MarsRobotDriver driver = new MarsRobotDriver();

    @Test
    public void marsRobotDriverTest() {
        MarsGrid marsGrid = new MarsGrid(5, 3);
        MarsRobot robotA = driver.drive(marsGrid, "Robot-A", "1", "1", "E", "RFRFRFRF");
        Assertions.assertEquals("1 1 E", robotA.tellCoordinates());

        MarsRobot robotB = driver.drive(marsGrid, "Robot-B", "3", "2", "N", "FRRFLLFFRRFLL");
        Assertions.assertEquals("3 3 N LOST", robotB.tellCoordinates());

        MarsRobot robotC = driver.drive(marsGrid, "Robot-C", "0", "3", "W", "LLFFFLFLFL");
        Assertions.assertEquals("2 3 S", robotC.tellCoordinates());

    }
}
