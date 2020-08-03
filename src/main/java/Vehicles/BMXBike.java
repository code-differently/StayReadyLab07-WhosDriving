package Vehicles;

import Driving.Bike;

public class BMXBike extends Bike {

    public BMXBike() {
        topSpeed = 50.0;
        psi = 30;
        distanceTraveled = 0.0;
    }

    public Integer getTirePressure() {
        return psi;
    }

    public void inflateTires() {
        psi = recommendedTirePressure();
        topSpeed = 50.0;
    }

    public Integer recommendedTirePressure() {
        return recommendedPsi;
    }

    public Double getTopSpeed() {
        topSpeed -= recommendedPsi - psi;
        return topSpeed;
    }

    public Integer transport(Double distance) {
        int timeInSec = 0;

        for (int i=0; i<distance/30; i++){
            timeInSec += (int)(distance/topSpeed*3600);
            if(psi == 20)
                psi = 20;
            else
                psi--;
        }
        distanceTraveled += distance;
        return timeInSec;
    }
}
