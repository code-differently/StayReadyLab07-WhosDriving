package Vehicles;

import Driving.Bike;

public class MountainBike extends Bike {
    private double topSpeed;
    static final double recTirePressure = 30; 
    private double tirePressure; 

    public MountainBike(){
        this.tirePressure = 30;
        this.topSpeed = 28.5;
    }

    /**
     * The top speed of a mountain bike should be 28.5
     * but for every 1 PSI under the recommended tire
     * pressure the tires of the bike are, the top
     * speed should be reduced 1mph.
     *
     * @return 28.5 minus any reduction to top speed
     */

    //@Override
    public Double getTopSpeed() {
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
    //@Override
    public Integer transport(Double distance) {
        int limit = 20; //tire pressure limit
        int time  = 0; 
        if(distance - 30 < 0){
            return 3600;
        }
        while (distance - 30 >= 0 ){
            this.topSpeed --;
            if(this.tirePressure > limit){
                this.tirePressure--; 
            } 
            time += (distance / this.topSpeed);
            distance -=  30; 
        }
        return time *= 3600;
    }

    /**
     * Gets the current amount of pressure in PSI
     * in the tires
     *
     * @return PSI as Integer
     */
    @Override
    public Integer getTirePressure() {
        return (int) tirePressure;
    }

    public void setTirePressure(Double psi){
        this.tirePressure = psi;
    }

    /**
     * Returns the tires to the recommended PSI
     */
    @Override
    public void inflateTires() {
        this.tirePressure = recTirePressure;
        this.topSpeed = 28.5;
    }

    /**
     * The Recommended PSI of a mountain bike is 30
     * @return recommended PSI
     */
    @Override
    public Integer recommendedTirePressure() {
        return (int) recTirePressure;
    }
}
