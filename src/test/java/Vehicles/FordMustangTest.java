package Vehicles;

import Driving.Car;

import org.junit.Before;

import org.junit.Test;

import static org.junit.Assert.*;
public class FordMustangTest {
    Car fordMustang = new FordMustang();
    @Before
    public void setUp() throws Exception {
        this.fordMustang = new FordMustang();
    }
    @Test
    public void needsOilChange() {
        // Arrange
        // Act
        Boolean newMustangNeedsOilChange = fordMustang.needsOilChange();
        // Assert
        assertFalse(newMustangNeedsOilChange);
    }
    @Test
    public void needsOilChangeAfterTravel() {
        // Arrange
        fordMustang.transport(35000.0);
        // Act
        Boolean needsOilAfter35kMiles = fordMustang.needsOilChange();
        // Assert
        assertTrue(needsOilAfter35kMiles);
    }
    @Test
    public void needsOilChangeAfterTravelThenOilChange() {
        // Arrange
        fordMustang.transport(35010.5);
        // Act
        fordMustang.changeOil();
        Boolean needsOilChangeAfterOilChange = fordMustang.needsOilChange();
        // Assert
        assertFalse(needsOilChangeAfterOilChange);
    }
    @Test
    public void needsOilChangeAfterOilChangeThenTravel34kMiles() {
        // Arrange
        fordMustang.transport(36000.0);
        // Act
        fordMustang.changeOil();
        fordMustang.transport(34000.0);
        Boolean oilNeedsChanging49kMiles = fordMustang.needsOilChange();
        // Assert
        assertFalse(oilNeedsChanging49kMiles);
    }
    @Test
    public void needsOilChangeAfterOilChangeThenTravel35kMiles() {
        // Arrange
        fordMustang.transport(36000.0);
        // Act
        fordMustang.changeOil();
        fordMustang.transport(35000.0);
        Boolean oilNeedsChanging35kMiles = fordMustang.needsOilChange();
        // Assert
        assertTrue(oilNeedsChanging35kMiles);
    }
    @Test
    public void checkEngineLight() {
        // Arrange
        fordMustang.transport(35000.0);
        // Act
        Boolean checkEngineLightIsOn = fordMustang.checkEngineLight();
        // Assert
        assertTrue(checkEngineLightIsOn);
    }
    @Test
    public void checkEngineLight2() {
        // Arrange
        fordMustang.transport(25000.0);
        // Act
        Boolean checkEngineLightIsOn = fordMustang.checkEngineLight();
        // Assert
        assertFalse(checkEngineLightIsOn);
    }
    @Test
    public void getTopSpeed() {
        // Arrange
        Double expected = 100.0;
        // Act
        Double actual = fordMustang.getTopSpeed();
        // Assert
        assertEquals(expected, actual);
    }
    @Test
    public void transport() {
        // Arrange
        Integer expected = 2 * 60 * 60;
        // Act
        Integer actual = fordMustang.transport(100.0 * 2);
        // Assert
        assertEquals(expected, actual);
    }
    @Test
    public void getDistanceTraveled() {
        // Arrange
        Double expected = 300.0;
        // Act
        fordMustang.transport(300.0);
        Double actual = fordMustang.getDistanceTraveled();
        // Assert
        assertEquals(expected, actual);
    }
    @Test
    public void getDistanceTraveledNewCar() {
        // Arrange
        Double expected = 0.0;
        // Act
        Double actual = fordMustang.getDistanceTraveled();
        // Assert
        assertEquals(expected, actual);
    }
}