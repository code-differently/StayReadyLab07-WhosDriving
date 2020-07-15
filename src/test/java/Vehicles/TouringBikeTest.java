package Vehicles;

import Driving.Bike;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TouringBikeTest {
    Bike tb;

    @Before
    public void setUp() throws Exception {
        this.tb = new TouringBike();
    }

    @Test
    public void getTopSpeed() {
        // Arrange
        Double expected = 36.5;

        // Act
        Double actual = tb.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getTopSpeedAfterTransport() {
        // Arrange
        Double expected = 34.5;

        // Act
        tb.transport(50.0);
        tb.transport(50.0);
        Double actual = tb.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getTopSpeedAfterTransportThenInflateTires() {
        // Arrange
        Double expected = 36.5;

        // Act
        tb.transport(50 * 2.0);
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
        Integer actual = tb.transport(34.5);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure() {
        // Arrange
        Integer expected = 38;

        // Act
        tb.transport(50.0 * 2);
        Integer actual = tb.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure2() {
        // Arrange
        Integer expected = 37;

        // Act
        tb.transport(50.0 * 3);
        Integer actual = tb.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure3() {
        // Arrange
        Integer expected = 30;

        // Act
        tb.transport(50.0 * 100);
        tb.transport(50.0 * 2);
        Integer actual = tb.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure4() {
        // Arrange
        Integer expected = 40;

        // Act
        tb.transport(49.9);
        tb.transport(49.9);
        tb.transport(49.9);
        tb.transport(49.9);
        tb.transport(49.9);
        tb.transport(49.9);
        Integer actual = tb.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getTirePressure() {
        // Arrange
        Integer expected = 40;

        // Act
        Integer actual = tb.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void inflateTires() {
        // Arrange
        Integer expected = 40;

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
        Integer expected = 40;

        // Act
        Integer actual = tb.recommendedTirePressure();

        // Assert
        assertEquals(expected, actual);
    }
}
