package Vehicles;

import Driving.Car;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ToyotaSiennaTest {

    Car toyotaSienna = new ToyotaSienna();

    @Before
    public void setUp() throws Exception {
        this.toyotaSienna = new HondaCivic();
    }

    @Test
    public void needsOilChange() {
        // Arrange

        // Act
        Boolean newCivicNeedsOilChange = toyotaSienna.needsOilChange();
        // Assert
        assertFalse(newCivicNeedsOilChange);
    }

    @Test
    public void needsOilChangeAfterTravel() {
        // Arrange
        toyotaSienna.transport(50000.0);
        // Act
        Boolean needsOilAfter50kMiles = toyotaSienna.needsOilChange();
        // Assert
        assertTrue(needsOilAfter50kMiles);
    }

    @Test
    public void needsOilChangeAfterTravelThenOilChange() {
        // Arrange
        toyotaSienna.transport(50010.5);
        // Act
        toyotaSienna.changeOil();
        Boolean needsOilChangeAfterOilChange = toyotaSienna.needsOilChange();
        // Assert
        assertFalse(needsOilChangeAfterOilChange);
    }

    @Test
    public void needsOilChangeAfterOilChangeThenTravel49kMiles() {
        // Arrange
        toyotaSienna.transport(51000.0);
        // Act
        toyotaSienna.changeOil();
        toyotaSienna.transport(49000.0);
        Boolean oilNeedsChanging49kMiles = toyotaSienna.needsOilChange();

        // Assert
        assertFalse(oilNeedsChanging49kMiles);
    }

    @Test
    public void needsOilChangeAfterOilChangeThenTravel50kMiles() {
        // Arrange
        toyotaSienna.transport(51000.0);
        // Act
        toyotaSienna.changeOil();
        toyotaSienna.transport(50000.0);
        Boolean oilNeedsChanging50kMiles = toyotaSienna.needsOilChange();

        // Assert
        assertTrue(oilNeedsChanging50kMiles);
    }

    @Test
    public void checkEngineLight() {
        // Arrange
        toyotaSienna.transport(50000.0);
        // Act
        Boolean checkEngineLightIsOn = toyotaSienna.checkEngineLight();

        // Assert
        assertTrue(checkEngineLightIsOn);
    }

    @Test
    public void checkEngineLight2() {
        // Arrange
        toyotaSienna.transport(40000.0);
        // Act
        Boolean checkEngineLightIsOn =  toyotaSienna.checkEngineLight();

        // Assert
        assertFalse(checkEngineLightIsOn);
    }

    @Test
    public void getTopSpeed() {
        // Arrange
        Double expected = 70.0;
        // Act
        Double actual = toyotaSienna.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transport() {
        // Arrange
        Integer expected = 2 * 60 * 60;
        // Act
        Integer actual = toyotaSienna.transport(70.0 * 2);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getDistanceTraveled() {
        // Arrange
        Double expected = 300.0;
        // Act
        toyotaSienna.transport(300.0);
        Double actual = toyotaSienna.getDistanceTraveled();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getDistanceTraveledNewCar() {
        // Arrange
        Double expected = 0.0;
        // Act
        Double actual = toyotaSienna.getDistanceTraveled();

        // Assert
        assertEquals(expected, actual);
    }
}