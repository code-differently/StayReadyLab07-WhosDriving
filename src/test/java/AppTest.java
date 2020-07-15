import Driving.Drivable;
import Vehicles.HondaCivic;
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
        Drivable expected = new HondaCivic(); // new Drivable created in method will never be equal to expected

        // Act
        Drivable actual = App.getVehicle(mockConsole);

        // Assert
        Assert.assertEquals(expected, actual);
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
    public void main() {
        // Arrange
        String[] args = {"test", "honda civic\n28.5\n"};

        // Act
        App.main(args);

        // Assert
        assertEquals(App.appExecutionStatus, 0);
        System.out.println();
    }

    @Test
    public void main2() {
        // Arrange
        String[] args = {"test", "mountain bike\n50\n"};

        // Act
        App.main(args);

        // Assert
        assertEquals(App.appExecutionStatus, 0);
        System.out.println();
    }

    @Test
    public void main3() {
        // Arrange
        String[] args = {"test", "ford mustang\n95\n"};

        // Act
        App.main(args);

        // Assert
        assertEquals(App.appExecutionStatus, 0);
        System.out.println();
    }

    @Test
    public void main4() {
        // Arrange
        String[] args = {"test", "bmx bike\n33\n"};

        // Act
        App.main(args);

        // Assert
        assertEquals(App.appExecutionStatus, 0);
        System.out.println();
    }

    @Test
    public void main5() {
        // Arrange
        String[] args = {"test", "teleporter\n1000\n"};

        // Act
        App.main(args);

        // Assert
        assertEquals(App.appExecutionStatus, 0);
        System.out.println();
    }
}