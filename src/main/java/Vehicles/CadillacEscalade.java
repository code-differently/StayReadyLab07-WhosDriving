package Vehicles;

import Driving.Car;

public class CadillacEscalade extends Car {

    private boolean changeOil = false;
    private String redLight = "Check engine light on!";
    private double distanceTraveled;
    private Double topSpeed = 0.0;

    public CadillacEscalade()
    {
        this.distanceTraveled = 0.0;
        this.topSpeed = 70.0;

    }

    public void setDistanceTraveled(double distanceTraveled)
    {
        this.distanceTraveled = distanceTraveled;
    }

    @Override
    public Boolean needsOilChange() {

            double distance = getDistanceTraveled();
            if(distance >= 50000){
                changeOil();
                return true;
            } else { 
                return false; 
            }
    }

    @Override
    public void changeOil() {

        if (changeOil == false){
            System.out.println("Another 50,000 miles may be traveled before another oil change is needed");
            this.setDistanceTraveled(0);
        } else {
            changeOil = true;
        }
    }

    @Override
    public Boolean checkEngineLight() {

        if(needsOilChange()){
            System.out.println(redLight);
            return true;
        }
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
        int seconds = 3600; //To convert a num to seconds multiply by 3600
        Integer timeInSeconds = Math.round((int)(distance / topSpeed) * seconds);
        distanceTraveled += distance;
        return timeInSeconds;
    }

    
}