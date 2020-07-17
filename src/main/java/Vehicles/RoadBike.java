package Vehicles;

import Driving.Bike;

public class RoadBike extends Bike {

    public RoadBike() {
        super();
        recommendedTirePressure = 50;
        tirePressure = 50;
    }

    public Integer getTirePressure() {
        return tirePressure;
    }

    public void inflateTires() {
        tirePressure = recommendedTirePressure;
    }

    public Integer recommendedTirePressure() {
        return recommendedTirePressure;
    }

    public Double getTopSpeed() {
        Integer difference = recommendedTirePressure - tirePressure;
        topSpeed = 40.0 - difference;
        return topSpeed;
    }

    public Integer transport(Double distance) {
        Double miles = 0.0;
        while (miles <= distance) {
            miles += 1.0;
            if (distance >= 50 && miles % 50 == 0 && tirePressure > 40) {
                tirePressure--;
            }
        }
        double time = distance / getTopSpeed();
        double timeInMinutes = time * 60.0;
        double timeInSeconds = timeInMinutes * 60.0;
        Double answer = timeInSeconds;
        return answer.intValue();
    }
}