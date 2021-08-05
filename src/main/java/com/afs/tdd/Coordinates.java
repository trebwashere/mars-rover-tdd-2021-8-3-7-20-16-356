package com.afs.tdd;

public class Coordinates {
    private int xCoords;
    private int yCoords;
    private Character direction;

    public Coordinates(int xCoords, int yCoords, Character direction) {
        this.xCoords = xCoords;
        this.yCoords = yCoords;
        this.direction = direction;
    }

    public Coordinates() {
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

    public Character getDirection() {
        return direction;
    }

    public void setDirection(Character direction) {
        this.direction = direction;
    }
}
