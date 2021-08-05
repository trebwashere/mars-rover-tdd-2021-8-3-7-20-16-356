package com.afs.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DemoTest {

    private String initialRoverInstruction;
    private MarsRover marsRover;

    @BeforeEach
    public void setup() {
        marsRover = new MarsRover();
        initialRoverInstruction = "1 2 N MLMMM";
    }
    @Test
    void should_return_x_coordinate_given_batch_instructions() {
        Coordinates expectedCoordinates =
                new Coordinates(1, 2, 'N');
        marsRover.executeCommands("1 2 N");
        assertThat(marsRover.getCoordinates().getxCoords()).isEqualTo(expectedCoordinates.getxCoords());
    }

    @Test
    void should_return_y_coordinate_given_batch_instructions() {
        Coordinates expectedCoordinates =
                new Coordinates(1, 2, 'N');
        marsRover.executeCommands("1 2 N");
        assertThat(marsRover.getCoordinates().getyCoords()).isEqualTo(expectedCoordinates.getyCoords());
    }

    @Test
    void should_return_direction_given_batch_instructions() {
        Coordinates expectedCoordinates =
                new Coordinates(1, 2, 'N');
        marsRover.executeCommands("1 2 N");
        assertThat(marsRover.getCoordinates().getDirection()).isEqualTo(expectedCoordinates.getDirection());
    }

    @Test
    void turnLeft_should_return_East_direction_given_rover_is_facing_North() {
        marsRover.setCoordinates(new Coordinates(0,0,'N'));
        marsRover.executeCommands("L");
        assertThat(marsRover.getCoordinates().getDirection()).isEqualTo('W');
    }

    @Test
    void turnLeft_should_return_South_direction_given_rover_is_facing_West() {
        marsRover.setCoordinates(new Coordinates(0,0,'W'));
        marsRover.executeCommands("L");
        assertThat(marsRover.getCoordinates().getDirection()).isEqualTo('S');
    }

    @Test
    void turnLeft_should_return_East_direction_given_rover_is_facing_South() {
        marsRover.setCoordinates(new Coordinates(0,0,'S'));
        marsRover.executeCommands("L");
        assertThat(marsRover.getCoordinates().getDirection()).isEqualTo('E');
    }

    @Test
    void turnLeft_should_return_North_direction_given_rover_is_facing_East() {
        marsRover.setCoordinates(new Coordinates(0,0,'E'));
        marsRover.executeCommands("L");
        assertThat(marsRover.getCoordinates().getDirection()).isEqualTo('N');
    }

    @Test
    void turnRight_should_return_East_direction_given_rover_is_facing_North() {
        marsRover.setCoordinates(new Coordinates(0,0,'N'));
        marsRover.executeCommands("R");
        assertThat(marsRover.getCoordinates().getDirection()).isEqualTo('E');
    }

    @Test
    void turnRight_should_return_South_direction_given_rover_is_facing_East() {
        marsRover.setCoordinates(new Coordinates(0,0,'E'));
        marsRover.executeCommands("R");
        assertThat(marsRover.getCoordinates().getDirection()).isEqualTo('S');
    }

    @Test
    void turnRight_should_return_West_direction_given_rover_is_facing_South() {
        marsRover.setCoordinates(new Coordinates(0,0,'S'));
        marsRover.executeCommands("R");
        assertThat(marsRover.getCoordinates().getDirection()).isEqualTo('W');
    }

    @Test
    void turnRight_should_return_North_direction_given_rover_is_facing_West() {
        marsRover.setCoordinates(new Coordinates(0,0,'W'));
        marsRover.executeCommands("R");
        assertThat(marsRover.getCoordinates().getDirection()).isEqualTo('N');
    }

    @Test
    void moveForward_should_return_positive_1_yCoordinate_given_rover_is_facing_North() {
        marsRover.setCoordinates(new Coordinates(0,0,'N'));
        marsRover.executeCommands("M");
        assertThat(marsRover.getCoordinates().getyCoords()).isEqualTo(1);
    }

    @Test
    void moveForward_should_return_negative_1_yCoordinate_given_rover_is_facing_South() {
        marsRover.setCoordinates(new Coordinates(0,0,'S'));
        marsRover.executeCommands("M");
        assertThat(marsRover.getCoordinates().getyCoords()).isEqualTo(-1);
    }

    @Test
    void moveForward_should_return_positive_1_xCoordinate_given_rover_is_facing_East() {
        marsRover.setCoordinates(new Coordinates(0,0,'E'));
        marsRover.executeCommands("M");
        assertThat(marsRover.getCoordinates().getxCoords()).isEqualTo(1);
    }

    @Test
    void moveForward_should_return_negative_1_xCoordinate_given_rover_is_facing_West() {
        marsRover.setCoordinates(new Coordinates(0,0,'W'));
        marsRover.executeCommands("M");
        assertThat(marsRover.getCoordinates().getxCoords()).isEqualTo(-1);
    }

    @Test
    void should_return_expected_output_given_complex_instructions() {
        marsRover.executeCommands("1 2 N MLMMM");
        assertThat(-2).isEqualTo(marsRover.getCoordinates().getxCoords());
        assertThat(3).isEqualTo(marsRover.getCoordinates().getyCoords());
        assertThat('W').isEqualTo(marsRover.getCoordinates().getDirection());
        marsRover.executeCommands("0 0 W");
        assertThat(0).isEqualTo(marsRover.getCoordinates().getxCoords());
        assertThat(0).isEqualTo(marsRover.getCoordinates().getyCoords());
        assertThat('W').isEqualTo(marsRover.getCoordinates().getDirection());
        marsRover.executeCommands("0 0 N MMMMLLLLMMMM");
        assertThat(0).isEqualTo(marsRover.getCoordinates().getxCoords());
        assertThat(8).isEqualTo(marsRover.getCoordinates().getyCoords());
        assertThat('N').isEqualTo(marsRover.getCoordinates().getDirection());
        marsRover.executeCommands("0 0 N MMMMMMMMMRMMMMMM");
        assertThat(6).isEqualTo(marsRover.getCoordinates().getxCoords());
        assertThat(9).isEqualTo(marsRover.getCoordinates().getyCoords());
        assertThat('E').isEqualTo(marsRover.getCoordinates().getDirection());
        marsRover.executeCommands("RMMMMMMMMMRMMMMMMR");
        assertThat(0).isEqualTo(marsRover.getCoordinates().getxCoords());
        assertThat(0).isEqualTo(marsRover.getCoordinates().getyCoords());
        assertThat('N').isEqualTo(marsRover.getCoordinates().getDirection());
    }
}
