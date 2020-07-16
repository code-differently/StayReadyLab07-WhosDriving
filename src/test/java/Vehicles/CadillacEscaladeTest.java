package Vehicles;

import Driving.Car;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CadillacEscaladeTest {

    Car cadillacEscalade = new CadillacEscalade();

    @Before
    public void setUp() throws Exception {
        this.cadillacEscalade = new CadillacEscalade();
    }

    @Test
    public void needsOilChange() {
        // Arrange

        // Act
        Boolean newCadillacNeedsOilChange = cadillacEscalade.needsOilChange();
        // Assert
        assertFalse(newCadillacNeedsOilChange);
    }

    @Test
    public void needsOilChangeAfterTravel() {
        // Arrange
        cadillacEscalade.transport(50000.0);
        // Act
        Boolean needsOilAfter50kMiles = cadillacEscalade.needsOilChange();
        // Assert
        assertTrue(needsOilAfter50kMiles);
    }

    @Test
    public void needsOilChangeAfterTravelThenOilChange() {
        // Arrange
        cadillacEscalade.transport(50010.5);
        // Act
        cadillacEscalade.changeOil();
        Boolean needsOilChangeAfterOilChange = cadillacEscalade.needsOilChange();
        // Assert
        assertFalse(needsOilChangeAfterOilChange);
    }

    @Test
    public void needsOilChangeAfterOilChangeThenTravel49kMiles() {
        // Arrange
        cadillacEscalade.transport(51000.0);
        // Act
        cadillacEscalade.changeOil();
        cadillacEscalade.transport(49000.0);
        Boolean oilNeedsChanging49kMiles = cadillacEscalade.needsOilChange();

        // Assert
        assertFalse(oilNeedsChanging49kMiles);
    }

    @Test
    public void needsOilChangeAfterOilChangeThenTravel50kMiles() {
        // Arrange
        cadillacEscalade.transport(51000.0);
        // Act
        cadillacEscalade.changeOil();
        cadillacEscalade.transport(50000.0);
        Boolean oilNeedsChanging50kMiles = cadillacEscalade.needsOilChange();

        // Assert
        assertTrue(oilNeedsChanging50kMiles);
    }

    @Test
    public void checkEngineLight() {
        // Arrange
        cadillacEscalade.transport(50000.0);
        // Act
        Boolean checkEngineLightIsOn = cadillacEscalade.checkEngineLight();

        // Assert
        assertTrue(checkEngineLightIsOn);
    }

    @Test
    public void checkEngineLight2() {
        // Arrange
        cadillacEscalade.transport(40000.0);
        // Act
        Boolean checkEngineLightIsOn = cadillacEscalade.checkEngineLight();

        // Assert
        assertFalse(checkEngineLightIsOn);
    }

    @Test
    public void getTopSpeed() {
        // Arrange
        Double expected = 70.0;
        // Act
        Double actual = cadillacEscalade.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transport() {
        // Arrange
        Integer expected = 2 * 60 * 60;
        // Act
        Integer actual = cadillacEscalade.transport(70.0 * 2);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getDistanceTraveled() {
        // Arrange
        Double expected = 300.0;
        // Act
        cadillacEscalade.transport(300.0);
        Double actual = cadillacEscalade.getDistanceTraveled();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getDistanceTraveledNewCar() {
        // Arrange
        Double expected = 0.0;
        // Act
        Double actual = cadillacEscalade.getDistanceTraveled();

        // Assert
        assertEquals(expected, actual);
    }
    
}