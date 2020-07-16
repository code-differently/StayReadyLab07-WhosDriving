package Vehicles;

import Driving.Drivable;

import static org.junit.Assert.assertEquals;

import org.junit.*;

public class TeleporterTest {
  Teleporter tb;

    @Before
    public void setUp() throws Exception {
        this.tb = new Teleporter();
    }

    @Test
    public void getTopSpeed() {
        // Arrange
        Double expected = 0.0;

        // Act
        Double actual = tb.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getTopSpeedAfterTransport() {
        // Arrange
        Double expected = 0.0;

        // Act
        tb.transport(20.0);
        tb.transport(20.0);
        Double actual = tb.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test 
    public void transport(){
      Integer expected = 0; 

      Integer actual = tb.transport(250630.0);

      assertEquals(expected, actual);
    }

  
}