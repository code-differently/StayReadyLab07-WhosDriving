package Vehicles;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class TeleporterTest {
    Teleporter teleporter = new Teleporter();
    @Before
    public void setUp() throws Exception {
        this.teleporter = new Teleporter();
    }
    @Test
    public void getTopSpeed() {
        // Arrange
        Double expected = Double.MAX_VALUE;
        // Act
        Double actual = teleporter.getTopSpeed();
        // Assert
        assertEquals(expected, actual);
    }
    @Test
    public void transport() {
        // Arrange
        Integer expected = 60;
        // Act
        Integer actual = teleporter.transport(60.0);
        // Assert
        assertEquals(expected, actual);
    }
    @Test
    public void needsBatteryCharge() {
        // Arrange
        // Act
        Boolean newTeleporterNeedsBatteryCharge = teleporter.needsBatteryCharge();
        // Assert
        assertFalse(newTeleporterNeedsBatteryCharge);
    }
    @Test
    public void needsChargeAfterTravel() {
        // Arrange
        teleporter.transport(100.0);
        // Act
        Boolean needsChargeAfter100times = teleporter.needsBatteryCharge();
        // Assert
        assertTrue(needsChargeAfter100times);
    }
    @Test
    public void needsBatteryChargeAfterTravelThenBatteryCharge() {
        // Arrange
        teleporter.transport(100.0);
        // Act
        teleporter.chargeBattery();
        Boolean needsBatteryChargeAfterBatteryCharge = teleporter.needsBatteryCharge();
        // Assert
        assertFalse(needsBatteryChargeAfterBatteryCharge);
    }
    @Test
    public void needsBatteryChargeAfterBatteryChargeThenTravel99Times() {
        // Arrange
        teleporter.transport(100.0);
        // Act
        teleporter.chargeBattery();
        teleporter.transport(99.0);
        Boolean batteryNeedsCharging199Times = teleporter.needsBatteryCharge();
        // Assert
        assertFalse(batteryNeedsCharging199Times);
    }
    @Test
    public void needsBatteryChargeAfterBatteryChargeThenTravel100Times() {
        // Arrange
        teleporter.transport(100.0);
        // Act
        teleporter.chargeBattery();
        teleporter.transport(100.0);
        Boolean batteryNeedsCharging100Times = teleporter.needsBatteryCharge();
        // Assert
        assertTrue(batteryNeedsCharging100Times);
    }
    @Test
    public void checkLowBatteryLight() {
        // Arrange
        teleporter.transport(100.0);
        // Act
        Boolean checkLowBatteryLightIsOn = teleporter.checkLowBatteryLight();
        // Assert
        assertTrue(checkLowBatteryLightIsOn);
    }
    @Test
    public void checkLowBatteryLight2() {
        // Arrange
        teleporter.transport(80.0);
        // Act
        Boolean checkLowBatteryLightIsOn = teleporter.checkLowBatteryLight();
        // Assert
        assertFalse(checkLowBatteryLightIsOn);
    }
    @Test
    public void getTimesTraveled() {
        // Arrange
        Integer expected = 50;
        // Act
        teleporter.transport(50.0);
        Integer actual = teleporter.getTimesTraveled();
        // Assert
        assertEquals(expected, actual);
    }
    @Test
    public void getDistanceTraveledNewCar() {
        // Arrange
        Integer expected = 0;
        // Act
        Integer actual = teleporter.getTimesTraveled();
        // Assert
        assertEquals(expected, actual);
    }
}