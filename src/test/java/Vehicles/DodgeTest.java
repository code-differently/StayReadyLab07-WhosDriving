package Vehicles;

import Driving.Car;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DodgeTest {

    Car Dodge = new Dodge();

    @Before
    public void setUp() throws Exception {
        this.Dodge = new Dodge();
    }

    @Test
    public void needsOilChange() {
        // Arrange

        // Act
        Boolean newCivicNeedsOilChange = Dodge.needsOilChange();

        // Assert
        assertFalse(newCivicNeedsOilChange);
    }

    @Test
    public void needsOilChangeAfterTravel() {
        // Arrange
        Dodge.transport(50000.0);

        // Act
        Boolean needsOilAfter50kMiles = Dodge.needsOilChange();

        // Assert
        assertTrue(needsOilAfter50kMiles);
    }

    @Test
    public void needsOilChangeAfterTravelThenOilChange() {
        // Arrange
        Dodge.transport(50010.5);

        // Act
        Dodge.changeOil();
        Boolean needsOilChangeAfterOilChange = Dodge.needsOilChange();

        // Assert
        assertFalse(needsOilChangeAfterOilChange);
    }

    @Test
    public void needsOilChangeAfterOilChangeThenTravel49kMiles() {
        // Arrange
        Dodge.transport(51000.0);

        // Act
        Dodge.changeOil();
        Dodge.transport(49000.0);
        Boolean oilNeedsChanging49kMiles = Dodge.needsOilChange();

        // Assert
        assertFalse(oilNeedsChanging49kMiles);
    }

    @Test
    public void needsOilChangeAfterOilChangeThenTravel50kMiles() {
        // Arrange
        Dodge.transport(51000.0);

        // Act
        Dodge.changeOil();
        Dodge.transport(50000.0);
        Boolean oilNeedsChanging50kMiles = Dodge.needsOilChange();

        // Assert
        assertTrue(oilNeedsChanging50kMiles);
    }

    @Test
    public void checkEngineLight() {
        // Arrange
        Dodge.transport(50000.0);

        // Act
        Boolean checkEngineLightIsOn = Dodge.checkEngineLight();

        // Assert
        assertTrue(checkEngineLightIsOn);
    }

    @Test
    public void checkEngineLight2() {
        // Arrange
        Dodge.transport(40000.0);

        // Act
        Boolean checkEngineLightIsOn = Dodge.checkEngineLight();

        // Assert
        assertFalse(checkEngineLightIsOn);
    }

    @Test
    public void getTopSpeed() {
        // Arrange
        Double expected = 199.0;

        // Act
        Double actual = Dodge.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transport() {
        // Arrange
        Integer expected = 2 * 60 * 60;

        // Act
        Integer actual = Dodge.transport(199.0 * 2);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getDistanceTraveled() {
        // Arrange
        Double expected = 300.0;

        // Act
        Dodge.transport(300.0);
        Double actual = Dodge.getDistanceTraveled();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getDistanceTraveledNewCar() {
        // Arrange
        Double expected = 0.0;

        // Act
        Double actual = Dodge.getDistanceTraveled();

        // Assert
        assertEquals(expected, actual);
    }
}
