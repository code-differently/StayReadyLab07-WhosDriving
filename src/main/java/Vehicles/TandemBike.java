package Vehicles;

import Driving.Bike;

public class TandemBike extends Bike
{
    public TandemBike()
    {
        topSpeed = 32.5;
        tirePressure = 30;
        distanceTraveled = 0.0;
        recommendedPressure = 30;
    }
    /**
     * The top speed of a mountain bike should be 32.5
     * but for every 1 PSI under the recommended tire
     * pressure the tires of the bike are, the top
     * speed should be reduced 1mph.
     *
     * @return 32.5 minus any reduction to top speed
     */
    @Override
    public Double getTopSpeed() 
    {

        topSpeed -= (recommendedPressure - tirePressure);
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
    @Override
    public Integer transport(Double distance) 
    { 
        if (tirePressure > 20)
        {
           Integer reducePSI =  Math.round((int)(distance/30));
           tirePressure -= reducePSI;
        }
        else
        {
            tirePressure = 20;
        }
        distanceTraveled += distance;
        return Math.round((int)(distance/topSpeed)* 3600); // distance/speed = time, to convert to seconds * time by 3600
    }

    /**
     * Gets the current amount of pressure in PSI
     * in the tires
     *
     * @return PSI as Integer
     */
    @Override
    public Integer getTirePressure() 
    {
        return tirePressure;
    }

    /**
     * Returns the tires to the recommended PSI
     */
    @Override
    public void inflateTires() 
    {
        tirePressure = recommendedTirePressure();
    }

    /**
     * The Recommended PSI of a mountain bike is 30
     * @return recommended PSI
     */
    @Override
    public Integer recommendedTirePressure() 
    {
        return recommendedPressure;
    }
}