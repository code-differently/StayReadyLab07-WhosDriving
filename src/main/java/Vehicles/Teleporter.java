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

    @Override
    public String toString() {
        return "Top speed: " + topSpeed;
    }

    @Override
    public boolean equals(Object otherObj) {
        //if they reference (in same memory location) the same thing then return true
        if(this == otherObj) return true;
        //if the other object
        if(otherObj == null) return false;
        //semantics change in subclasses because the fields are different, hondacivic could have different fields then a bmwi8
        //don't use instanceOf in this case
        //returns the class of the object
        if(getClass() != this.getClass()) return false;
        //downcasting to a specific version, in this case, teleporter
        //this is why I override equals in each subclass and not in the abstract class for this part
        Teleporter other = (Teleporter) otherObj;
        //checks to see if the strings are equal
        return other.toString().equals(other.toString());
    }
}