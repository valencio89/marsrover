package com.lme.robot.mars.client;

import com.lme.robot.mars.MarsGrid;
import com.lme.robot.mars.MarsOrientation;
import com.lme.robot.mars.MarsRobot;
import com.lme.rover.Coordinates;

public class MarsRobotDriver {
    public MarsRobot drive(MarsGrid marsGrid, String robotName, String x, String y, String direction, String input) {
        MarsOrientation marsOrientation = MarsOrientation.valueOf(direction);

        Coordinates coor = new Coordinates(Integer.parseInt(x), Integer.parseInt(y), marsOrientation.getAngle());
        MarsRobot marsRobot = MarsRobot.init(robotName, coor, marsGrid);

        for (int j = 0; j < input.length(); j++) {
            char c = input.charAt(j);
            switch (c) {
                case 'L':
                    marsRobot.turn(90);
                    break;
                case 'R':
                    marsRobot.turn(-90);
                    break;
                case 'F':
                    marsRobot.move(1);
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
        return marsRobot;
    }

}
