package Vehicles;

import Driving.Drivable;

public class Teleporter implements Drivable{
    protected double topSpeed = 0.0;
    
    @Override
    public Double getTopSpeed(){
        return topSpeed;
    }

    @Override
    public Integer transport(Double distance){
        Double timeInSeconds = distance * topSpeed;
        return timeInSeconds;
    }
}