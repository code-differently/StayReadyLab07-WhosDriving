package Vehicles;

import Driving.Car;

public class FordMustang extends Car {

    /**
     * A mustang should need an oil change every
     * 35,000 miles traveled. Once the oil is
     * changed, the car may travel another 35,000
     * miles before needing another oil change.
     *
     * @return true if an oil change is needed
     */
    @Override
    public Boolean needsOilChange() {
        return milesSinceOilChange == 35000.0;
    }

    /**
     * This method should reset any flags set
     * from when an oil change was needed. It
     * should also indicate that another 35,000
     * miles may be traveled before another oil
     * change is needed.
     */
    @Override
    public void changeOil() {
        milesSinceOilChange = 0.0;
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
        return distanceTraveled;
    }

    /**
     * Should return the top speed for a Mustang (100 MPH)
     * @return 100.0
     */
    //@Override
    public Double getTopSpeed() {
        return 100.0;
    }

    /**
     * transport should calculate the time it takes in
     * seconds to travel a distance base on the top
     * speed and update the amount of miles traveled.
     *
     * @param distance - length of travel in miles
     * @return time in seconds to travel distance
     */
    //@Override
    public Integer transport(Double distance) {
        distanceTraveled += distance;
        milesSinceOilChange += distance;
        return (int)Math.round(distance / (getTopSpeed() / 3600));
    }

}
