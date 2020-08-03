package Vehicles;

import Driving.Car;

public class Rari extends Car {

    public Rari(){
        this.distanceTraveled = 0;
        this.topSpeed = 140;
        this.trip = 0;
    }
    @Override
    public Boolean needsOilChange() {
        if(distanceTraveled >= 5000)
            return true;
        else return false;
    }
    @Override
    public void changeOil() {
        distanceTraveled = 0;
    }

    @Override
    public Boolean checkEngineLight() {
        if(needsOilChange())
            return true;
        return false;
    }

    @Override
    public Double getDistanceTraveled() {
        return distanceTraveled;
    }

    @Override
    public Double getTopSpeed() {
        return topSpeed;
    }



    @Override
    public Integer transport(Double distance) {
        int travelTime = 0;
        travelTime = (int)(distance/topSpeed*3600);
        distanceTraveled += distance;

        return travelTime;
    }
}
