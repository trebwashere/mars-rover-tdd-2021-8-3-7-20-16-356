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

    private String evaluateRoverRotation(String rotationDirection) {
        String currentDirection = coordinates.getDirection();
        if (rotationDirection.equals("L")) {
            return getDirectionAfterLeftTurn(currentDirection);
        }
        return "";
    }

    private String getDirectionAfterLeftTurn(String currentDirection) {
        switch (currentDirection) {
            case "N":
                return "W";
            case "W":
                return "S";
            case "S":
                return "E";
        }
        return "";
    }
}
