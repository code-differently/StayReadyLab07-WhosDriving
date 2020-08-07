package Vehicles;
import Driving.Drivable;
public class Teleporter implements Drivable {
    @Override
    public Double getTopSpeed() {
        return null;
    }
    @Override
    public Integer transport(Double distance) {
        Integer teleportDistance = distance.intValue();
        return teleportDistance;
    }
}