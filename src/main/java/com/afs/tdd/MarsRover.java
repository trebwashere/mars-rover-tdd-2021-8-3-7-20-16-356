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
        switch(rotationDirection) {
            case "L":
                return getDirectionAfterLeftTurn(currentDirection);
        }
        return "";
    }

    private String getDirectionAfterLeftTurn(String currentDirection) {
        if (currentDirection.equals("N")) {
            return "E";
        } else if (currentDirection.equals("E")) {
            return "S";
        }
        return "";
    }
}
