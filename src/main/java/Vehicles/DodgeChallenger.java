package Vehicles;

import Driving.Car;

public class DodgeChallenger extends Car {
    /**
     * A civic should need an oil change every
     * 50,000 miles traveled. Once the oil is
     * changed, the car may travel another 50,000
     * miles before needing another oil change.
     *
     * @return true if an oil change is needed
     */
    private double milesTraveled;

    public void setDistanceTraveled(double milesTraveled)
    {
        this.milesTraveled = milesTraveled;
    }


    @Override
    public Boolean needsOilChange()
    {
        //checks if it 50k miles
        if(getDistanceTraveled() > 4000)
        {
            // changeOil();
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
    public void changeOil()
    {
        System.out.println("You may travel another 4 thousand miles before needing another oil change, stay safe!");
        this.setDistanceTraveled(0);
    }

    /**
     * the check engine light should be on whenever
     * something is wrong with the car. This class
     * simply turns on the light when an oil change
     * is needed.
     * @return true if anything is wrong with the car
     */
    @Override
    public Boolean checkEngineLight()
    {
        if(needsOilChange())
        {
            //if it needs an oil change, turn on the light
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
        return milesTraveled;
    }


    /**
     * Should return the top speed for a Civic (70 MPH)
     * @return 70.0
     */
    public Double getTopSpeed() {
        return 70.0;
    }

    /**
     * transport should calculate the time it takes in
     * seconds to travel a distance base on the top
     * speed and update the amount of miles traveled.
     *
     * @param distance - length of travel in miles
     * @return time in seconds to travel distance
     */
    public Integer transport(Double distance)
    {
        Double currentMileage = getDistanceTraveled();
        double timeInSeconds =  distance / getTopSpeed() * 60 * 60;
        setDistanceTraveled(currentMileage + distance);
        int returnVal = (int) timeInSeconds;

        return returnVal;
    }

    @Override
    public String toString() {
        return "Dodge Challenger";
    }
}
