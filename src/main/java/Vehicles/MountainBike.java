package Vehicles;

import Driving.Bike;

public class MountainBike extends Bike {
    public MountainBike() {
        super();
        recommendedTirePressure = 30;
        tirePressure = 30;
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
        Integer difference = recommendedTirePressure - tirePressure;
        topSpeed = 28.5 - difference;
        return topSpeed;
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
        Double miles = 0.0;
        while (miles <= distance) {
            miles += 1.0;
            if (distance >= 30 && miles % 30 == 0 && tirePressure > 20) {
                tirePressure--;
            }
        }
        double time = distance / getTopSpeed();
        double timeInMinutes = time * 60.0;
        double timeInSeconds = timeInMinutes * 60.0;
        Double answer = timeInSeconds;
        return answer.intValue();
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
        tirePressure = recommendedTirePressure;
    }
    /**
     * The Recommended PSI of a mountain bike is 30
     * @return recommended PSI
     */
    @Override
    public Integer recommendedTirePressure() {
        return recommendedTirePressure;
    }
}
