package Vehicles;

import Driving.Bike;
import Driving.Teleporter;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TimeMachineTest {
    TimeMachine tm;
    @Before
    public void setUp() throws Exception {
        this.tm = new TimeMachine();
    }

    @Test
    public void getDistanceTest(){
        //Given
        Double expected = 40.0;

        //When
        tm.transport(40.0);
        Double actual = tm.getDistance();

        //Then
        assertEquals(expected, actual);
    }

    @Test
    public void sendPassengersTest(){
        //Given
        Double expected = 1.0;

        //When
        Double actual = tm.sendPassengers();

        //Then
        assertEquals(expected, actual);
    }

    @Test
    public void getTopSpeedTest(){
        //Given
        Double expected = 250.0;

        //When
        Double actual = tm.getTopSpeed();

        //Then
        assertEquals(expected, actual);
    }

    @Test
    public void transportTest(){
        //Given
        Integer expected = 1;

        //When
        Integer actual = tm.transport(40.0);

        //Then
        assertEquals(expected, actual);
    }
}
