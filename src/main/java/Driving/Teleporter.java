package Driving;

public class Teleporter implements Drivable{
    private double totalDistance;

    public Double getTopSpeed(){
        return 0.0;
    }

    public Integer transport(Double distance) {
        totalDistance += distance;
        return (int) totalDistance;
    }
}