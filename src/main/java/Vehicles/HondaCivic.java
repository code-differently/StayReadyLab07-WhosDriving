package Vehicles;

import Driving.Car;

public class HondaCivic extends Car {
    private double distanceTraveled;
    private double milesTraveled;

    public HondaCivic(){
        this.distanceTraveled = 0.0;
        this.milesTraveled = 0.0;
    }

    public HondaCivic (double distance, double milesTraveled){
        this.distanceTraveled = distance;
        this.milesTraveled = milesTraveled;
    }

    public void setDistanceTraveled(double distance) {
        this.distanceTraveled = distance;
    }


    public void setMilesTraveled(double milesTraveled) {
        this.milesTraveled = milesTraveled;
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
        if (milesTraveled >= 50000){
            return true;
        }else {
            return false;
        }
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
        System.out.println("Car is now able to drive another 50,000 miles");
        setDistanceTraveled(0);
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
        if(needsOilChange()){
            return true;
        }else {
            return false;
        }

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
     * Should return the top speed for a Civic (70 MPH)
     * @return 70.0
     */
    @Override
    public double getTopSpeed() {
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
    @Override
    public Integer transport(Double distance) {
        double time = (distance/getTopSpeed()) * 3600;
        setDistanceTraveled(this.distanceTraveled + distance);
        setMilesTraveled(distance);
        return (int)time;
    }
}
