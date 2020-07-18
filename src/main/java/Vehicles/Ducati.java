package Vehicles;

import Driving.Bike;


public class Ducati extends Bike {

    private Integer tirePsi;
    private double topSpeed;

    public Ducati() {

        inflateTires();
    }
    @Override
    public Double getTopSpeed() {

        return this.topSpeed;
    }


    @Override
    public Integer transport(Double distance) {

        double time = (distance / getTopSpeed()) * 3600;

        deflateTires(distance);

        return (int) time;
    }


    @Override
    public Integer getTirePressure() {

        if(this.tirePsi < 20) {

            this.tirePsi = 20;
        }

        return this.tirePsi;
    }

    @Override
    public void inflateTires() {

        this.tirePsi = recommendedTirePressure();
        this.topSpeed = 202;

    }

    @Override
    public Integer recommendedTirePressure() {

        return 30;
    }

    private void deflateTires(Double distance) {

        int val = 0;
        if(distance > 30 && distance % 30 != 0) {

            this.tirePsi--;
            this.topSpeed--;

        } else if (distance % 30 == 0) {

            this.tirePsi -= (int) (distance/30);
            this.topSpeed -= (distance/30);
        }
    }



}
