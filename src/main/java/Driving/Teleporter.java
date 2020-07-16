package Driving;

public class Teleporter implements Drivable {

    private Double distance = 0.0;

    public Double getTopSpeed() {
        return Double.MAX_VALUE;
    }

    public Integer transport(Double distance) {
        this.distance += distance; //Instant teleportation!
        return 0;
    }


    
}