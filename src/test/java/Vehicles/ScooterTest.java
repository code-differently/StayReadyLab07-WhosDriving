package Vehicles;
import Driving.Bike;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ScooterTest {
    Bike ss;

    @Before
    public void setUp() throws Exception {
        this.ss = new MountainBike();
    }

    @Test
    public void getTopSpeed() {
        // Arrange
        Double expected = 28.5;

        // Act
        Double actual = ss.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getTopSpeedAfterTransport() {
        // Arrange
        Double expected = 26.5;

        // Act
        ss.transport(30.0);
        ss.transport(30.0);
        Double actual = ss.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getTopSpeedAfterTransportThenInflateTires() {
        // Arrange
        Double expected = 28.5;

        // Act
        ss.transport(30 * 2.0);
        ss.inflateTires();
        Double actual = ss.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transport() {
        // Arrange
        Integer expected = (60 * 60);

        // Act
        Integer actual = ss.transport(28.5);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure() {
        // Arrange
        Integer expected = 28;

        // Act
        ss.transport(30.0 * 2);
        Integer actual = ss.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure2() {
        // Arrange
        Integer expected = 27;

        // Act
        ss.transport(30.0 * 3);
        Integer actual = ss.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure3() {
        // Arrange
        Integer expected = 20;

        // Act
        ss.transport(30.0 * 100);
        ss.transport(30.0 * 2);
        Integer actual = ss.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure4() {
        // Arrange
        Integer expected = 30;

        // Act
        ss.transport(29.9);
        ss.transport(29.9);
        ss.transport(29.9);
        ss.transport(29.9);
        ss.transport(29.9);
        ss.transport(29.9);
        Integer actual = ss.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getTirePressure() {
        // Arrange
        Integer expected = 30;

        // Act
        Integer actual = ss.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void inflateTires() {
        // Arrange
        Integer expected = 30;

        // Act
        ss.transport(30.0 * 3);
        Integer tirePressureAfterTransport = ss.getTirePressure();

        ss.inflateTires();
        Integer actual = ss.getTirePressure();

        // Assert
        assertNotEquals(expected, tirePressureAfterTransport);
        assertEquals(expected, actual);
    }

    @Test
    public void recommendedTirePressure() {
        // Arrange
        Integer expected = 30;

        // Act
        Integer actual = ss.recommendedTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

}
