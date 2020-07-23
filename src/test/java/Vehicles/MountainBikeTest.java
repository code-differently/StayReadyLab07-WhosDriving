package Vehicles;

import Driving.Bike;
import org.junit.Assert;
import org.junit.Test;



public class MountainBikeTest {
    Bike mountainBike = new MountainBike();


    @Test
    public void getTopSpeed() {
        // Arrange
        Double expected = 28.5;

        // Act
        Double actual = mountainBike.getTopSpeed();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTopSpeedAfterTransport() {
        // Arrange
        Double expected = 26.5;

        // Act
        mountainBike.transport(30.0);
        mountainBike.transport(30.0);
        Double actual = mountainBike.getTopSpeed();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTopSpeedAfterTransportThenInflateTires() {
        // Arrange
        Double expected = 28.5;

        // Act
        mountainBike.transport(30 * 2.0);
        mountainBike.inflateTires();
        Double actual = mountainBike.getTopSpeed();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void transport() {
        // Arrange
        Integer expected = (60 * 60);

        // Act
        Integer actual = mountainBike.transport(28.5);

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure() {
        // Arrange
        Integer expected = 28;

        // Act
        mountainBike.transport(30.0 * 2);
        Integer actual = mountainBike.getTirePressure();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure2() {
        // Arrange
        Integer expected = 27;

        // Act
        mountainBike.transport(30.0 * 3);
        Integer actual = mountainBike.getTirePressure();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure3() {
        // Arrange
        Integer expected = 20;

        // Act
        mountainBike.transport(30.0 * 100);
        mountainBike.transport(30.0 * 2);
        Integer actual = mountainBike.getTirePressure();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure4() {
        // Arrange
        Integer expected = 30;

        // Act
        mountainBike.transport(29.9);
        mountainBike.transport(29.9);
        mountainBike.transport(29.9);
        mountainBike.transport(29.9);
        mountainBike.transport(29.9);
        mountainBike.transport(29.9);
        Integer actual = mountainBike.getTirePressure();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTirePressure() {
        // Arrange
        Integer expected = 30;

        // Act
        Integer actual = mountainBike.getTirePressure();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void inflateTires() {
        // Arrange
        Integer expected = 30;

        // Act
        mountainBike.transport(30.0 * 3);
        Integer tirePressureAfterTransport = mountainBike.getTirePressure();

        mountainBike.inflateTires();
        Integer actual = mountainBike.getTirePressure();

        // Assert
        Assert.assertNotEquals(expected, tirePressureAfterTransport);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void recommendedTirePressure() {
        // Arrange
        Integer expected = 30;

        // Act
        Integer actual = mountainBike.recommendedTirePressure();

        // Assert
        Assert.assertEquals(expected, actual);
    }
}