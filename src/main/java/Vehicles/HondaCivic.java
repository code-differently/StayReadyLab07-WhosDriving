package Vehicles;

import Driving.Car;

public class HondaCivic extends Car {
    private double distanceTraveled;
    public void setDistanceTraveled(double distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
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
        Boolean verdict = true;
        if(distanceTraveled < 50000.0){
            verdict = false;
        }
        return verdict;
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
        if(needsOilChange() == true){
            distanceTraveled = 0;
            System.out.println("50,000 miles may be traveled before another oil change is needed ");
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
     * Should return the top speed for a Civic (70 MPH)
     * @return 70.0
     */
    public Double getTopSpeed() {
        return 70.0;
    }
    /**
     * transport should calculate the time it takes in
     * seconds to travel a distance base on top
     * speed and update the amount of miles traveled.
     *
     * @param distance - length of travel in miles
     * @return time in seconds to travel distance
     */
    public Integer transport(Double distance) {
        Integer time = (int)(distance/getTopSpeed());
        time = time * 3600;
        setDistanceTraveled(distance);
        return time;
    }
    @Override
    public boolean equals(Object object){
        return this.toString().equals(object.toString());
    }
    @Override
    public String toString(){
        return "I am honda civic";
    }
}
