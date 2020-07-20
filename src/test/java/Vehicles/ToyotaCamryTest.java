package Vehicles;

import Driving.Car;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ToyotaCamryTest {
    
    Car toyotaCamry = new ToyotaCamry();

    @Before
    public void setUp() throws Exception {
        this.toyotaCamry = new ToyotaCamry();
    }

    @Test
    public void needsOilChange() {
        // Arrange

        // Act
        Boolean newCivicNeedsOilChange = toyotaCamry.needsOilChange();
        // Assert
        assertFalse(newCivicNeedsOilChange);
    }

    @Test
    public void needsOilChangeAfterTravel() {
        // Arrange
        toyotaCamry.transport(50000.0);
        // Act
        Boolean needsOilAfter50kMiles = toyotaCamry.needsOilChange();
        // Assert
        assertTrue(needsOilAfter50kMiles);
    }

    @Test
    public void needsOilChangeAfterTravelThenOilChange() {
        // Arrange
        toyotaCamry.transport(50010.5);
        // Act
        toyotaCamry.changeOil();
        Boolean needsOilChangeAfterOilChange = toyotaCamry.needsOilChange();
        // Assert
        assertFalse(needsOilChangeAfterOilChange);
    }

    @Test
    public void needsOilChangeAfterOilChangeThenTravel49kMiles() {
        // Arrange
        toyotaCamry.transport(51000.0);
        // Act
        toyotaCamry.changeOil();
        toyotaCamry.transport(49000.0);
        Boolean oilNeedsChanging49kMiles = toyotaCamry.needsOilChange();

        // Assert
        assertFalse(oilNeedsChanging49kMiles);
    }

    @Test
    public void needsOilChangeAfterOilChangeThenTravel50kMiles() {
        // Arrange
        toyotaCamry.transport(51000.0);
        // Act
        toyotaCamry.changeOil();
        toyotaCamry.transport(50000.0);
        Boolean oilNeedsChanging50kMiles = toyotaCamry.needsOilChange();

        // Assert
        assertTrue(oilNeedsChanging50kMiles);
    }

    @Test
    public void checkEngineLight() {
        // Arrange
        toyotaCamry.transport(50000.0);
        // Act
        Boolean checkEngineLightIsOn = toyotaCamry.checkEngineLight();

        // Assert
        assertTrue(checkEngineLightIsOn);
    }

    @Test
    public void checkEngineLight2() {
        // Arrange
        toyotaCamry.transport(40000.0);
        // Act
        Boolean checkEngineLightIsOn = toyotaCamry.checkEngineLight();

        // Assert
        assertFalse(checkEngineLightIsOn);
    }

    @Test
    public void getTopSpeed() {
        // Arrange
        Double expected = 75.0;
        // Act
        Double actual = toyotaCamry.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transport() {
        // Arrange
        Integer expected = 2 * 60 * 60;
        // Act
        Integer actual = toyotaCamry.transport(75.0 * 2);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getDistanceTraveled() {
        // Arrange
        Double expected = 300.0;
        // Act
        toyotaCamry.transport(300.0);
        Double actual = toyotaCamry.getDistanceTraveled();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getDistanceTraveledNewCar() {
        // Arrange
        Double expected = 0.0;
        // Act
        Double actual = toyotaCamry.getDistanceTraveled();

        // Assert
        assertEquals(expected, actual);
    }
}