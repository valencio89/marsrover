package com.lme.robot.mars.client;

import com.lme.robot.mars.MarsGrid;
import com.lme.robot.mars.MarsRobot;
import com.lme.robot.mars.client.MarsRobotDriver;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MarsRobotClient {
    public static void main(String[] args) {

        MarsRobotDriver driver = new MarsRobotDriver();
        List<MarsRobot> marsRobots = new LinkedList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Input the Mars Terrain Grid size. eg \"30 40\" (without the quotes)");

        String[] s = scanner.nextLine().split(" ");
        MarsGrid marsGrid = new MarsGrid(Integer.parseInt(s[0]), Integer.parseInt(s[1]));

        System.out.println("Please input \"quit\" when finished with all the robots' inputs. " +
                "Please input the Robot position, orientation & the move, eg:- \n3 4 N\nLFRFRRFFFLF");
        int i = 1;

        String input = scanner.nextLine();

        while (!input.startsWith("quit")) {
            s = input.split(" ");
            String move = scanner.nextLine();

            MarsRobot robot = driver.drive(marsGrid, "Robot-" + i, s[0], s[1], s[2], move);
            marsRobots.add(robot);

            i++;
            input = scanner.nextLine();
        }

        for (MarsRobot m : marsRobots) {
            System.out.println(m.tellCoordinates());
        }

    }


}
