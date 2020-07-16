package Vehicles;
import Driving.Car;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;

public class BMWTest {
    Car BMW = new BMW();
    @Before
    public void setUp() throws Exception {
        this.BMW = new BMW();
    }
    @Test
    public void needsOilChange() {
        // Arrange
        // Act
        Boolean newCivicNeedsOilChange = BMW.needsOilChange();
        // Assert
        assertFalse(newCivicNeedsOilChange);
    }
    @Test
    public void needsOilChangeAfterTravel() {
        // Arrange
        BMW.transport(15000.0);
        // Act
        Boolean needsOilAfter50kMiles = BMW.needsOilChange();
        // Assert
        assertTrue(needsOilAfter50kMiles);
    }
    @Test
    public void needsOilChangeAfterTravelThenOilChange() {
        // Arrange
        BMW.transport(15010.5);
        // Act
        BMW.changeOil();
        Boolean needsOilChangeAfterOilChange = BMW.needsOilChange();
        // Assert
        assertFalse(needsOilChangeAfterOilChange);
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
        assertTrue(checkEngineLightIsOn);
    }
    @Test
    public void checkEngineLight2() {
        // Arrange
        BMW.transport(14000.0);
        // Act
        Boolean checkEngineLightIsOn = BMW.checkEngineLight();
        // Assert
        assertFalse(checkEngineLightIsOn);
    }
    @Test
    public void getTopSpeed() {
        // Arrange
        Double expected = 100.0;
        // Act
        Double actual = BMW.getTopSpeed();
        // Assert
        assertEquals(expected, actual);
    }
    @Test
    public void transport() {
        // Arrange
        Integer expected = 2 * 60 * 60;
        // Act
        Integer actual = BMW.transport(140.0);
    }
    @Test
    public void getDistanceTraveled(){
        // Arrange
        Double expected = 300.0;
        // Act
        BMW.transport(300.0);
        Double actual = BMW.getDistanceTraveled();
        // Assert
        assertEquals(expected, actual);
    }
    @Test
    public void getDistanceTraveledNewCar() {
        // Arrange
        Double expected = 0.0;
        // Act
        BMW.transport(0.0);
        Double actual = BMW.getDistanceTraveled();
        // Assert
        assertEquals(expected, actual);
    }
}