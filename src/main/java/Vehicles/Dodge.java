package Vehicles;

import Driving.Car;

public class Dodge extends Car{

    public Dodge() {
        super();
    }
    /**
     * A dodge should need an oil change every
     * 50,000 miles traveled. Once the oil is
     * changed, the car may travel another 50,000
     * miles before needing another oil change.
     *
     * @return true if an oil change is needed
     */
    @Override
    public Boolean needsOilChange() {
        if (distanceBeforeOilChange <= 0) {
            return true;
        }
        return false;
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
        if (needsOilChange()) {
            distanceBeforeOilChange = 50000;
            System.out.println("Another 50,000 miles may be traveled before another oil change is needed!");
        }
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
        if (needsOilChange()) {
            return true;
        }
        return false;
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
     * Should return the top speed for a Dodge (199 MPH)
     * @return 199.0
     */
    public Double getTopSpeed() {
        return 199.0;
    }
    /**
     * transport should calculate the time it takes in
     * seconds to travel a distance base on the top
     * speed and update the amount of miles traveled.
     *
     * @param distance - length of travel in miles
     * @return time in seconds to travel distance
     */
    public Integer transport(Double distance) {
        double time = distance / getTopSpeed();
        double timeInMinutes = time * 60.0;
        double timeInSeconds = timeInMinutes * 60.0;
        Double answer = timeInSeconds;
        distanceTraveled += distance;
        distanceBeforeOilChange -= distance;
        return answer.intValue();
    }
}
