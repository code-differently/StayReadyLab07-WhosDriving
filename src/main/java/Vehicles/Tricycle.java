package Vehicles;

import Driving.Bike;

public class Tricycle extends Bike {

    // constructor
    public Tricycle() {
        // variables from bike;
        topSpeed = 11;
        recommendedTirePressure = 30;
        tirePressure = 30;
    }

    @Override
    public Double getTopSpeed() {
        return topSpeed;
    }



    @Override
    public Integer transport(Double distance) {
        Double time = 0.00;
        int tirePressureLimit = 20;
        if (distance < 30) {
            time = 3600.00;
            return time.intValue();
        } else {
            while (distance - 30 >= 0) {
                if (tirePressure > 20) {
                    tirePressure--;
                }
                topSpeed--;
                distance -= 30;
                time += distance / topSpeed;
            }
            return time.intValue() * 60 * 60;
        }
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
        topSpeed = 28.5;

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
