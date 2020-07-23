package Vehicles;

import org.junit.Test;

public class TeleportTest {
    Teleporter teleporter = new Teleporter();

    @Test
    public void transport() {
        // Arrange
        Integer expected = 2 * 60 * 60;
        // Act
        Integer actual = teleporter.transport(140.0);
    }
}
