package Vehicles;
import Driving.Car;

public class Tesla extends Car {

  private double miles; 
    private double distanceTraveled; 

    public Tesla(){
        this.miles = 0.0;
        this.distanceTraveled = 0.0; 
    }

    public void setMiles(double miles) {
        this.miles = miles;
    }

    @Override
    public Boolean needsOilChange() {
        if(miles >= 100000){
            return true; 
        } else {
            return false;
        }
    }

    @Override
    public void changeOil() {
        System.out.println("Oil restored! You can travel for another 100,000 miles");
        setMiles(0);
    }

    @Override
    public Boolean checkEngineLight() {
        if(needsOilChange()){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Double getDistanceTraveled() {
        return this.distanceTraveled;
    }

    public Double getTopSpeed() {
        return 200.0 ;
    }

    public Integer transport(Double distance) {
        double time = (distance / getTopSpeed())  * 3600.0; 
        setDistanceTraveled(this.distanceTraveled + distance); //miles + distance travelled 
        setMiles(distance);
        return (int) time; 
    }

    public void setDistanceTraveled(double d) {
        this.distanceTraveled = d; 
    }

    @Override
    public String toString(){
        return "Tesla";
    }

    @Override
    public boolean equals(Object o){
        return this.toString().equalsIgnoreCase(o.toString());
    }

  
}