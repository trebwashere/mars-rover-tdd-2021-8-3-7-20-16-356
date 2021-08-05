package com.afs.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DemoTest {
    private String sampleInstructions;
    private MarsRover marsRover;

    @BeforeEach
    public void setup() {
        marsRover = new MarsRover();
        sampleInstructions = "1 2 N MLMMM";
    }
    @Test
    void should_return_x_coordinate_given_batch_instructions() {
        Coordinates expectedCoordinates =
                new Coordinates(1, 2, "N");
        Coordinates testResult = marsRover.spliceInstructions(sampleInstructions);
        assertThat(testResult.getxCoords()).isEqualTo(expectedCoordinates.getxCoords());
    }

    @Test
    void should_return_y_coordinate_given_batch_instructions() {
        Coordinates expectedCoordinates =
                new Coordinates(1, 2, "N");
        Coordinates testResult = marsRover.spliceInstructions(sampleInstructions);
        assertThat(testResult.getyCoords()).isEqualTo(expectedCoordinates.getyCoords());
    }

    @Test
    void should_return_direction_given_batch_instructions() {
        Coordinates expectedCoordinates =
                new Coordinates(1, 2, "N");
        Coordinates testResult = marsRover.spliceInstructions(sampleInstructions);
        assertThat(testResult.getDirection()).isEqualTo(expectedCoordinates.getDirection());
    }

    @Test
    void should_return_roverMovements_given_batch_instructions() {
        List<Character> expectedRoverMovements = Arrays.asList('M','L','M','M','M');
        List<Character> outputRoverMovements = marsRover.getMovementInstructions(sampleInstructions);
        assertThat(outputRoverMovements).isEqualTo(expectedRoverMovements);
    }

    @Test
    void turnLeft_should_return_East_direction_given_rover_is_facing_North() {
        marsRover.setCoordinates(new Coordinates(0,0,"N"));
        marsRover.turnLeft();
        assertThat(marsRover.getCoordinates().getDirection()).isEqualTo("W");
    }

    @Test
    void turnLeft_should_return_South_direction_given_rover_is_facing_West() {
        marsRover.setCoordinates(new Coordinates(0,0,"W"));
        marsRover.turnLeft();
        assertThat(marsRover.getCoordinates().getDirection()).isEqualTo("S");
    }

    @Test
    void turnLeft_should_return_East_direction_given_rover_is_facing_South() {
        marsRover.setCoordinates(new Coordinates(0,0,"S"));
        marsRover.turnLeft();
        assertThat(marsRover.getCoordinates().getDirection()).isEqualTo("E");
    }

    @Test
    void turnLeft_should_return_North_direction_given_rover_is_facing_East() {
        marsRover.setCoordinates(new Coordinates(0,0,"E"));
        marsRover.turnLeft();
        assertThat(marsRover.getCoordinates().getDirection()).isEqualTo("N");
    }

    @Test
    void turnRight_should_return_East_direction_given_rover_is_facing_North() {
        marsRover.setCoordinates(new Coordinates(0,0,"N"));
        marsRover.turnRight();
        assertThat(marsRover.getCoordinates().getDirection()).isEqualTo("E");
    }

    @Test
    void turnRight_should_return_South_direction_given_rover_is_facing_East() {
        marsRover.setCoordinates(new Coordinates(0,0,"E"));
        marsRover.turnRight();
        assertThat(marsRover.getCoordinates().getDirection()).isEqualTo("S");
    }

    @Test
    void turnRight_should_return_West_direction_given_rover_is_facing_South() {
        marsRover.setCoordinates(new Coordinates(0,0,"S"));
        marsRover.turnRight();
        assertThat(marsRover.getCoordinates().getDirection()).isEqualTo("W");
    }

    @Test
    void turnRight_should_return_North_direction_given_rover_is_facing_West() {
        marsRover.setCoordinates(new Coordinates(0,0,"W"));
        marsRover.turnRight();
        assertThat(marsRover.getCoordinates().getDirection()).isEqualTo("N");
    }

    @Test
    void moveForward_should_return_positive_1_yCoordinate_given_rover_is_facing_North() {
        marsRover.setCoordinates(new Coordinates(0,0,"N"));
        marsRover.moveForward();
        assertThat(marsRover.getCoordinates().getyCoords()).isEqualTo(1);
    }

    @Test
    void moveForward_should_return_negative_1_yCoordinate_given_rover_is_facing_South() {
        marsRover.setCoordinates(new Coordinates(0,0,"S"));
        marsRover.moveForward();
        assertThat(marsRover.getCoordinates().getyCoords()).isEqualTo(-1);
    }

    @Test
    void moveForward_should_return_positive_1_xCoordinate_given_rover_is_facing_East() {
        marsRover.setCoordinates(new Coordinates(0,0,"E"));
        marsRover.moveForward();
        assertThat(marsRover.getCoordinates().getxCoords()).isEqualTo(1);
    }

    @Test
    void moveForward_should_return_negative_1_xCoordinate_given_rover_is_facing_West() {
        marsRover.setCoordinates(new Coordinates(0,0,"W"));
        marsRover.moveForward();
        assertThat(marsRover.getCoordinates().getxCoords()).isEqualTo(-1);
    }
}
