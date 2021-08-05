package com.afs.tdd;

import java.util.stream.Collectors;

public class Application {
    public static Instructions spliceInstructions(String instructionsStr) {
        String[] splicedInstructions = instructionsStr.split(" ");
        return new Instructions(){{
            setxCoords(Integer.parseInt(splicedInstructions[0]));
            setyCoords(Integer.parseInt(splicedInstructions[1]));
            setDirection(splicedInstructions[2]);
            if (splicedInstructions.length > 4) {
                setRoverMovements(splicedInstructions[3].chars()
                        .mapToObj(character -> (char) character)
                        .collect(Collectors.toList()));
            }
        }};
    }
}
