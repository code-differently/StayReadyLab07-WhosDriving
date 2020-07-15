package Vehicles;

import Driving.Car;

public class HondaCivic extends Car {
    private boolean needsOilChange;
    private final double topSpeed;
    private Double totalDistance;

    public HondaCivic() {
        needsOilChange = false;
        topSpeed = 70.0;
        totalDistance = 0.0;
    }
    /**
     * A civic should need an oil change every
     * 50,000 miles traveled. Once the oil is
     * changed, the car may travel another 50,000
     * miles before needing another oil change.
     *
     * @return true if an oil change is needed
     */
    @Override
    public Boolean needsOilChange() {
        //every 50000 miles
        //if you buy a new car, you don't need to change the oil, start changing the oil after 50000
        if(getDistanceTraveled() / 50000 > 0) {
            this.needsOilChange = true;
        }
        else {
            this.needsOilChange = false;
        }
        return this.needsOilChange;
    }

    /**
     * This method should reset any flags set
     * from when an oil change was needed. It
     * should also indicate that another 50,000
     * miles may be traveled before another oil
     * change is needed.
     */
    @Override
    public void changeOil() {
        this.needsOilChange = false;
    }

    /**
     * the check engine light should be on whenever
     * something is wrong with the car. This class
     * simply turns on the light when an oil change
     * is needed.
     * @return true if anything is wrong with the car
     */
    @Override
    public Boolean checkEngineLight() {
        return needsOilChange();
    }

    /**
     * This method should return the total distance
     * traveled by the car. This number can never
     * decrease, so every time it is called the newest
     * value returned should be equal to or higher
     * than all previous values.
     * @return total distance as a Double
     */
    @Override
    public Double getDistanceTraveled() {
        return this.totalDistance;
    }

    /**
     * Should return the top speed for a Civic (70 MPH)
     * @return 70.0
     */
    @Override
    public Double getTopSpeed() {
        return this.topSpeed;
    }

    /**
     * transport should calculate the time it takes in
     * seconds to travel a distance based on the top
     * speed and update the amount of miles traveled.
     *
     * @param distance - length of travel in miles
     * @return time in seconds to travel distance
     */
    @Override
    public Integer transport(Double distance) {
        //first part converts the time it takes for a trip into seconds
        //trip time in hours, it could be like 3500 miles / 28.5 (the top speed of the bike) which would be 122 hours (after truncating)
        Integer timeInHours = (int) (distance / getTopSpeed());
        Integer timeInSeconds = timeInHours * 3600;

        //update amount of miles traveled
        this.totalDistance += distance;

        return timeInSeconds;
    }
}
