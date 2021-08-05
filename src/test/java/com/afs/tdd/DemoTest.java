package com.afs.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class DemoTest {
    private String sampleInstructions;

    @BeforeEach
    public void setup() {
        sampleInstructions = "0 0 N MLMMM";
    }
    @Test
    void should_return_x_coordinate_given_batch_instructions() {
        Instructions expectedInstructions =
                new Instructions(0, 0, "N", "MLMMM".chars().mapToObj(obj -> (char) obj).collect(Collectors.toList()));
        Instructions testResult = Application.spliceInstructions(sampleInstructions);
        assertThat(testResult.getxCoords()).isEqualTo(expectedInstructions.getxCoords());
    }
}
