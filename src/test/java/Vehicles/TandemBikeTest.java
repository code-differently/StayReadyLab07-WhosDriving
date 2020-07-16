package Vehicles;

import Driving.Bike;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.*;
import org.junit.Before;
import org.junit.Assert.*;

public class TandemBikeTest {
  Bike tb;

    @Before
    public void setUp() throws Exception {
        this.tb = new TandemBike();
    }

    @Test
    public void getTopSpeed() {
        // Arrange
        Double expected = 20.5;

        // Act
        Double actual = tb.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getTopSpeedAfterTransport() {
        // Arrange
        Double expected = 18.5;

        // Act
        tb.transport(20.0);
        tb.transport(20.0);
        Double actual = tb.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getTopSpeedAfterTransportThenInflateTires() {
        // Arrange
        Double expected = 20.5;

        // Act
        tb.transport(20 * 2.0);
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
        Integer actual = tb.transport(20.5);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure() {
        // Arrange
        Integer expected = 33;

        // Act
        tb.transport(20.0 * 2);
        Integer actual = tb.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure2() {
        // Arrange
        Integer expected = 32;

        // Act
        tb.transport(20.0 * 3);
        Integer actual = tb.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure3() {
        // Arrange
        Integer expected = 25;

        // Act
        tb.transport(20.0 * 100);
        tb.transport(20.0 * 2);
        Integer actual = tb.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure4() {
        // Arrange
        Integer expected = 35;

        // Act
        tb.transport(19.9);
        tb.transport(19.9);
        tb.transport(19.9);
        tb.transport(19.9);
        tb.transport(19.9);
        tb.transport(19.9);
        Integer actual = tb.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getTirePressure() {
        // Arrange
        Integer expected = 35;

        // Act
        Integer actual = tb.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void inflateTires() {
        // Arrange
        Integer expected = 35;

        // Act
        tb.transport(20.0 * 3);
        Integer tirePressureAfterTransport = tb.getTirePressure();

        tb.inflateTires();
        Integer actual = tb.getTirePressure();

        //Assert
        assertNotEquals(expected, tirePressureAfterTransport);
        assertEquals(expected, actual);
    }

    @Test
    public void recommendedTirePressure() {
        // Arrange
        Integer expected = 35;

        // Act
        Integer actual = tb.recommendedTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

  

  
}