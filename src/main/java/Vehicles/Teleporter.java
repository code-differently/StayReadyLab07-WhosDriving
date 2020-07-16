package Vehicles;

import Driving.Drivable;

public class Teleporter implements Drivable {

    private double distance;


    public Teleporter() {


        this.distance = 0.0;
    }

    @Override
    public Double getTopSpeed() {
        return null;
    }

    @Override
    public Integer transport(Double distance) {

        this.distance = distance;


        return (int) this.distance;
    }
}
