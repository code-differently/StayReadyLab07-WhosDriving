import Driving.Drivable;
import Vehicles.HondaCivic;
import Vehicles.ToyotaCamry;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void getVehicle() {
        // Arrange
        Scanner mockScanner = new Scanner("honda civic");
        Console mockConsole = new Console(mockScanner);
        Drivable expected = new HondaCivic();

        // Act
        Drivable actual = App.getVehicle(mockConsole);

        // Assert
        Assert.assertNotSame(expected, actual);
    }

    @Test
    public void getVehicleTest(){
        // Arrange
        Scanner mockScanner = new Scanner("toyota camry");
        Console mockConsole = new Console(mockScanner);
        Drivable expected = new ToyotaCamry();

        // Act
        Drivable actual = App.getVehicle(mockConsole);

        // Assert
        Assert.assertNotSame(expected, actual);
    }

    @Test
    public void getDistance() {
        // Arrange
        Scanner mockScanner = new Scanner("32.0");
        Console mockConsole = new Console(mockScanner);
        Double expected = 32.0;

        // Act
        Double actual = App.getDistance(mockConsole);

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getDistanceTest(){
        // Arrange
        Scanner mockScanner = new Scanner("35.0");
        Console mockConsole = new Console(mockScanner);
        Double expected = 35.0;

        // Act
        Double actual = App.getDistance(mockConsole);

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void main() {
        // Arrange
        String[] args = {"test", "honda civic\n28.5\n"};

        // Act
        App.main(args);

        // Assert
        assertEquals(App.appExecutionStatus, 0);
    }
}