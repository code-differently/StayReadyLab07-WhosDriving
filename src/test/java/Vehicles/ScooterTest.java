package Vehicles;

import Driving.Bike;
import org.junit.Assert;
import org.junit.Test;



public class ScooterTest {
    Bike scooter = new Scooter();


    @Test
    public void getTopSpeed() {
        // Arrange
        Double expected = 28.5;
        // Act
        Double actual = scooter.getTopSpeed();
        // Assert
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getTopSpeedAfterTransport() {
        // Arrange
        Double expected = 26.5;
        // Act
        scooter.transport(30.0);
        scooter.transport(30.0);
        Double actual = scooter.getTopSpeed();
        // Assert
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getTopSpeedAfterTransportThenInflateTires() {
        // Arrange
        Double expected = 28.5;
        // Act
        scooter.transport(30 * 2.0);
        scooter.inflateTires();
        Double actual = scooter.getTopSpeed();
        // Assert
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void transport() {
        // Arrange
        Integer expected = (60 * 60);
        // Act
        Integer actual = scooter.transport(28.5);
        // Assert
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void transportTirePressure() {
        // Arrange
        Integer expected = 28;
        // Act
        scooter.transport(30.0 * 2);
        Integer actual = scooter.getTirePressure();
        // Assert
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void transportTirePressure2() {
        // Arrange
        Integer expected = 27;
        // Act
        scooter.transport(30.0 * 3);
        Integer actual = scooter.getTirePressure();
        // Assert
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void transportTirePressure3() {
        // Arrange
        Integer expected = 20;
        // Act
        scooter.transport(30.0 * 100);
        scooter.transport(30.0 * 2);
        Integer actual = scooter.getTirePressure();
        // Assert
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void transportTirePressure4() {
        // Arrange
        Integer expected = 30;
        // Act
        scooter.transport(29.9);
        scooter.transport(29.9);
        scooter.transport(29.9);
        scooter.transport(29.9);
        scooter.transport(29.9);
        scooter.transport(29.9);
        Integer actual = scooter.getTirePressure();
        // Assert
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getTirePressure() {
        // Arrange
        Integer expected = 30;
        // Act
        Integer actual = scooter.getTirePressure();
        // Assert
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void inflateTires() {
        // Arrange
        Integer expected = 30;
        // Act
        scooter.transport(30.0 * 3);
        Integer tirePressureAfterTransport = scooter.getTirePressure();
        scooter.inflateTires();
        Integer actual = scooter.getTirePressure();
        // Assert
        Assert.assertNotEquals(expected, tirePressureAfterTransport);
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void recommendedTirePressure() {
        // Arrange
        Integer expected = 30;
        // Act
        Integer actual = scooter.recommendedTirePressure();
        // Assert
        Assert.assertEquals(expected, actual);
    }
}