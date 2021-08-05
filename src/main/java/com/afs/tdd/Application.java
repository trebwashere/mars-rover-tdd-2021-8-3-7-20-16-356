package com.afs.tdd;

public class Application {
    public static Instructions spliceInstructions(String instructionsStr) {
        String[] splicedInstructions = instructionsStr.split(" ");
        return new Instructions(){{
            setxCoords(Integer.parseInt(splicedInstructions[0]));
            setyCoords(Integer.parseInt(splicedInstructions[1]));
        }};
    }
}
