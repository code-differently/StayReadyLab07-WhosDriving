package Vehicles;
import Driving.Car;
public class BMW extends Car {
    private double distanceTraveled;
    public void setDistanceTraveled(double distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }
    @Override
    public Boolean needsOilChange() {
        Boolean verdict = true;
        if(distanceTraveled < 15000.0){
            verdict = false;
        }
        return verdict;
    }
    @Override
    public void changeOil() {
        if(needsOilChange() == true){
            distanceTraveled = 0;
            System.out.println("15,000 miles may be traveled before another oil change is needed ");
        }
    }
    @Override
    public Boolean checkEngineLight() {
        return needsOilChange();
    }
    @Override
    public Double getDistanceTraveled() {
        return distanceTraveled;
    }
    public Double getTopSpeed() {
        return 100.0;
    }
    public Integer transport(Double distance) {
        Integer time = (int)(distance/getTopSpeed());
        time = time * 3600;
        setDistanceTraveled(distance);
        return time;
    }
    @Override
    public boolean equals(Object object){
        return this.toString().equals(object.toString());
    }
    @Override
    public String toString(){
        return "I am BMW";
    }
}
