package Vehicles;

import Driving.Drivable;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TeleporterTest  {



    Teleporter tel;

    @Before
    public void setTel() {


        tel = new Teleporter();
    }

    @Test
    public void transportTest() {

        // Arrange
        Integer expected = (int) (2 * 75.33);
        // Act
        Integer actual = tel.transport(75.33 * 2);

        // Assert
        assertEquals(expected, actual);

        
    }


}
