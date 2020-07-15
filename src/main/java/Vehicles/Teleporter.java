package Vehicles;

import Driving.Drivable;

public class Teleporter implements Drivable {
    private double topSpeed = 0.0;

    @Override
    public Double getTopSpeed() {
        return topSpeed;
    }

    @Override
    public Integer transport(Double distance) {
        Double time = distance * topSpeed;
        return time.intValue();
    }
}
