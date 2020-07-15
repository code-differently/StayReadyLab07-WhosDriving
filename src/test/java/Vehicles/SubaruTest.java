package Vehicles;

import Driving.Car;
import Driving.Drivable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SubaruTest 
{

    Car subaru = new Subaru();

    @Before
    public void setUp() throws Exception {
        this.subaru = new Subaru();
    }

    @Test
    public void needsOilChange() {
        // Arrange

        // Act
        Boolean newCivicNeedsOilChange = subaru.needsOilChange();
        // Assert
        assertFalse(newCivicNeedsOilChange);
    }

    @Test
    public void needsOilChangeAfterTravel() {
        // Arrange
        subaru.transport(50000.0);
        // Act
        Boolean needsOilAfter50kMiles = subaru.needsOilChange();
        // Assert
        assertTrue(needsOilAfter50kMiles);
    }

    @Test
    public void needsOilChangeAfterTravelThenOilChange() {
        // Arrange
        subaru.transport(50010.5);
        // Act
        subaru.changeOil();
        Boolean needsOilChangeAfterOilChange = subaru.needsOilChange();
        // Assert
        assertFalse(needsOilChangeAfterOilChange);
    }

    @Test
    public void needsOilChangeAfterOilChangeThenTravel49kMiles() {
        // Arrange
        subaru.transport(51000.0);
        // Act
        subaru.changeOil();
        subaru.transport(49000.0);
        Boolean oilNeedsChanging49kMiles = subaru.needsOilChange();

        // Assert
        assertFalse(oilNeedsChanging49kMiles);
    }

    @Test
    public void needsOilChangeAfterOilChangeThenTravel50kMiles() {
        // Arrange
        subaru.transport(51000.0);
        // Act
        subaru.changeOil();
        subaru.transport(50000.0);
        Boolean oilNeedsChanging50kMiles = subaru.needsOilChange();

        // Assert
        assertTrue(oilNeedsChanging50kMiles);
    }

    @Test
    public void checkEngineLight() {
        // Arrange
        subaru.transport(50000.0);
        // Act
        Boolean checkEngineLightIsOn = subaru.checkEngineLight();

        // Assert
        assertTrue(checkEngineLightIsOn);
    }

    @Test
    public void checkEngineLight2() {
        // Arrange
        subaru.transport(40000.0);
        // Act
        Boolean checkEngineLightIsOn = subaru.checkEngineLight();

        // Assert
        assertFalse(checkEngineLightIsOn);
    }

    @Test
    public void getTopSpeed() {
        // Arrange
        Double expected = 70.0;
        // Act
        Double actual = subaru.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transport() {
        // Arrange
        Integer expected = 2 * 60 * 60;
        // Act
        Integer actual = subaru.transport(70.0 * 2);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getDistanceTraveled() {
        // Arrange
        Double expected = 300.0;
        // Act
        subaru.transport(300.0);
        Double actual = subaru.getDistanceTraveled();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getDistanceTraveledNewCar() {
        // Arrange
        Double expected = 0.0;
        // Act
        Double actual = subaru.getDistanceTraveled();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void isItACar()
    {
        assertTrue(subaru instanceof Car);
    }

    @Test
    public void isItADrivable()
    {
        assertTrue(subaru instanceof Drivable);
    }
}