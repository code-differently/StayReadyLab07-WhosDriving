package Vehicles;

import Driving.Bike;

public class MountainBike extends Bike {

    private int PSI;

    public MountainBike()
    {
        this.PSI = 30;

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
        return 28.5 - (recommendedTirePressure() - this.PSI);
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
        int time = 3600;
        Double seconds = (distance / 28.5) * time;
        while(distance >= 30 && this.PSI > 20){
            this.PSI--;
            distance-=30;
        }
        return (int)Math.round(seconds);
    }

    /**
     * Gets the current amount of pressure in PSI
     * in the tires
     *
     * @return PSI as Integer
     */
    @Override
    public Integer getTirePressure() {
        return this.PSI;
    }

    /**
     * Returns the tires to the recommended PSI
     */
    @Override
    public void inflateTires() {
        this.PSI = recommendedTirePressure();
    }

    /**
     * The Recommended PSI of a mountain bike is 30
     * @return recommended PSI
     */
    @Override
    public Integer recommendedTirePressure() {
        return 30;
    }
}
