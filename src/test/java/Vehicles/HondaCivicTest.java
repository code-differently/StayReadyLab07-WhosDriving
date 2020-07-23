package Vehicles;

import Driving.Car;
import org.junit.Test;
import org.junit.Assert;

public class HondaCivicTest {

    Car hondaCivic = new HondaCivic();


    @Test
    public void needsOilChange() {
        // Arrange

        // Act
        Boolean newCivicNeedsOilChange = hondaCivic.needsOilChange();
        // Assert
        Assert.assertFalse(newCivicNeedsOilChange);
    }

    @Test
    public void needsOilChangeAfterTravel() {
        // Arrange
        hondaCivic.transport(50000.0);
        // Act
        Boolean needsOilAfter50kMiles = hondaCivic.needsOilChange();
        // Assert
        Assert.assertTrue(needsOilAfter50kMiles);
    }

    @Test
    public void needsOilChangeAfterTravelThenOilChange() {
        // Arrange
        hondaCivic.transport(50010.5);
        // Act
        hondaCivic.changeOil();
        Boolean needsOilChangeAfterOilChange = hondaCivic.needsOilChange();
        // Assert
        Assert.assertFalse(needsOilChangeAfterOilChange);
    }

    @Test
    public void needsOilChangeAfterOilChangeThenTravel49kMiles() {
        // Arrange
        hondaCivic.transport(51000.0);
        // Act
        hondaCivic.changeOil();
        hondaCivic.transport(49000.0);
        Boolean oilNeedsChanging49kMiles = hondaCivic.needsOilChange();

        // Assert
        Assert.assertFalse(oilNeedsChanging49kMiles);
    }

    @Test
    public void needsOilChangeAfterOilChangeThenTravel50kMiles() {
        // Arrange
        hondaCivic.transport(51000.0);
        // Act
        hondaCivic.changeOil();
        hondaCivic.transport(50000.0);
        Boolean oilNeedsChanging50kMiles = hondaCivic.needsOilChange();

        // Assert
        Assert.assertTrue(oilNeedsChanging50kMiles);
    }

    @Test
    public void checkEngineLight() {
        // Arrange
        hondaCivic.transport(50000.0);
        // Act
        Boolean checkEngineLightIsOn = hondaCivic.checkEngineLight();

        // Assert
        Assert.assertTrue(checkEngineLightIsOn);
    }

    @Test
    public void checkEngineLight2() {
        // Arrange
        hondaCivic.transport(40000.0);
        // Act
        Boolean checkEngineLightIsOn = hondaCivic.checkEngineLight();

        // Assert
        Assert.assertFalse(checkEngineLightIsOn);
    }

    @Test
    public void getTopSpeed() {
        // Arrange
        Double expected = 70.0;
        // Act
        Double actual = hondaCivic.getTopSpeed();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void transport() {
        // Arrange
        Integer expected = 2 * 60 * 60;
        // Act
        Integer actual = hondaCivic.transport(70.0 * 2);

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getDistanceTraveled() {
        // Arrange
        Double expected = 300.0;
        // Act
        hondaCivic.transport(300.0);
        Double actual = hondaCivic.getDistanceTraveled();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getDistanceTraveledNewCar() {
        // Arrange
        Double expected = 0.0;
        // Act
        Double actual = hondaCivic.getDistanceTraveled();

        // Assert
        Assert.assertEquals(expected, actual);
    }
}