package com.afs.tdd;

import java.util.EnumSet;

public enum DirectionsEnum {
    N('W', 'E'),
    S('E', 'W'),
    E('N', 'S'),
    W('S', 'N');

    DirectionsEnum(Character directionAfterLeft, Character directionAfterRight) {
        this.directionAfterLeft = directionAfterLeft;
        this.directionAfterRight = directionAfterRight;
    }

    private final Character directionAfterLeft;
    private final Character directionAfterRight;

    public Character getDirectionAfterLeft() {
        return directionAfterLeft;
    }

    public Character getDirectionAfterRight() {
        return directionAfterRight;
    }

    public EnumSet<DirectionsEnum> getVerticalDirections() {
        return EnumSet.of(N,S);
    }

    public EnumSet<DirectionsEnum> getHorizontalDirections() {
        return EnumSet.of(E,W);
    }
}
