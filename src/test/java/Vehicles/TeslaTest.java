package Vehicles;

import Driving.Car;

import static org.junit.Assert.*;

import org.junit.*;

public class TeslaTest {

  Car tesla = new Tesla();

  @Before
  public void setUp() throws Exception {
      this.tesla = new Tesla();
  }

  @Test
  public void needsOilChange() {
      // Arrange

      // Act
      Boolean newCivicNeedsOilChange = tesla.needsOilChange();
      // Assert
      assertFalse(newCivicNeedsOilChange);
  }

  @Test
  public void needsOilChangeAfterTravel() {
      // Arrange
      tesla.transport(100000.0);
      // Act
      Boolean needsOilAfter100kMiles = tesla.needsOilChange();
      // Assert
      assertTrue(needsOilAfter100kMiles);
  }

  @Test
  public void needsOilChangeAfterTravelThenOilChange() {
      // Arrange
      tesla.transport(50010.5);
      // Act
      tesla.changeOil();
      Boolean needsOilChangeAfterOilChange = tesla.needsOilChange();
      // Assert
      assertFalse(needsOilChangeAfterOilChange);
  }

  @Test
  public void needsOilChangeAfterOilChangeThenTravel99kMiles() {
      // Arrange
      tesla.transport(101000.0);
      // Act
      tesla.changeOil();
      tesla.transport(99000.0);
      Boolean oilNeedsChanging99kMiles = tesla.needsOilChange();

      // Assert
      assertFalse(oilNeedsChanging99kMiles);
  }

  @Test
  public void needsOilChangeAfterOilChangeThenTravel100kMiles() {
      // Arrange
      tesla.transport(101000.0);
      // Act
      tesla.changeOil();
      tesla.transport(100000.0);
      Boolean oilNeedsChanging100kMiles = tesla.needsOilChange();

      // Assert
      assertTrue(oilNeedsChanging100kMiles);
  }

  @Test
  public void checkEngineLight() {
      // Arrange
      tesla.transport(100000.0);
      // Act
      Boolean checkEngineLightIsOn = tesla.checkEngineLight();

      // Assert
      assertTrue(checkEngineLightIsOn);
  }

  @Test
  public void checkEngineLight2() {
      // Arrange
      tesla.transport(40000.0);
      // Act
      Boolean checkEngineLightIsOn = tesla.checkEngineLight();

      // Assert
      assertFalse(checkEngineLightIsOn);
  }

  @Test
  public void getTopSpeed() {
      // Arrange
      Double expected = 200.0;
      // Act
      Double actual = tesla.getTopSpeed();

      // Assert
      assertEquals(expected, actual);
  }

  @Test
  public void transport() {
      // Arrange
      Integer expected = 2 * 60 * 60;
      // Act
      Integer actual = tesla.transport(200.0 * 2);

      // Assert
      assertEquals(expected, actual);
  }

  @Test
  public void getDistanceTraveled() {
      // Arrange
      Double expected = 300.0;
      // Act
      tesla.transport(300.0);
      Double actual = tesla.getDistanceTraveled();

      // Assert
      assertEquals(expected, actual);
  }

  @Test
  public void getDistanceTraveledNewCar() {
      // Arrange
      Double expected = 0.0;
      // Act
      Double actual = tesla.getDistanceTraveled();

      // Assert
      assertEquals(expected, actual);
  }
  
}