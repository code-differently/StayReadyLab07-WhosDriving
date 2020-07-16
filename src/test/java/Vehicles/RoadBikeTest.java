package Vehicles;

import Driving.Bike;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class RoadBikeTest {
    Bike mb;
    RoadBike bike;

    @Before
    public void setUp() throws Exception {
        this.mb = new RoadBike();
        this.bike = new RoadBike();
    }

    @Test
    public void getTopSpeed() {
        // Arrange
        Double expected = 15.0;

        // Act
        Double actual = mb.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getTopSpeedAfterTransport() {
        // Arrange
        Double expected = 10.0;

        // Act
        mb.transport(60.0 * 2.0);
        mb.transport(60.0* 3.0);
        Double actual = mb.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getTopSpeedAfterTransportThenInflateTires() {
        // Arrange
        Double expected = 15.0;

        // Act
        mb.transport(60 * 2.0);
        mb.inflateTires();
        Double actual = mb.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transport() {
        // Arrange
        Integer expected = 7200;

        // Act
        Integer actual = mb.transport(30.0);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure() {
        // Arrange
        Integer expected = 13;

        // Act
        mb.transport(60.0 * 2);
        Integer actual = mb.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure2() {
        // Arrange
        Integer expected = 12;

        // Act
        mb.transport(60.0 * 3);
        Integer actual = mb.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure3() {
        // Arrange
        Integer expected = 10;

        // Act
        mb.transport(60.0 * 100);
        mb.transport(60.0 * 2);
        Integer actual = mb.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure4() {
        // Arrange
        Integer expected = 15;

        // Act
        mb.transport(59.9);
        mb.transport(59.9);
        mb.transport(59.9);
        mb.transport(59.9);
        mb.transport(59.9);
        mb.transport(59.9);
        Integer actual = mb.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getTirePressure() {
        // Arrange
        Integer expected = 15;

        // Act
        Integer actual = mb.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void inflateTires() {
        // Arrange
        Integer expected = 15;

        // Act
        mb.transport(60.0 * 3);
        Integer tirePressureAfterTransport = mb.getTirePressure();

        mb.inflateTires();
        Integer actual = mb.getTirePressure();

        // Assert
        assertNotEquals(expected, tirePressureAfterTransport);
        assertEquals(expected, actual);
    }

    @Test
    public void recommendedTirePressure() {
        // Arrange
        Integer expected = 15;

        // Act
        Integer actual = mb.recommendedTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getActualTirePressureTest(){
        double expected = 15.0;

        double actual = bike.getActualTirePressure();

        assertEquals(expected, actual, 0.0);

    }

    @Test
    public void setActualTirePressureTest(){
        double expected = 12;

        bike.setActualTirePressure(12);
        double actual = bike.getActualTirePressure();

        assertEquals(expected, actual, 0.0);

    }

    @Test
    public void getActualSpeedTest(){
        double expected = 15.0;

        double actual = bike.getActualSpeed();

        assertEquals(expected, actual, 0.0);

    }

    @Test
    public void setActualSpeedTest(){
        double expected = 17.0;

        bike.setActualSpeed(17.0);
        double actual = bike.getActualSpeed();

        assertEquals(expected, actual, 0.0);

    }
}
