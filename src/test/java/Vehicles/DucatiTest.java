package Vehicles;

import Driving.Bike;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DucatiTest {

    Bike du;

    @Before
    public void setUp() throws Exception {
        this.du = new Ducati();
    }

    @Test
    public void getTopSpeed() {
        // Arrange
        Double expected = 202.0;

        // Act
        Double actual = du.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getTopSpeedAfterTransport() {
        // Arrange
        Double expected = 200.0;

        // Act
        du.transport(30.0);
        du.transport(30.0);
        Double actual = du.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getTopSpeedAfterTransportThenInflateTires() {
        // Arrange
        Double expected = 202.0;

        // Act
        du.transport(30 * 2.0);
        du.inflateTires();
        Double actual = du.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transport() {
        // Arrange
        Integer expected = (3600);

        // Act
        Integer actual = du.transport(202.0);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure() {
        // Arrange
        Integer expected = 28;

        // Act
        du.transport(30.0 * 2);
        Integer actual = du.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure2() {
        // Arrange
        Integer expected = 27;

        // Act
        du.transport(30.0 * 3);
        Integer actual = du.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure3() {
        // Arrange
        Integer expected = 20;

        // Act
        du.transport(30.0 * 100);
        du.transport(30.0 * 2);
        Integer actual = du.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure4() {
        // Arrange
        Integer expected = 30;

        // Act
        du.transport(29.9);
        du.transport(29.9);
        du.transport(29.9);
        du.transport(29.9);
        du.transport(29.9);
        du.transport(29.9);
        Integer actual = du.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getTirePressure() {
        // Arrange
        Integer expected = 30;

        // Act
        Integer actual = du.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void inflateTires() {
        // Arrange
        Integer expected = 30;

        // Act
        du.transport(30.0 * 3);
        Integer tirePressureAfterTransport = du.getTirePressure();

        du.inflateTires();
        Integer actual = du.getTirePressure();

        // Assert
        assertNotEquals(expected, tirePressureAfterTransport);
        assertEquals(expected, actual);
    }

    @Test
    public void recommendedTirePressure() {
        // Arrange
        Integer expected = 30;

        // Act
        Integer actual = du.recommendedTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

}
