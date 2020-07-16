package Vehicles;

import Driving.Bike;

public class SantaCruzBike extends Bike{

    private int PSI;

    public SantaCruzBike(){
        this.PSI = 40;

    }

    public Double getTopSpeed() {
        return 28.5 - (recommendedTirePressure() - this.PSI);
    }

    public Integer transport(Double distance) { 
        int time = 3600;
        Double seconds = (distance / 28.5) * time;
        while(distance >= 30 && this.PSI > 20){
            this.PSI--;
            distance-=30;
        }
        return (int)Math.round(seconds);
    }

    @Override
    public void inflateTires() {
        this.PSI = recommendedTirePressure();
    }

    @Override
    public Integer recommendedTirePressure() {
        return 30;
    }

    @Override
    public Integer getTirePressure() {
        return this.PSI;
    }

}