package Vehicles;

import Driving.Bike;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BMXBikeTest {
    Bike bmx;

    @Before
    public void setUp() throws Exception {
        this.bmx = new BMXBike();
    }

    @Test
    public void getTopSpeed() {
        // Arrange

        Double expected = 50.0;

        // Act
        Double actual = bmx.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getTopSpeedAfterTransport() {
        // Arrange
        Double expected = 48.0;

        // Act
        bmx.transport(30.0);
        bmx.transport(30.0);
        Double actual = bmx.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getTopSpeedAfterTransportThenInflateTires() {
        // Arrange
        Double expected = 50.0;

        // Act
        bmx.transport(30 * 2.0);
        bmx.inflateTires();
        Double actual = bmx.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transport() {
        // Arrange
        Integer expected = (60 * 60 * 2);

        // Act
        Integer actual = bmx.transport(50.0);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure() {
        // Arrange
        Integer expected = 28;

        // Act
        bmx.transport(30.0 * 2);
        Integer actual = bmx.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure2() {
        // Arrange
        Integer expected = 27;

        // Act
        bmx.transport(30.0 * 3);
        Integer actual = bmx.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure3() {
        // Arrange
        Integer expected = 20;

        // Act
        bmx.transport(30.0 * 100);
        bmx.transport(30.0 * 2);
        Integer actual = bmx.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure4() {
        // Arrange
        Integer expected = 30;

        // Act
        bmx.transport(29.9);
        bmx.transport(29.9);
        bmx.transport(29.9);
        bmx.transport(29.9);
        bmx.transport(29.9);
        bmx.transport(29.9);
        Integer actual = bmx.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getTirePressure() {
        // Arrange
        Integer expected = 30;

        // Act
        Integer actual = bmx.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void inflateTires() {
        // Arrange
        Integer expected = 30;

        // Act
        bmx.transport(30.0 * 3);
        Integer tirePressureAfterTransport = bmx.getTirePressure();

        bmx.inflateTires();
        Integer actual = bmx.getTirePressure();

        // Assert
        assertNotEquals(expected, tirePressureAfterTransport);
        assertEquals(expected, actual);
    }

    @Test
    public void recommendedTirePressure() {
        // Arrange
        Integer expected = 30;

        // Act
        Integer actual = bmx.recommendedTirePressure();

        // Assert
        assertEquals(expected, actual);
    }
}