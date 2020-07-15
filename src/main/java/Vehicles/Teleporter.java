package Vehicles;
import Driving.Drivable;

public class Teleporter implements Drivable {

    private final double SPEED = 999;
    private double distance = 0;
    private boolean charged = true;

    /**
     * Gets the top speed of the drivable vehicle
     *
     * The top speed should be assumed to be miles per hour
     *
     * @return top speed in miles per hour
     */
    public Double getTopSpeed(){

        return SPEED;
    }

    /**
     * Gets the time in seconds the vehicle takes to travel a distance
     *
     * @param distance - length of travel in miles
     * @return Integer time in seconds
     */
    public Integer transport(Double distance){

        this.distance += distance;
        return 0;
    }

    public Double getTotalDistanceTraveled() {

        return distance;
    }

    public boolean checkBattery(){

        return charged;
    }

    public void charge(){

        charged = true;
    }


}
