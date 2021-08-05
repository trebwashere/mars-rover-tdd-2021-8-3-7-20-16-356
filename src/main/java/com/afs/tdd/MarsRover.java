package com.afs.tdd;

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
        coordinates.setDirection(evaluateRoverRotation('L'));
    }

    public void turnRight() {
        coordinates.setDirection(evaluateRoverRotation('R'));
    }

    private Character evaluateRoverRotation(Character rotationDirection) {
        DirectionsEnum currentDirection = DirectionsEnum.valueOf(String.valueOf(coordinates.getDirection()));
        if (rotationDirection.equals('L')) {
            return currentDirection.getDirectionAfterLeft();
        } else if (rotationDirection.equals('R')) {
            return currentDirection.getDirectionAfterRight();
        }
        return null;
    }

    public void moveForward() {
        DirectionsEnum currentDirection = DirectionsEnum.valueOf(String.valueOf(coordinates.getDirection()));
        if (currentDirection.getVerticalDirections().contains(currentDirection)) {
            int yCoords = coordinates.getyCoords();
            coordinates.setyCoords(currentDirection.equals(DirectionsEnum.N) ? ++yCoords : --yCoords);
        } else if(currentDirection.getHorizontalDirections().contains(currentDirection)) {
            int xCoords = coordinates.getxCoords();
            coordinates.setxCoords(currentDirection.equals(DirectionsEnum.E) ? ++xCoords : --xCoords);
        }
    }

    private List<Character> getMovementInstructions(String instructionsStr) {
        String[] splicedInstructions = instructionsStr.split(" ");
        if (splicedInstructions.length >= 3) {
            this.setCoordinates(new Coordinates(){{
                setxCoords(Integer.parseInt(splicedInstructions[0]));
                setyCoords(Integer.parseInt(splicedInstructions[1]));
                setDirection(splicedInstructions[2].charAt(0));
            }});
        }

        return splicedInstructions[splicedInstructions.length - 1].chars()
                .mapToObj(character -> (char) character)
                .collect(Collectors.toList());
    }

    public void executeCommands(String instructionsStr) {
        List<Character> complexInstructions = getMovementInstructions(instructionsStr);
        for (Character instruction : complexInstructions) {
            switch(instruction) {
                case 'L': turnLeft(); break;
                case 'R': turnRight(); break;
                case 'M': moveForward(); break;
            }
        }
    }
}
