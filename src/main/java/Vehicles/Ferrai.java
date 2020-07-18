package Vehicles;

import Driving.Car;

public class Ferrai extends Car{
    private double totalMiles;
    private double milesToOil;

    public Ferrai() {

        this.totalMiles = 0;
        this.milesToOil = 10000;

    }

    @Override
    public Boolean needsOilChange() {

        if(this.milesToOil <= 0){

            return true;
        }

        return false;
    }


    @Override
    public void changeOil() {


        this.milesToOil = 10000;

    }

    @Override
    public Boolean checkEngineLight() {

        if(needsOilChange() == true){
            return true;
        }

        return false;
    }

    @Override
    public Double getDistanceTraveled() {


        return this.totalMiles;
    }

    @Override
    public Double getTopSpeed() {

        return 205.0;

    }

    @Override
    public Integer transport(Double distance) {

        double time = (distance / getTopSpeed()) * 3600;

        this.totalMiles += distance;
        this.milesToOil -= distance;

        return (int) time;
    }

}
