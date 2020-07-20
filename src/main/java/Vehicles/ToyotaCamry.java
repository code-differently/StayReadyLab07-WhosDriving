package Vehicles;

import Driving.Car;

public class ToyotaCamry extends Car{
    
    private boolean oilChangeNeeded;
    private Double totalDistanceTraveled;

    public ToyotaCamry(){
        topSpeed = 75.0;
        oilChangeNeeded = false;
        givenDistance = 0.0;
        totalDistanceTraveled = 0.0;
    }

    @Override
    public Boolean needsOilChange() {

        if(givenDistance >= 50000 && totalDistanceTraveled != 0)
            oilChangeNeeded = true;

        return oilChangeNeeded;
    }

    @Override
    public void changeOil() {
        System.out.println("The oil was changed, you can now go another 50, 000 miles before needeing another one.");
        oilChangeNeeded = false; //reset oilChangeNeeded
        givenDistance = 0.0;
    }

    protected boolean getOilChangeNeeded(){
        return oilChangeNeeded;
    }

    @Override
    public Boolean checkEngineLight() {
        if(needsOilChange())
            return true;
        return false;
    }

    @Override
    public Double getDistanceTraveled() {
        return totalDistanceTraveled;
    }

    @Override
    public Double getTopSpeed() {
        return topSpeed;
    }

    @Override
    public Integer transport(Double distance) {
        givenDistance = distance;

        double time = (distance / topSpeed) * 3600;

        totalDistanceTraveled += distance;

        return (int) time;
    }
}