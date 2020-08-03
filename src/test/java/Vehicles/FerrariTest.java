package Vehicles;

import Driving.Car;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FerrariTest {

    Car Rari = new Rari();

    @Before
    public void setUp() throws Exception {
        this.Rari = new Rari();
    }

    @Test
    public void needsOilChange() {
        // Arrange

        // Act
        Boolean newRariNeedsOilChange = Rari.needsOilChange();
        // Assert
        assertFalse(newRariNeedsOilChange);
    }

    @Test
    public void needsOilChangeAfterTravel() {
        // Arrange
        Rari.transport(5000.0);
        // Act
        Boolean needsOilAfter5kMiles = Rari.needsOilChange();
        // Assert
        assertTrue(needsOilAfter5kMiles);
    }

    @Test
    public void needsOilChangeAfterTravelThenOilChange() {
        // Arrange
        Rari.transport(5001.5);
        // Act
        Rari.changeOil();
        Boolean needsOilChangeAfterOilChange = Rari.needsOilChange();
        // Assert
        assertFalse(needsOilChangeAfterOilChange);
    }

    @Test
    public void needsOilChangeAfterOilChangeThenTravel4kMiles() {
        // Arrange
        Rari.transport(5100.0);
        // Act
        Rari.changeOil();
        Rari.transport(4900.0);
        Boolean oilNeedsChanging49kMiles = Rari.needsOilChange();

        // Assert
        assertFalse(oilNeedsChanging49kMiles);
    }

    @Test
    public void needsOilChangeAfterOilChangeThenTravel50kMiles() {
        // Arrange
        Rari.transport(51000.0);
        // Act
        Rari.changeOil();
        Rari.transport(50000.0);
        Boolean oilNeedsChanging50kMiles = Rari.needsOilChange();

        // Assert
        assertTrue(oilNeedsChanging50kMiles);
    }

    @Test
    public void checkEngineLight() {
        // Arrange
        Rari.transport(50000.0);
        // Act
        Boolean checkEngineLightIsOn = Rari.checkEngineLight();

        // Assert
        assertTrue(checkEngineLightIsOn);
    }

    @Test
    public void checkEngineLight2() {
        // Arrange
        Rari.transport(4000.0);
        // Act
        Boolean checkEngineLightIsOn = Rari.checkEngineLight();

        // Assert
        assertFalse(checkEngineLightIsOn);
    }

    @Test
    public void getTopSpeed() {
        // Arrange
        Double expected = 140.0;
        // Act
        Double actual = Rari.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transport() {
        // Arrange
        Integer expected = 2 * 60 * 60;
        // Act
        Integer actual = Rari.transport(140.0 * 2);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getDistanceTraveled() {
        // Arrange
        Double expected = 300.0;
        // Act
        Rari.transport(300.0);
        Double actual = Rari.getDistanceTraveled();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getDistanceTraveledNewCar() {
        // Arrange
        Double expected = 0.0;
        // Act
        Double actual = Rari.getDistanceTraveled();

        // Assert
        assertEquals(expected, actual);
    }
}