package Vehicles;

import Driving.Bike;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FixieBikeTest {
    Bike fixie;

    @Before
    public void setUp() throws Exception {
        this.fixie = new FixieBike();
    }

    @Test
    public void getTopSpeed() {
        // Arrange
        Double expected = 60.0;

        // Act
        Double actual = fixie.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getTopSpeedAfterTransport() {
        // Arrange
        Double expected = 60.0;

        // Act
        fixie.transport(30.0);
        fixie.transport(30.0);
        Double actual = fixie.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getTopSpeedAfterTransportThenInflateTires() {
        // Arrange
        Double expected = 60.0;

        // Act
        fixie.transport(30 * 2.0);
        fixie.inflateTires();
        Double actual = fixie.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transport() {
        // Arrange
        Integer expected = (1710);

        // Act
        Integer actual = fixie.transport(28.5);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure() {
        // Arrange
        Integer expected = 100;

        // Act
        fixie.transport(30.0 * 2);
        Integer actual = fixie.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure2() {
        // Arrange
        Integer expected = 100;

        // Act
        fixie.transport(30.0 * 3);
        Integer actual = fixie.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure3() {
        // Arrange
        Integer expected = 20;

        // Act
        fixie.transport(60.0 * 100);
        fixie.transport(80.0 * 2);
        Integer actual = fixie.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure4() {
        // Arrange
        Integer expected = 76;

        // Act
        fixie.transport(109.9);
        fixie.transport(109.9);
        fixie.transport(109.9);
        fixie.transport(109.9);
        fixie.transport(109.9);
        fixie.transport(100.9);
        Integer actual = fixie.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getTirePressure() {
        // Arrange
        Integer expected = 100;

        // Act
        Integer actual = fixie.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void inflateTires() {
        // Arrange
        Integer expected = 100;

        // Act
        fixie.transport(30.0 * 3);
        Integer tirePressureAfterTransport = fixie.getTirePressure();

        fixie.inflateTires();
        Integer actual = fixie.getTirePressure();

        // Assert
        assertNotEquals(expected, tirePressureAfterTransport);
        assertEquals(expected, actual);
    }

    @Test
    public void recommendedTirePressure() {
        // Arrange
        Integer expected = 100;

        // Act
        Integer actual = fixie.recommendedTirePressure();

        // Assert
        assertEquals(expected, actual);
    }
}