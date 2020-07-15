package Driving;

public class Teleporter implements Drivable {
    private final double speed=Double.MAX_VALUE;

    public Teleporter(){
    }

    public Double getTopSpeed() {
        return speed;
    }

    public Integer transport(Double distance) {
        // INSTANT TRAVEL
        return 0;
    }
}
