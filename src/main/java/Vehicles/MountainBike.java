package Vehicles;

import Driving.Bike;

public class MountainBike extends Bike {
    private final Integer RECOMMENDEDTIREPRESSURE;
    private final Double TOPSPEED;
    private Integer actualTirePressure;
    private Double actualSpeed;

    public MountainBike() {
        this.RECOMMENDEDTIREPRESSURE = 30;
        this.TOPSPEED = 28.5;
        this.actualTirePressure = 0;
        this.actualSpeed = 0.0;
    }
    /**
     * The top speed of a mountain bike should be 28.5
     * but for every 1 PSI under the recommended tire
     * pressure the tires of the bike are, the top
     * speed should be reduced 1mph.
     *
     * @return 28.5 minus any reduction to top speed
     */
    public Double getTopSpeed() {
        Double actualSpeed = this.TOPSPEED;
        int speedReduction = 0;
        if(this.actualTirePressure < this.RECOMMENDEDTIREPRESSURE) {
           speedReduction = this.RECOMMENDEDTIREPRESSURE - this.actualTirePressure;
        }
        actualSpeed -= speedReduction;
        return actualSpeed;
    }


    /**
     * transport should calculate the time it takes in
     * seconds to travel a distance base on the top
     * speed and update the tire pressure. Long trips
     * on a mountain bike will reduce its PSI, so for
     * every 30 miles traveled in a single trip, the
     * tires of the bike should reduce 1 PSI until
     * the tires register 20 PSI where no more air
     * will be lost on trips.
     *
     * @param distance - length of travel in miles
     * @return time in seconds to travel distance
     */
    public Integer transport(Double distance) {
        Double actualSpeed = this.TOPSPEED;
        //first part converts the time it takes for a trip into seconds
        Integer timeInHours = (int) (distance / getTopSpeed());
        Integer timeInMinutes = timeInHours / 60;
        Integer timeInSeconds = timeInHours / 3600;

        //gives amount of reductions for every 30 minutes
        Integer amountToReduce = timeInMinutes % 30;
        Integer newTirePressure = getTirePressure() - amountToReduce;
        if(newTirePressure >= 20) {
            this.actualTirePressure = newTirePressure;
        }

        return timeInSeconds;
    }

    /**
     * Gets the current amount of pressure in PSI
     * in the tires
     *
     * @return PSI as Integer
     */
    @Override
    public Integer getTirePressure() {
        return this.actualTirePressure;
    }

    /**
     * Returns the tires to the recommended PSI
     */
    @Override
    public void inflateTires() {

    }

    /**
     * The Recommended PSI of a mountain bike is 30
     * @return recommended PSI
     */
    @Override
    public Integer recommendedTirePressure() {
        return this.RECOMMENDEDTIREPRESSURE;
    }
}
