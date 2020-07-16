package Vehicles;

import Driving.Bike;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TeleporterTest {
    Teleporter teleport;
    @Before
    public void setup() {
        teleport = new Teleporter();
    }

    @Test
    public void getTopSpeedTest(){
        //given
        Double expected = Double.POSITIVE_INFINITY;
        //when
        Double actual = teleport.getTopSpeed();
        //then
        assertEquals(expected, actual, 0.0);
    }

    
    @Test
    public void setTopSpeedTest(){
        //given
        Double expected = 100000.0;
        //when
        teleport.setTopSpeed(100000.0);
        Double actual = teleport.getTopSpeed();
        //then
        assertEquals(expected, actual, 0.0);
    }
    
    @Test
    public void transportTest() {
        //given
        Integer expected = 0;
        //when
        Integer actual = teleport.transport(12.0);
        //then
        assertEquals(expected, actual);
    }
}