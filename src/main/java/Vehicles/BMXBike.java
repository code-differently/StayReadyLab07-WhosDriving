package Vehicles;

import Driving.Bike;

public class BMXBike extends Bike {
    private int tirePressure = 85;

    /**
     * The top speed of a BMX bike should be 57.5
     * but for every 2 PSI under the recommended tire
     * pressure the tires of the bike are, the top
     * speed should be reduced 2mph.
     *
     * @return 57.5 minus any reduction to top speed
     */
    //@Override
    public Double getTopSpeed() {
        return 57.5 - 2 * (recommendedTirePressure() - getTirePressure());
    }

    /**
     * transport should calculate the time it takes in
     * seconds to travel a distance base on the top
     * speed and update the tire pressure. Long trips
     * on a BMX bike will reduce its PSI, so for
     * every 20 miles traveled in a single trip, the
     * tires of the bike should reduce 2 PSI until
     * the tires register 30 PSI where no more air
     * will be lost on trips.
     *
     * @param distance - length of travel in miles
     * @return time in seconds to travel distance
     */
    //@Override
    public Integer transport(Double distance) {
        if(tirePressure > 30 && distance >= 20)
            tirePressure -= 2 * (distance / 20);
        if(tirePressure < 30)
            tirePressure = 30;
        return (int)Math.round(distance / (getTopSpeed() / 3600));
    }

    /**
     * Gets the current amount of pressure in PSI
     * in the tires
     *
     * @return PSI as Integer
     */
    @Override
    public Integer getTirePressure() {
        return tirePressure;
    }

    /**
     * Returns the tires to the recommended PSI
     */
    @Override
    public void inflateTires() {
        tirePressure = recommendedTirePressure();
    }

    /**
     * The Recommended PSI of a BMX bike is 85
     * @return recommended PSI
     */
    @Override
    public Integer recommendedTirePressure() {
        return 85;
    }
}