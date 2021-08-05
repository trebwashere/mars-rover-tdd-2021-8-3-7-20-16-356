package com.afs.tdd;

public enum DirectionsEnum {
    N("W", "E"),
    S("E", "W"),
    E("N", "S"),
    W("S", "N");

    DirectionsEnum(String directionAfterLeft, String directionAfterRight) {
        this.directionAfterLeft = directionAfterLeft;
        this.directionAfterRight = directionAfterRight;
    }

    private final String directionAfterLeft;
    private final String directionAfterRight;

    public String getDirectionAfterLeft() {
        return directionAfterLeft;
    }

    public String getDirectionAfterRight() {
        return directionAfterRight;
    }
}
