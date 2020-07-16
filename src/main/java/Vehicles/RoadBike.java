package Vehicles;

import Driving.Bike;

public class RoadBike extends Bike {
    private final Integer RECOMMENDEDTIREPRESSURE;
    private final Double TOPSPEED;
    private Integer actualTirePressure;
    private Double actualSpeed;

    public RoadBike() {
        this.RECOMMENDEDTIREPRESSURE = 15;
        this.TOPSPEED = 15.0;
        this.actualTirePressure = 15;
        this.actualSpeed = 15.0;
    }

    public Integer getRECOMMENDEDTIREPRESSURE() {
        return RECOMMENDEDTIREPRESSURE;
    }

    public Double getTOPSPEED() {
        return TOPSPEED;
    }

    public Integer getActualTirePressure() {
        return actualTirePressure;
    }

    public void setActualTirePressure(Integer actualTirePressure) {
        this.actualTirePressure = actualTirePressure;
    }

    public Double getActualSpeed() {
        return actualSpeed;
    }

    public void setActualSpeed(Double actualSpeed) {
        this.actualSpeed = actualSpeed;
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
        //gives amount of reductions for every 60 minutes
        //will return 0 if less than 30
        Integer amountToReduce = distanceInt / 60;
        Integer newTirePressure = getTirePressure() - amountToReduce;
        //if the new tire pressure is less than 40, set the tire pressure to 40
        if(newTirePressure < 10) {
            this.actualTirePressure = 10;
        }
        //the new tire pressure is greater than 40, so set the actualTirePressure to tirePressure
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

    @Override
    public String toString() {
        return "recommended tire pressure: " + this.RECOMMENDEDTIREPRESSURE + " top speed: " + this.TOPSPEED + " actualTirePressure: " + this.actualTirePressure + " actualSpeed: " + this.actualSpeed;
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
        //downcasting to a specific version, in this case, roadbike
        //this is why I override equals in each subclass and not in the abstract class for this part
        RoadBike other = (RoadBike) otherObj;
        //checks to see if the strings are equal
        return other.toString().equals(other.toString());
    }
}
