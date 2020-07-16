package Vehicles;
import Driving.Teleporter;

public class TimeMachine extends Teleporter{

    public TimeMachine(){
        super();
    }

    @Override
    public double getDistance() {
        return getDistanceTraveled;
    }

    @Override
    public double sendPassengers() {
        if (sendPassengers >= 0){
            time = 1;
            transport(getDistanceTraveled);
        }
        return time;
    }

    public Double getTopSpeed() {
        return 250.0;
    }

    public Integer transport(Double distance) {
        double space = 0.0;
        if (space == time){
            return time;
        }
        getDistanceTraveled += distance;
        return time;
    }

}