package Vehicles;

import Driving.Bike;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BmxBikeTest {
    
    Bike bmx;

    @Before
    public void setUp() throws Exception {
        this.bmx = new BmxBike();
    }

    @Test
    public void getTopSpeed() {
        // Arrange
        Double expected = 33.5;

        // Act
        Double actual = bmx.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getTopSpeedAfterTransport() {
        // Arrange
        Double expected = 31.5;

        // Act
        bmx.transport(35.0);
        bmx.transport(35.0);
        Double actual = bmx.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getTopSpeedAfterTransportThenInflateTires() {
        // Arrange
        Double expected = 33.5;

        // Act
        bmx.transport(35 * 2.0);
        bmx.inflateTires();
        Double actual = bmx.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transport() {
        // Arrange
        Integer expected = (60 * 60);

        // Act
        Integer actual = bmx.transport(33.5);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure() {
        // Arrange
        Integer expected = 33;

        // Act
        bmx.transport(35.0 * 2);
        Integer actual = bmx.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure2() {
        // Arrange
        Integer expected = 33;

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
        bmx.transport(35.0 * 100);
        bmx.transport(35.0 * 2);
        Integer actual = bmx.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure4() {
        // Arrange
        Integer expected = 35;

        // Act
        bmx.transport(34.9);
        bmx.transport(34.9);
        bmx.transport(34.9);
        bmx.transport(34.9);
        bmx.transport(34.9);
        bmx.transport(34.9);
        Integer actual = bmx.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getTirePressure() {
        // Arrange
        Integer expected = 35;

        // Act
        Integer actual = bmx.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void inflateTires() {
        // Arrange
        Integer expected = 35;

        // Act
        bmx.transport(35.0 * 3);
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
        Integer expected = 35;

        // Act
        Integer actual = bmx.recommendedTirePressure();

        // Assert
        assertEquals(expected, actual);
    }
}