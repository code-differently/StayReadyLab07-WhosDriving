package Vehicles;

import Driving.Car;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DodgeChallengerTest {

    Car DodgeChallenger = new DodgeChallenger();

    @Before
    public void setUp() throws Exception {
        this.DodgeChallenger = new DodgeChallenger();
    }

    @Test
    public void needsOilChange() {
        // Arrange

        // Act
        Boolean newCivicNeedsOilChange = DodgeChallenger.needsOilChange();
        // Assert
        assertFalse(newCivicNeedsOilChange);
    }

    @Test
    public void needsOilChangeAfterTravel() {
        // Arrange
        DodgeChallenger.transport(50000.0);
        // Act
        Boolean needsOilAfter50kMiles = DodgeChallenger.needsOilChange();
        // Assert
        assertTrue(needsOilAfter50kMiles);
    }

    @Test
    public void needsOilChangeAfterTravelThenOilChange() {
        // Arrange
        DodgeChallenger.transport(50010.5);
        // Act
        DodgeChallenger.changeOil();
        Boolean needsOilChangeAfterOilChange = DodgeChallenger.needsOilChange();
        // Assert
        assertFalse(needsOilChangeAfterOilChange);
    }

    @Test
    public void needsOilChangeAfterOilChangeThenTravel49kMiles() {
        // Arrange
        DodgeChallenger.transport(51000.0);
        // Act
        DodgeChallenger.changeOil();
        DodgeChallenger.transport(49000.0);
        Boolean oilNeedsChanging49kMiles = DodgeChallenger.needsOilChange();

        // Assert
        assertTrue(oilNeedsChanging49kMiles);
    }

    @Test
    public void needsOilChangeAfterOilChangeThenTravel50kMiles() {
        // Arrange
        DodgeChallenger.transport(51000.0);
        // Act
        DodgeChallenger.changeOil();
        DodgeChallenger.transport(50000.0);
        Boolean oilNeedsChanging50kMiles = DodgeChallenger.needsOilChange();

        // Assert
        assertTrue(oilNeedsChanging50kMiles);
    }

    @Test
    public void checkEngineLight() {
        // Arrange
        DodgeChallenger.transport(50000.0);
        // Act
        Boolean checkEngineLightIsOn = DodgeChallenger.checkEngineLight();

        // Assert
        assertTrue(checkEngineLightIsOn);
    }

    @Test
    public void checkEngineLight2() {
        // Arrange
        DodgeChallenger.transport(40000.0);
        // Act
        Boolean checkEngineLightIsOn = DodgeChallenger.checkEngineLight();

        // Assert
        assertTrue(checkEngineLightIsOn);
    }

    @Test
    public void getTopSpeed() {
        // Arrange
        Double expected = 70.0;
        // Act
        Double actual = DodgeChallenger.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transport() {
        // Arrange
        Integer expected = 2 * 60 * 60;
        // Act
        Integer actual = DodgeChallenger.transport(70.0 * 2);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getDistanceTraveled() {
        // Arrange
        Double expected = 300.0;
        // Act
        DodgeChallenger.transport(300.0);
        Double actual = DodgeChallenger.getDistanceTraveled();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getDistanceTraveledNewCar() {
        // Arrange
        Double expected = 0.0;
        // Act
        Double actual = DodgeChallenger.getDistanceTraveled();

        // Assert
        assertEquals(expected, actual);
    }
}