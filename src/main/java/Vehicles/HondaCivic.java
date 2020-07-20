package Vehicles;

import Driving.Car;

public class HondaCivic extends Car {

    private boolean oilChangeNeeded;
    private Double totalDistanceTraveled;

    public HondaCivic(){
        topSpeed = 70.0;
        oilChangeNeeded = false;
        givenDistance = 0.0;
        totalDistanceTraveled = 0.0;
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

        if(givenDistance >= 50000 && totalDistanceTraveled != 0)
            oilChangeNeeded = true;

        return oilChangeNeeded;
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
        System.out.println("The oil was changed, you can now go another 50, 000 miles before needeing another one.");
        oilChangeNeeded = false; //reset oilChangeNeeded
        givenDistance = 0.0;
    }

    protected boolean getOilChangeNeeded(){
        return oilChangeNeeded;
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
        if(needsOilChange())
            return true;
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
        return totalDistanceTraveled;
    }

    /**
     * Should return the top speed for a Civic (70 MPH)
     * @return 70.0
     */
    @Override
    public Double getTopSpeed() {
        return topSpeed;
    }

    /**
     * transport should calculate the time it takes in
     * seconds to travel a distance base on the top
     * speed and update the amount of miles traveled.
     *
     * @param distance - length of travel in miles
     * @return time in seconds to travel distance
     */
    @Override
    public Integer transport(Double distance) {
        givenDistance = distance;

        double time = (distance / topSpeed) * 3600;

        totalDistanceTraveled += distance;

        return (int) time;
    }
}
