package test.java.Vehicles;

import Driving.Car;
import main.java.Vehicles.KiaOptima;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class KiaOptimaTest {

    Car kiaOptima = new KiaOptima();
    KiaOptima kia = new KiaOptima();

    @Before
    public void setUp() throws Exception {
        this.kiaoptima = new KiaOptima();
        this.kiaOptima = new KiaOptima();
    }

    @Test
    public void getNeedsOilChangeTest() {
        boolean expected = false;

        boolean actual = kia.getNeedsOilChange();

        assertEquals(expected, actual);
    }

    @Test
    public void setNeedsOilChangeTest() {
        boolean expected = true;

        kia.setNeedsOilChange(true);
        boolean actual = kia.getNeedsOilChange();

        assertEquals(expected, actual);
    }

    @Test
    public void getTotalDistanceTest() {
        double expected = 0.0;

        double actual = kia.getTotalDistance();

        assertEquals(expected, actual, 0.0);
    }

    @Test
    public void setTotalDistanceTest() {
        double expected = 25.0;

        kia.setTotalDistance(25.0);
        double actual = kia.getTotalDistance();

        assertEquals(expected, actual, 0.0);
    }

    @Test
    public void getPreviousDistanceTest() {
        double expected = 0.0;

        double actual = kia.getPreviousDistance();

        assertEquals(expected, actual, 0.0);
    }

    @Test
    public void setPreviousDistanceTest() {
        double expected = 25.0;

        kia.setPreviousDistance(25.0);
        double actual = kia.getPreviousDistance();

        assertEquals(expected, actual, 0.0);
    }

    @Test
    public void getNumTripsTest() {
        double expected = 0.0;

        double actual = kia.getNumTrips();

        assertEquals(expected, actual, 0.0);
    }

    @Test
    public void setNumTripsTest() {
        int expected = 2;

        kia.setNumTrips(2);
        int actual = kia.getNumTrips();

        assertEquals(expected, actual, 0.0);
    }

    @Test
    public void needsOilChange() {
        // Arrange

        // Act
        Boolean newOptimaNeedsOilChange = kiaOptima.needsOilChange();
        // Assert
        assertFalse(newOptimaNeedsOilChange);
    }

    @Test
    public void needsOilChangeAfterTravel() {
        // Arrange
        kiaOptima.transport(50000.0);
        // Act
        Boolean needsOilAfter50kMiles = kiaOptima.needsOilChange();
        // Assert
        assertTrue(needsOilAfter50kMiles);
    }

    @Test
    public void needsOilChangeAfterTravelThenOilChange() {
        // Arrange
        kiaOptima.transport(50010.5);
        // Act
        kiaOptima.changeOil();
        Boolean needsOilChangeAfterOilChange = kiaOptima.needsOilChange();
        // Assert
        assertFalse(needsOilChangeAfterOilChange);
    }

    @Test
    public void needsOilChangeAfterOilChangeThenTravel49kMiles() {
        // Arrange
        kiaOptima.transport(51000.0);
        // Act
        kiaOptima.changeOil();
        kiaOptima.transport(49000.0);
        Boolean oilNeedsChanging49kMiles = kiaOptima.needsOilChange();

        // Assert
        assertFalse(oilNeedsChanging49kMiles);
    }

    @Test
    public void needsOilChangeAfterOilChangeThenTravel50kMiles() {
        // Arrange
        kiaOptima.transport(51000.0);
        // Act
        kiaOptima.changeOil();
        kiaOptima.transport(50000.0);
        Boolean oilNeedsChanging50kMiles = kiaOptima.needsOilChange();

        // Assert
        assertTrue(oilNeedsChanging50kMiles);
    }

    @Test
    public void checkEngineLight() {
        // Arrange
        kiaOptima.transport(50000.0);
        // Act
        Boolean checkEngineLightIsOn = kiaOptima.checkEngineLight();

        // Assert
        assertTrue(checkEngineLightIsOn);
    }

    @Test
    public void checkEngineLight2() {
        // Arrange
        kiaOptima.transport(40000.0);
        // Act
        Boolean checkEngineLightIsOn = kiaOptima.checkEngineLight();

        // Assert
        assertFalse(checkEngineLightIsOn);
    }

    @Test
    public void getTopSpeed() {
        // Arrange
        Double expected = 70.0;
        // Act
        Double actual = kiaOptima.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transport() {
        // Arrange
        Integer expected = 2 * 60 * 60;
        // Act
        Integer actual = kiaOptima.transport(70.0 * 2);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getDistanceTraveled() {
        // Arrange
        Double expected = 300.0;
        // Act
        kiaOptima.transport(300.0);
        Double actual = kiaOptima.getDistanceTraveled();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getDistanceTraveledNewCar() {
        // Arrange
        Double expected = 0.0;
        // Act
        Double actual = kiaOptima.getDistanceTraveled();

        // Assert
        assertEquals(expected, actual);
    }
}