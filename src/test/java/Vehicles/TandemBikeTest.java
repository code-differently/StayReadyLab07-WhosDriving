package Vehicles;

import org.junit.Before;
import org.junit.Test;

import Driving.Bike;
import static org.junit.Assert.*;
public class TandemBikeTest 
{
    Bike tb;

    @Before
    public void setUp() throws Exception {
        this.tb = new TandemBike();
    }

    @Test
    public void getTopSpeed() {
        // Arrange
        Double expected = 32.5;

        // Act
        Double actual = tb.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getTopSpeedAfterTransport() {
        // Arrange
        Double expected = 30.5;

        // Act
        tb.transport(30.0);
        tb.transport(30.0);
        Double actual = tb.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getTopSpeedAfterTransportThenInflateTires() {
        // Arrange
        Double expected = 32.5;

        // Act
        tb.transport(30 * 2.0);
        tb.inflateTires();
        Double actual = tb.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transport() {
        // Arrange
        Integer expected = (60 * 60);

        // Act
        Integer actual = tb.transport(32.5);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure() {
        // Arrange
        Integer expected = 28;

        // Act
        tb.transport(30.0 * 2);
        Integer actual = tb.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure2() {
        // Arrange
        Integer expected = 27;

        // Act
        tb.transport(30.0 * 3);
        Integer actual = tb.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure3() {
        // Arrange
        Integer expected = 20;

        // Act
        tb.transport(30.0 * 100);
        tb.transport(30.0 * 2);
        Integer actual = tb.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure4() {
        // Arrange
        Integer expected = 30;

        // Act
        tb.transport(29.9);
        tb.transport(29.9);
        tb.transport(29.9);
        tb.transport(29.9);
        tb.transport(29.9);
        tb.transport(29.9);
        Integer actual = tb.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getTirePressure() {
        // Arrange
        Integer expected = 30;

        // Act
        Integer actual = tb.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void inflateTires() {
        // Arrange
        Integer expected = 30;

        // Act
        tb.transport(30.0 * 3);
        Integer tirePressureAfterTransport = tb.getTirePressure();

        tb.inflateTires();
        Integer actual = tb.getTirePressure();

        // Assert
        assertNotEquals(expected, tirePressureAfterTransport);
        assertEquals(expected, actual);
    }

    @Test
    public void recommendedTirePressure() {
        // Arrange
        Integer expected = 30;

        // Act
        Integer actual = tb.recommendedTirePressure();

        // Assert
        assertEquals(expected, actual);
    }
    
}