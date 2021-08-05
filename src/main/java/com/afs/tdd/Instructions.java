package com.afs.tdd;

import java.util.ArrayList;
import java.util.List;

public class Instructions {
    private int xCoords;
    private int yCoords;
    private String direction;
    List<Character> roverMovements = new ArrayList<>();

    public Instructions(int xCoords, int yCoords, String direction, List<Character> roverMovements) {
        this.xCoords = xCoords;
        this.yCoords = yCoords;
        this.direction = direction;
        this.roverMovements = roverMovements;
    }

    public Instructions() {
    }

    public int getxCoords() {
        return xCoords;
    }

    public void setxCoords(int xCoords) {
        this.xCoords = xCoords;
    }

    public int getyCoords() {
        return yCoords;
    }

    public void setyCoords(int yCoords) {
        this.yCoords = yCoords;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public List<Character> getRoverMovements() {
        return roverMovements;
    }

    public void setRoverMovements(List<Character> roverMovements) {
        this.roverMovements = roverMovements;
    }
}
