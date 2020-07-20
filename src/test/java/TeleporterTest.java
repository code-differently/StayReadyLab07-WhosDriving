import org.junit.Assert;
import org.junit.Test;

import Driving.Teleporter;

public class TeleporterTest {
    
    @Test
    public void getTopSpeedTest(){
        Teleporter t = new Teleporter();

        double actual = t.getTopSpeed();
        double expected = 0.0;

        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void transportTest(){
        Teleporter t = new Teleporter();
        
        t.transport(45.0);
        int actual = t.transport(20.0);
        int expected = 65;

        Assert.assertEquals(expected, actual);
    }
}