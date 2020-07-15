package Vehicles;

import Driving.Bike;

public class TouringBike extends Bike {
    private int psi;

    public TouringBike(){
        this.psi=40;

    }
    @Override
    public Double getTopSpeed() {
        return 36.5-(recommendedTirePressure()-this.psi);
    }


    @Override
    public Integer transport(Double distance) {
        Double seconds=(distance/34.5)*60*60;
        while(distance>=50 && this.psi>30){
            this.psi--;
            distance-=50;
        }
        return (int)Math.round(seconds);
    }

    @Override
    public Integer getTirePressure() {
        return this.psi;
    }


    @Override
    public void inflateTires() {
        this.psi=recommendedTirePressure();

    }


    @Override
    public Integer recommendedTirePressure() {
        return 40;
    }
}
