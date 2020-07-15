package Driving;

import org.junit.Assert;
import org.junit.Test;

public class TeleporterTest {
    @Test
    public void getSpeedTest(){
        // Given
        Double max=Double.MAX_VALUE;

        // When
        Teleporter test=new Teleporter();
        Double speed=test.getTopSpeed();

        // Then
        Assert.assertEquals(max,speed);
    }

    @Test
    public void transportTest(){
        // Given
        int expected=0;

        // When
        Teleporter test=new Teleporter();
        int actual=test.transport(100000000000.00);

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void transportTest2(){
        // Given
        int expected=0;

        // When
        Teleporter test=new Teleporter();
        int actual=test.transport(999999999999999999999999.99);

        // Then
        Assert.assertEquals(expected,actual);
    }
}
