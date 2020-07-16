package Vehicles;

import Driving.Drivable;

public class Teleporter implements Drivable{
    private Double topSpeed;

    public Teleporter() {
        topSpeed = Double.POSITIVE_INFINITY;
    }

    public void setTopSpeed(Double speed) {
        topSpeed = speed;
    }    

    /**
     * Gets the top speed of the drivable vehicle
     *
     * The top speed should be assumed to be miles per hour
     *
     * @return top speed in miles per hour
     */
    public Double getTopSpeed() {
        return topSpeed;
    }

    /**
     * Gets the time in seconds the vehicle takes to travel a distance
     *
     * @param distance - length of travel in miles
     * @return Integer time in seconds
     */
    public Integer transport(Double distance) {
        //first part converts the time it takes for a trip into seconds
        //trip time in hours, it could be like 3500 miles / 28.5 (the top speed of the bike) which would be 122 hours (after truncating)
        Integer timeInHours = (int) (distance / getTopSpeed());
        Integer timeInSeconds = timeInHours * 3600;

        return timeInSeconds;
    }
}