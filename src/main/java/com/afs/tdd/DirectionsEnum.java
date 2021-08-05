package com.afs.tdd;

public enum DirectionsEnum {
    NORTH("N","W", "E"),
    SOUTH("S", "E", "W"),
    EAST("E", "N", "S"),
    WEST("W", "S", "N");

    DirectionsEnum(String directionInitial, String directionAfterLeft, String directionAfterRight) {
        this.directionInitial = directionInitial;
        this.directionAfterLeft = directionAfterLeft;
        this.directionAfterRight = directionAfterRight;
    }

    private final String directionInitial;
    private final String directionAfterLeft;
    private final String directionAfterRight;

    public String getDirectionAfterLeft() {
        return directionAfterLeft;
    }

    public String getDirectionAfterRight() {
        return directionAfterRight;
    }
}
