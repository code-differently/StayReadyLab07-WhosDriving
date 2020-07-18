package Vehicles;

import Driving.Car;

public class Maserati extends Car {
    private double distanceTraveled;
    private double milesTraveled;

    public Maserati(){
        this.distanceTraveled = 0.0;
        this.milesTraveled = 0.0;
    }

    public Maserati (double distance, double milesTraveled){
        this.distanceTraveled = distance;
        this.milesTraveled = milesTraveled;
    }

    public void setDistanceTraveled(double distance) {
        this.distanceTraveled = distance;
    }


    public void setMilesTraveled(double milesTraveled) {
        this.milesTraveled = milesTraveled;
    }

    @Override
    public Boolean needsOilChange() {
        if (milesTraveled >= 15000){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void changeOil() {
        System.out.println("Car is now able to drive another 15,000 miles");
        setDistanceTraveled(0);
    }

    @Override
    public Boolean checkEngineLight() {
        if(needsOilChange()){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public Double getDistanceTraveled() {
        return distanceTraveled;
    }

    @Override
    public double getTopSpeed() {
        return 193.0;
    }

    @Override
    public Integer transport(Double distance) {
        double time = (distance/getTopSpeed()) * 3600;
        setDistanceTraveled(this.distanceTraveled + distance);
        setMilesTraveled(distance);
        return (int)time;
    }
}