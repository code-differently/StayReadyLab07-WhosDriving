package Vehicles;

import Driving.Car;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class FerraiTest {


    Car ferrai;

    @Before
    public void setUp() throws Exception {
        this.ferrai = new Ferrai();
    }

    @Test
    public void needsOilChange() {
        // Arrange

        // Act
        Boolean newCivicNeedsOilChange = ferrai.needsOilChange();
        // Assert
        assertFalse(newCivicNeedsOilChange);
    }

    @Test
    public void needsOilChangeAfterTravel() {
        // Arrange
        ferrai.transport(10000.0);
        // Act
        Boolean needsOilAfter50kMiles = ferrai.needsOilChange();
        // Assert
        assertTrue(needsOilAfter50kMiles);
    }

    @Test
    public void needsOilChangeAfterTravelThenOilChange() {
        // Arrange
        ferrai.transport(10010.5);
        // Act
        ferrai.changeOil();
        Boolean needsOilChangeAfterOilChange = ferrai.needsOilChange();
        // Assert
        assertFalse(needsOilChangeAfterOilChange);
    }

    @Test
    public void needsOilChangeAfterOilChangeThenTravel49kMiles() {
        // Arrange
        ferrai.transport(10000.0);
        // Act
        ferrai.changeOil();
        ferrai.transport(9000.0);
        Boolean oilNeedsChanging49kMiles = ferrai.needsOilChange();

        // Assert
        assertFalse(oilNeedsChanging49kMiles);
    }

    @Test
    public void needsOilChangeAfterOilChangeThenTravel50kMiles() {
        // Arrange
        ferrai.transport(11000.0);
        // Act
        ferrai.changeOil();
        ferrai.transport(10000.0);
        Boolean oilNeedsChanging50kMiles = ferrai.needsOilChange();

        // Assert
        assertTrue(oilNeedsChanging50kMiles);
    }

    @Test
    public void checkEngineLight() {
        // Arrange
        ferrai.transport(10000.0);
        // Act
        Boolean checkEngineLightIsOn = ferrai.checkEngineLight();

        // Assert
        assertTrue(checkEngineLightIsOn);
    }

    @Test
    public void checkEngineLight2() {
        // Arrange
        ferrai.transport(9000.0);
        // Act
        Boolean checkEngineLightIsOn = ferrai.checkEngineLight();

        // Assert
        assertFalse(checkEngineLightIsOn);
    }

    @Test
    public void getTopSpeed() {
        // Arrange
        Double expected = 205.0;
        // Act
        Double actual = ferrai.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transport() {
        // Arrange
        Integer expected = 7200;
        // Act
        Integer actual = ferrai.transport(205.0 * 2);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getDistanceTraveled() {
        // Arrange
        Double expected = 300.0;
        // Act
        ferrai.transport(300.0);
        Double actual = ferrai.getDistanceTraveled();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getDistanceTraveledNewCar() {
        // Arrange
        Double expected = 0.0;
        // Act
        Double actual = ferrai.getDistanceTraveled();

        // Assert
        assertEquals(expected, actual);
    }
}
