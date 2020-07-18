package Vehicles;

import Driving.Car;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class MaseratiTest {

    Car maseratie = new Maserati();

    @Before
    public void setUp() throws Exception {
        this.maseratie = new Maserati();
    }

    @Test
    public void needsOilChange() {
        // Arrange
        maseratie.needsOilChange();
        // Act
        Boolean newCivicNeedsOilChange = maseratie.needsOilChange();
        // Assert
        assertFalse(newCivicNeedsOilChange);
    }

    @Test
    public void needsOilChangeAfterTravel() {
        // Arrange
        maseratie.transport(50000.0);
        // Act
        Boolean needsOilAfter50kMiles = maseratie.needsOilChange();
        // Assert
        assertTrue(needsOilAfter50kMiles);
    }

    @Test
    public void needsOilChangeAfterTravelThenOilChange() {
        // Arrange
        maseratie.transport(10010.5);
        // Act
        maseratie.changeOil();
        Boolean needsOilChangeAfterOilChange = maseratie.needsOilChange();
        // Assert
        assertFalse(needsOilChangeAfterOilChange);
    }

    @Test
    public void needsOilChangeAfterOilChangeThenTravel14kMiles() {
        // Arrange
        maseratie.transport(15000.0);
        // Act
        maseratie.changeOil();
        maseratie.transport(14000.0);
        Boolean oilNeedsChanging49kMiles = maseratie.needsOilChange();

        // Assert
        assertFalse(oilNeedsChanging49kMiles);
    }

    @Test
    public void needsOilChangeAfterOilChangeThenTravel15kMiles() {
        // Arrange
        maseratie.transport(16000.0);
        // Act
        maseratie.changeOil();
        maseratie.transport(15000.0);
        Boolean oilNeedsChanging50kMiles = maseratie.needsOilChange();

        // Assert
        assertTrue(oilNeedsChanging50kMiles);
    }

    @Test
    public void checkEngineLight() {
        // Arrange
        maseratie.transport(15000.0);
        // Act
        Boolean checkEngineLightIsOn = maseratie.checkEngineLight();

        // Assert
        assertTrue(checkEngineLightIsOn);
    }

    @Test
    public void checkEngineLight2() {
        // Arrange
        maseratie.transport(10000.0);
        // Act
        Boolean checkEngineLightIsOn = maseratie.checkEngineLight();

        // Assert
        assertFalse(checkEngineLightIsOn);
    }

    @Test
    public void getTopSpeed() {
        // Arrange
        Double expected = 193.0;
        // Act
        Double actual = maseratie.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transport() {
        // Arrange
        Integer expected = 2 * 60 * 60;
        // Act
        Integer actual = maseratie.transport(193.0 * 2);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getDistanceTraveled() {
        // Arrange
        Double expected = 300.0;
        // Act
        maseratie.transport(300.0);
        Double actual = maseratie.getDistanceTraveled();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getDistanceTraveledNewCar() {
        // Arrange
        Double expected = 0.0;
        // Act
        Double actual = maseratie.getDistanceTraveled();

        // Assert
        assertEquals(expected, actual);
    }
}
