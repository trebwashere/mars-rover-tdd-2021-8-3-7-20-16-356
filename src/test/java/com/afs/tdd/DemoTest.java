package com.afs.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DemoTest {
    private String sampleInstructions;

    @BeforeEach
    public void setup() {
        sampleInstructions = "1 2 N MLMMM";
    }
    @Test
    void should_return_x_coordinate_given_batch_instructions() {
        Coordinates expectedCoordinates =
                new Coordinates(1, 2, "N");
        Coordinates testResult = Application.spliceInstructions(sampleInstructions);
        assertThat(testResult.getxCoords()).isEqualTo(expectedCoordinates.getxCoords());
    }

    @Test
    void should_return_y_coordinate_given_batch_instructions() {
        Coordinates expectedCoordinates =
                new Coordinates(1, 2, "N");
        Coordinates testResult = Application.spliceInstructions(sampleInstructions);
        assertThat(testResult.getyCoords()).isEqualTo(expectedCoordinates.getyCoords());
    }

    @Test
    void should_return_direction_given_batch_instructions() {
        Coordinates expectedCoordinates =
                new Coordinates(1, 2, "N");
        Coordinates testResult = Application.spliceInstructions(sampleInstructions);
        assertThat(testResult.getDirection()).isEqualTo(expectedCoordinates.getDirection());
    }

    @Test
    void should_return_roverMovements_given_batch_instructions() {
        List<Character> expectedRoverMovements = Arrays.asList('M','L','M','M','M');
        List<Character> outputRoverMovements = Application.getMovementInstructions(sampleInstructions);
        assertThat(outputRoverMovements).isEqualTo(expectedRoverMovements);
    }

    @Test
    void turnLeft_should_return_East_direction_given_rover_is_facing_North() {
        MarsRover marsRover = new MarsRover();
        marsRover.setCoordinates(new Coordinates(0,0,"N"));
        marsRover.turnLeft();
        assertThat(marsRover.getCoordinates().getDirection()).isEqualTo("W");
    }

    @Test
    void turnLeft_should_return_South_direction_given_rover_is_facing_West() {
        MarsRover marsRover = new MarsRover();
        marsRover.setCoordinates(new Coordinates(0,0,"W"));
        marsRover.turnLeft();
        assertThat(marsRover.getCoordinates().getDirection()).isEqualTo("S");
    }

}
