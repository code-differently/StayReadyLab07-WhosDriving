package Vehicles;

import Driving.Car;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class KiaForteTest {
    Car kiaForte = new KiaForte();

    @Before
    public void setUp() throws Exception {
        this.kiaForte = new KiaForte();
    }

    @Test
    public void needsOilChange() {
        // Arrange

        // Act
        Boolean newCivicNeedsOilChange = kiaForte.needsOilChange();
        // Assert
        assertFalse(newCivicNeedsOilChange);
    }

    @Test
    public void needsOilChangeAfterTravel() {
        // Arrange
        kiaForte.transport(80000.0);
        // Act
        Boolean needsOilAfter50kMiles = kiaForte.needsOilChange();
        // Assert
        assertTrue(needsOilAfter50kMiles);
    }

    @Test
    public void needsOilChangeAfterTravelThenOilChange() {
        // Arrange
        kiaForte.transport(800010.5);
        // Act
        kiaForte.changeOil();
        Boolean needsOilChangeAfterOilChange = kiaForte.needsOilChange();
        // Assert
        assertFalse(needsOilChangeAfterOilChange);
    }

    @Test
    public void needsOilChangeAfterOilChangeThenTravel49kMiles() {
        // Arrange
        kiaForte.transport( 80000.0);
        // Act
        kiaForte.changeOil();
        kiaForte.transport(49000.0);
        Boolean oilNeedsChanging49kMiles = kiaForte.needsOilChange();

        // Assert
        assertFalse(oilNeedsChanging49kMiles);
    }

    @Test
    public void needsOilChangeAfterOilChangeThenTravel50kMiles() {
        // Arrange
        kiaForte.transport(80000.0);
        // Act
        kiaForte.changeOil();
        kiaForte.transport(80000.0);
        Boolean oilNeedsChanging50kMiles = kiaForte.needsOilChange();

        // Assert
        assertTrue(oilNeedsChanging50kMiles);
    }

    @Test
    public void checkEngineLight() {
        // Arrange
        kiaForte.transport(80000.0);
        // Act
        Boolean checkEngineLightIsOn = kiaForte.checkEngineLight();

        // Assert
        assertTrue(checkEngineLightIsOn);
    }

    @Test
    public void checkEngineLight2() {
        // Arrange
        kiaForte.transport(40000.0);
        // Act
        Boolean checkEngineLightIsOn = kiaForte.checkEngineLight();

        // Assert
        assertFalse(checkEngineLightIsOn);
    }

    @Test
    public void getTopSpeed() {
        // Arrange
        Double expected = 80.0;
        // Act
        Double actual = kiaForte.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transport() {
        // Arrange
        Integer expected = 2 * 60 * 60;
        // Act
        Integer actual = kiaForte.transport(80.0 * 2);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getDistanceTraveled() {
        // Arrange
        Double expected = 300.0;
        // Act
        kiaForte.transport(300.0);
        Double actual = kiaForte.getDistanceTraveled();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getDistanceTraveledNewCar() {
        // Arrange
        Double expected = 0.0;
        // Act
        Double actual = kiaForte.getDistanceTraveled();

        // Assert
        assertEquals(expected, actual);
    }
}
