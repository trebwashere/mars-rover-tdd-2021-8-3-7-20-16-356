package com.afs.tdd;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MarsRover {

    private Coordinates coordinates;

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void turnLeft() {
        coordinates.setDirection(evaluateRoverRotation("L"));
    }

    public void turnRight() {
        coordinates.setDirection(evaluateRoverRotation("R"));
    }

    private String evaluateRoverRotation(String rotationDirection) {
        DirectionsEnum currentDirection = DirectionsEnum.valueOf(coordinates.getDirection());
        if (rotationDirection.equals("L")) {
            return currentDirection.getDirectionAfterLeft();
        } else if (rotationDirection.equals("R")) {
            return currentDirection.getDirectionAfterRight();
        }
        return "";
    }

    public void moveForward() {
        DirectionsEnum currentDirection = DirectionsEnum.valueOf(coordinates.getDirection());
        if (currentDirection.getVerticalDirections().contains(currentDirection)) {
            int yCoords = coordinates.getyCoords();
            coordinates.setyCoords(currentDirection.equals(DirectionsEnum.N) ? ++yCoords : --yCoords);
        } else if(currentDirection.getHorizontalDirections().contains(currentDirection)) {
            int xCoords = coordinates.getxCoords();
            coordinates.setxCoords(currentDirection.equals(DirectionsEnum.E) ? ++xCoords : --xCoords);
        }
    }

    public Coordinates spliceInstructions(String instructionsStr) {
        String[] splicedInstructions = instructionsStr.split(" ");
        return new Coordinates(){{
            setxCoords(Integer.parseInt(splicedInstructions[0]));
            setyCoords(Integer.parseInt(splicedInstructions[1]));
            setDirection(splicedInstructions[2]);
        }};
    }

    public static List<Character> getMovementInstructions(String instructionsStr) {
        String[] splicedInstructions = instructionsStr.split(" ");
        if (splicedInstructions.length == 4) {
            return splicedInstructions[3].chars()
                    .mapToObj(character -> (char) character)
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
