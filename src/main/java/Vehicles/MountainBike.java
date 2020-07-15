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
        this.actualTirePressure = 30;
        this.actualSpeed = 28.5;
    }
    /**
     * The top speed of a mountain bike should be 28.5
     * but for every 1 PSI of the current tire pressure under the recommended tire
     * pressure the tires of the bike are, the top
     * speed should be reduced 1mph.
     *
     * @return 28.5 minus any reduction to top speed
     */
    public Double getTopSpeed() {
        Double actualSpeed = this.TOPSPEED;
        //if the tires are full of air, then there will be no speed reduction
        //thus actual speed will stay the same, but if the actualTirePressure is less than the recommended (meaning you don't have a tire full of air, potentially a flat tire), then you won't be going so fast
        //so the top speed will decrease as a result
        int speedReduction = 0;
        if(this.actualTirePressure < this.RECOMMENDEDTIREPRESSURE) {
            //say you have a tire pressure of 28 and the recommended is 30. Then you would need to subtract 2 PIS
           speedReduction = this.RECOMMENDEDTIREPRESSURE - this.actualTirePressure;
        }
        actualSpeed -= speedReduction;
        return actualSpeed;
    }


    /**
     * transport should calculate the time it takes in
     * seconds to travel a distance based on the top
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
        //first part converts the time it takes for a trip into seconds
        Integer timeInHours = 0;
        //trip time in hours, it could be like 3500 miles / 28.5 (the top speed of the bike) which would be 122 hours (after truncating)
        timeInHours = (int) (distance / getTopSpeed());
        Integer timeInSeconds = timeInHours * 3600;

        //if you do Math.round then you'll get the wrong answer because for 29.9 it rounds it up to 30, and 30/30 is 1, not 0, which it should be if its 29.9/30
        Integer distanceInt = distance.intValue();
        //gives amount of reductions for every 30 minutes
        //will return 0 if less than 30
        Integer amountToReduce = distanceInt / 30;
        Integer newTirePressure = getTirePressure() - amountToReduce;
        //if the new tire pressure is less than 20, set the tire pressure to 20
        if(newTirePressure < 20) {
            this.actualTirePressure = 20;
        }
        //the new tire pressure is greater than 20, so set the actualTirePressure to tirePressure
        else {
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
        this.actualTirePressure = this.RECOMMENDEDTIREPRESSURE;
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
