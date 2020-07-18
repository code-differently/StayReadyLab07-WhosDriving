package Vehicles;

import Driving.Drivable;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TeleportationTest {
    Teleportation tlp;

    @Before
    public void setUp() throws Exception{
        this.tlp = new Teleportation();
    }

    @Test
    public void getTopSpeed(){
        Double expected = 0.0;

        Double actual = tlp.getTopSpeed();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTopSpeedAfterTeleportation(){
        Double expected = 0.0;

        tlp.transport(30.9);
        tlp.transport(30.9);
        Double actual = tlp.getTopSpeed();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void transportation(){
        Integer expected = 0;

        Integer actual = tlp.transport(30009.7);

        Assert.assertEquals(expected, actual);
    }
}
