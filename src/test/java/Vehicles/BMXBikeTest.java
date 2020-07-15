package Vehicles;

import Driving.Bike;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BMXBikeTest {
    Bike bb;

    @Before
    public void setUp() throws Exception {
        this.bb = new BMXBike();
    }

    @Test
    public void getTopSpeed() {
        // Arrange
        Double expected = 57.5;

        // Act
        Double actual = bb.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getTopSpeedAfterTransport() {
        // Arrange
        Double expected = 49.5;

        // Act
        bb.transport(20.0);
        bb.transport(20.0);
        Double actual = bb.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getTopSpeedAfterTransportThenInflateTires() {
        // Arrange
        Double expected = 57.5;

        // Act
        bb.transport(20 * 2.0);
        bb.inflateTires();
        Double actual = bb.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transport() {
        // Arrange
        Integer expected = 4549;

        // Act
        Integer actual = bb.transport(57.5);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure() {
        // Arrange
        Integer expected = 81;

        // Act
        bb.transport(20.0 * 2);
        Integer actual = bb.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure2() {
        // Arrange
        Integer expected = 79;

        // Act
        bb.transport(20.0 * 3);
        Integer actual = bb.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure3() {
        // Arrange
        Integer expected = 30;

        // Act
        bb.transport(20.0 * 100);
        bb.transport(20.0 * 2);
        Integer actual = bb.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure4() {
        // Arrange
        Integer expected = 85;

        // Act
        bb.transport(19.9);
        bb.transport(19.9);
        bb.transport(19.9);
        bb.transport(19.9);
        bb.transport(19.9);
        bb.transport(19.9);
        Integer actual = bb.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getTirePressure() {
        // Arrange
        Integer expected = 85;

        // Act
        Integer actual = bb.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void inflateTires() {
        // Arrange
        Integer expected = 85;

        // Act
        bb.transport(20.0 * 3);
        Integer tirePressureAfterTransport = bb.getTirePressure();

        bb.inflateTires();
        Integer actual = bb.getTirePressure();

        // Assert
        assertNotEquals(expected, tirePressureAfterTransport);
        assertEquals(expected, actual);
    }

    @Test
    public void recommendedTirePressure() {
        // Arrange
        Integer expected = 85;

        // Act
        Integer actual = bb.recommendedTirePressure();

        // Assert
        assertEquals(expected, actual);
    }
}