package Vehicles;

import Driving.Car;

public class KiaForte extends Car {
    private double distanceTotal;
    private double currentDistance;

    public KiaForte(){
        this.distanceTotal=0.0;
        this.currentDistance=0.0;
    }

    @Override
    public Boolean needsOilChange() {
        if(this.currentDistance>=80000)
            return true;
        return false;
    }

    @Override
    public void changeOil() {
        this.currentDistance=0.0;
    }


    @Override
    public Boolean checkEngineLight() {
        if(needsOilChange()){
            return true;
        }
        return false;
    }


    @Override
    public Double getDistanceTraveled() {
        return this.distanceTotal;
    }

    @Override
    public Double getTopSpeed(){
        return 80.0;
    }


    @Override
    public Integer transport(Double distance) {
        this.distanceTotal+=distance;
        this.currentDistance+=distance;
        Double seconds=(distance/getTopSpeed())*60*60;
        return (int)Math.round(seconds);
    }
}
