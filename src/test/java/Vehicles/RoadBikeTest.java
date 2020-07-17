package Vehicles;

import Driving.Bike;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RoadBikeTest {
    Bike rb;
    @Before
    public void setUp() throws Exception {
        this.rb = new RoadBike();
    }

    @Test
    public void getTopSpeed() {
        // Arrange
        Double expected = 40.0;
        // Act
        Double actual = rb.getTopSpeed();
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getTopSpeedAfterTransport() {
        // Arrange
        Double expected = 38.0;
        // Act
        rb.transport(50.0);
        rb.transport(50.0);
        Double actual = rb.getTopSpeed();
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getTopSpeedAfterTransportThenInflateTires() {
        // Arrange
        Double expected = 40.0;
        // Act
        rb.transport(50 * 2.0);
        rb.inflateTires();
        Double actual = rb.getTopSpeed();
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transport() {
        // Arrange
        Integer expected = (60 * 60);
        // Act
        Integer actual = rb.transport(40.0);
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure() {
        // Arrange
        Integer expected = 48;
        // Act
        rb.transport(50.0 * 2);
        Integer actual = rb.getTirePressure();
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure2() {
        // Arrange
        Integer expected = 47;
        // Act
        rb.transport(50.0 * 3);
        Integer actual = rb.getTirePressure();
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure3() {
        // Arrange
        Integer expected = 40;
        // Act
        rb.transport(50.0 * 100);
        rb.transport(50.0 * 2);
        Integer actual = rb.getTirePressure();
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure4() {
        // Arrange
        Integer expected = 50;
        // Act
        rb.transport(49.9);
        rb.transport(49.9);
        rb.transport(49.9);
        rb.transport(49.9);
        rb.transport(49.9);
        rb.transport(49.9);
        Integer actual = rb.getTirePressure();
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getTirePressure() {
        // Arrange
        Integer expected = 50;
        // Act
        Integer actual = rb.getTirePressure();
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void inflateTires() {
        // Arrange
        Integer expected = 50;
        // Act
        rb.transport(50.0 * 3);
        Integer tirePressureAfterTransport = rb.getTirePressure();
        rb.inflateTires();
        Integer actual = rb.getTirePressure();
        // Assert
        assertNotEquals(expected, tirePressureAfterTransport);
        assertEquals(expected, actual);
    }

    @Test
    public void recommendedTirePressure() {
        // Arrange
        Integer expected = 50;
        // Act
        Integer actual = rb.recommendedTirePressure();
        // Assert
        assertEquals(expected, actual);
    }
}
