package Vehicles;

import Driving.Bike;

public class SantaCruzBike extends Bike {
    private double topSpeed;
    private double tirePressure;
    static final double recTirePressure = 30;

    public SantaCruzBike(){
        this.topSpeed = 28.5;
        this.tirePressure = 30;
    }

    @Override
    public double getTopSpeed() {
        return topSpeed;
    }

    @Override
    public Integer transport(Double distance) {
        int limit = 20;
        int time = 0;
        if (distance - 30 < 0){
            return 3600;
        }
        while (distance - 30 >= 0) {
            this.topSpeed --;
            if (this.tirePressure > limit) {
                this.tirePressure --;
            }
            time += (distance / this.topSpeed);
            distance -= 30;
        }
        return time *= 3600;
    }

    @Override
    public Integer getTirePressure() {
        return (int)tirePressure;
    }

    @Override
    public void inflateTires() {
        this.tirePressure = recTirePressure;
        this.topSpeed = 28.5;
    }

    @Override
    public Integer recommendedTirePressure() {
        return (int)recTirePressure;
    }
}

