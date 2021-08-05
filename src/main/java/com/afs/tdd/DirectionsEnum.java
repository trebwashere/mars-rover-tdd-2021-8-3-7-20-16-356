package com.afs.tdd;

import java.util.EnumSet;

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

    public EnumSet<DirectionsEnum> getVerticalDirections() {
        return EnumSet.of(N,S);
    }

    public EnumSet<DirectionsEnum> getHorizontalDirections() {
        return EnumSet.of(E,W);
    }
}
