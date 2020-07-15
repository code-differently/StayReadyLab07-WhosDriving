import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TeleporterTest {

    @Test
    public void getTopSpeed(){
        Double expected = 0.00;
        Double actual = teleporter.getTopSpeed();
        assertEquals(expected, actual);
    }

    
    @Test
    public void transport(){
        Integer expected = 0;
        Integer actual = teleporter.transport();
        assertEquals(expected, actual);
    }
    
    @Test
    public void getTopSpeedAfterTransport(){
        Double expected = 0.0;
        teleporter.transport(30.0);
        Double actual = teleporter.getTopSpeed();
        assertEquals(expected, actual);
    }

}