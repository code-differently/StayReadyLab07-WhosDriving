package Vehicles;

import Driving.Car;

public class KiaOptima extends Car {
    private boolean needsOilChange;
    private final double topSpeed;
    private Double totalDistance;
    private Double previousDistance;
    private int numTrips;

    public KiaOptima() {
        needsOilChange = false;
        topSpeed = 70.0;
        totalDistance = 0.0;
        previousDistance = 0.0;
        numTrips = 0;
    }

    public boolean getNeedsOilChange() {
        return needsOilChange;
    }

    public void setNeedsOilChange(boolean needsOilChange) {
        this.needsOilChange = needsOilChange;
    }

    public Double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(Double totalDistance) {
        this.totalDistance = totalDistance;
    }

    public Double getPreviousDistance() {
        return previousDistance;
    }

    public void setPreviousDistance(Double previousDistance) {
        this.previousDistance = previousDistance;
    }

    public int getNumTrips() {
        return numTrips;
    }

    public void setNumTrips(int numTrips) {
        this.numTrips = numTrips;
    }

    /**
     * A civic should need an oil change every 50,000 miles traveled. Once the oil
     * is changed, the car may travel another 50,000 miles before needing another
     * oil change.
     *
     * @return true if an oil change is needed
     */
    @Override
    public Boolean needsOilChange() {
        // every 50000 miles
        // if you buy a new car, you don't need to change the oil, start changing the
        // oil after 50000
        // need the int value, otherwise you'll get a decimal number
        double threshold = (50000 * numTrips);
        // you don't need to change the oil if you just bought a honda
        if (numTrips != 0) {
            // distance has to be at least 50000 for an oil change
            // each trip should be at least 50000 miles long
            double changeInDistance = totalDistance - previousDistance;
            this.needsOilChange = (totalDistance - threshold) >= 0 && changeInDistance >= 50000;
        }

        return this.needsOilChange;
    }

    /**
     * This method should reset any flags set from when an oil change was needed. It
     * should also indicate that another 50,000 miles may be traveled before another
     * oil change is needed.
     */
    @Override
    public void changeOil() {
        this.needsOilChange = false;
        previousDistance = totalDistance;
    }

    /**
     * the check engine light should be on whenever something is wrong with the car.
     * This class simply turns on the light when an oil change is needed.
     * 
     * @return true if anything is wrong with the car
     */
    @Override
    public Boolean checkEngineLight() {
        return needsOilChange();
    }

    /**
     * This method should return the total distance traveled by the car. This number
     * can never decrease, so every time it is called the newest value returned
     * should be equal to or higher than all previous values.
     * 
     * @return total distance as a Double
     */
    @Override
    public Double getDistanceTraveled() {
        return this.totalDistance;
    }

    /**
     * Should return the top speed for a Kia (70 MPH)
     * 
     * @return 70.0
     */
    @Override
    public Double getTopSpeed() {
        return this.topSpeed;
    }

    /**
     * transport should calculate the time it takes in seconds to travel a distance
     * based on the top speed and update the amount of miles traveled.
     *
     * @param distance - length of travel in miles
     * @return time in seconds to travel distance
     */
    @Override
    public Integer transport(Double distance) {
        // first part converts the time it takes for a trip into seconds
        // trip time in hours, it could be like 3500 miles / 28.5 (the top speed of the
        // bike) which would be 122 hours (after truncating)
        Integer timeInHours = (int) (distance / getTopSpeed());
        Integer timeInSeconds = timeInHours * 3600;

        // update amount of miles traveled
        this.totalDistance += distance;
        numTrips++;

        return timeInSeconds;
    }

    @Override
    public String toString() {
        return "needsOilChange: " + needsOilChange + " topSpeed: " + topSpeed + " totalDistance: " + totalDistance
                + " previousDistance: " + previousDistance + " numTrips: " + numTrips;
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
        //downcasting to a specific version, in this case, KioOptima
        //this is why I override equals in each subclass and not in the abstract class for this part
        KiaOptima other = (KiaOptima) otherObj;
        //checks to see if the strings are equal
        return other.toString().equals(other.toString());
    }
}
