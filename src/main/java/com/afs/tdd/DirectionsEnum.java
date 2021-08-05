package com.afs.tdd;

public enum DirectionsEnum {
    NORTH("N"),
    SOUTH("S"),
    EAST("E"),
    WEST("W");

    DirectionsEnum(String directionInitial) {
        this.directionInitial = directionInitial;
    }

    private final String directionInitial;

    public String getDirectionInitial() {
        return directionInitial;
    }
}
