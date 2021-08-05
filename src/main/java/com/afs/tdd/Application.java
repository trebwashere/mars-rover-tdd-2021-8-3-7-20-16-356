package com.afs.tdd;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static Coordinates spliceInstructions(String instructionsStr) {
        String[] splicedInstructions = instructionsStr.split(" ");
        return new Coordinates(){{
            setxCoords(Integer.parseInt(splicedInstructions[0]));
            setyCoords(Integer.parseInt(splicedInstructions[1]));
            setDirection(splicedInstructions[2]);
        }};
    }

    public static List<Character> getMovementInstructions(String instructionsStr) {
        String[] splicedInstructions = instructionsStr.split(" ");
        if (splicedInstructions.length == 4) {
            return splicedInstructions[3].chars()
                    .mapToObj(character -> (char) character)
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
