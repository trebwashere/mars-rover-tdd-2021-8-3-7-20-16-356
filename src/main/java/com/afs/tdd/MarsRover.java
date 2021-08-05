package com.afs.tdd;

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
        }
    }
}
