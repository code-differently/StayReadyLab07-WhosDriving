package Vehicles;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class TeleporterTest {

    Teleporter tele;
    @Before
    public void initialize(){
        tele = new Teleporter();
    }
    @Test
    public void getTotalDistanceTraveledTest(){
      Assert.assertEquals((Double) 0.0, tele.getTotalDistanceTraveled());
    }
    @Test
    public void getTopSpeedTest(){
        Assert.assertEquals((Double) 999.0, tele.getTopSpeed());
    }
    @Test
    public void transportTest(){
        tele.transport(100.0);
        Assert.assertEquals((Double) 100.0, tele.getTotalDistanceTraveled());
    }
    @Test
    public void checkBatteryTest(){
        Assert.assertEquals(true, tele.checkBattery());
    }
    @Test
    public void chargedTest(){
        tele.charge();
        Assert.assertEquals(true, tele.checkBattery());
    }
}
