package Driving;

public abstract class Teleporter implements Drivable{

    protected double getDistanceTraveled;
    protected double sendPassengers;
    protected Integer time=1;


    public abstract double getDistance();

    public abstract double sendPassengers();

}
