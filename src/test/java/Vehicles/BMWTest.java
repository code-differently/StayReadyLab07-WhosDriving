package Vehicles;

import Driving.Car;
import org.junit.Test;
import org.junit.Assert;


public class BMWTest {

    Car BMW = new BMW();


    @Test
    public void needsOilChange() {
        // Arrange
        // Act
        Boolean newCivicNeedsOilChange = BMW.needsOilChange();
        // Assert
        Assert.assertFalse(newCivicNeedsOilChange);
    }
    @Test
    public void needsOilChangeAfterTravel() {
        // Arrange
        BMW.transport(15000.0);
        // Act
        Boolean needsOilAfter50kMiles = BMW.needsOilChange();
        // Assert
        Assert.assertTrue(needsOilAfter50kMiles);
    }
    @Test
    public void needsOilChangeAfterTravelThenOilChange() {
        // Arrange
        BMW.transport(15010.5);
        // Act
        BMW.changeOil();
        Boolean needsOilChangeAfterOilChange = BMW.needsOilChange();
        // Assert
        Assert.assertFalse(needsOilChangeAfterOilChange);
    }
    @Test
    public void needsOilChangeAfterOilChangeThenTravel49kMiles() {
        // Arrange
        // Act
        BMW.changeOil();
        BMW.transport(14000.0);
        Boolean oilNeedsChanging49kMiles = BMW.needsOilChange();
        // Assert
        Assert.assertFalse(oilNeedsChanging49kMiles);
    }
    @Test
    public void needsOilChangeAfterOilChangeThenTravel50kMiles() {
        // Arrange
        BMW.transport(16000.0);
        // Act
        BMW.changeOil();
        BMW.transport(15000.0);
        Boolean oilNeedsChanging50kMiles = BMW.needsOilChange();
        // Assert
        Assert.assertTrue(oilNeedsChanging50kMiles);
    }
    @Test
    public void checkEngineLight() {
        // Arrange
        BMW.transport(15000.0);
        // Act
        Boolean checkEngineLightIsOn = BMW.checkEngineLight();
        // Assert
        Assert.assertTrue(checkEngineLightIsOn);
    }
    @Test
    public void checkEngineLight2() {
        // Arrange
        BMW.transport(14000.0);
        // Act
        Boolean checkEngineLightIsOn = BMW.checkEngineLight();
        // Assert
        Assert.assertFalse(checkEngineLightIsOn);
    }
    @Test
    public void getTopSpeed() {
        // Arrange
        Double expected = 100.0;
        // Act
        Double actual = BMW.getTopSpeed();
        // Assert
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void transport() {
        // Arrange
        Integer expected = 2 * 3600;
        // Act
        Integer actual = BMW.transport(100.0 * 2);
        // Assert
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void getDistanceTraveled(){
        // Arrange
        Double expected = 300.0;
        // Act
        BMW.transport(300.0);
        Double actual = BMW.getDistanceTraveled();
        // Assert
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getDistanceTraveledNewCar() {
        // Arrange
        Double expected = 0.0;
        // Act
        BMW.transport(0.0);
        Double actual = BMW.getDistanceTraveled();
        // Assert
        Assert.assertEquals(expected, actual);
    }
}