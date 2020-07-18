package Vehicles;

import Driving.Drivable;

public class Teleportation implements Drivable {
    private double topSpeed;

    public Teleportation() {
        this.topSpeed = 0;
    }

    public double getTopSpeed() {
        return this.topSpeed;
    }

    @Override
    public Integer transport(Double distance) {
        double time = distance * getTopSpeed();
        return (int) time;
    }
}
