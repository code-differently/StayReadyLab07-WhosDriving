package Vehicles;

import Driving.Drivable;

public class Teleporter implements Drivable {

    private int totalTravels;
    private int batteryLevel = 100;

    public Double getTopSpeed() {
        return Double.MAX_VALUE;
    }

    // One second to travel each time, returns number of seconds traveled
    public Integer transport(Double times) {
        for(int i = 0; i < times; i++) {
            totalTravels++;
            batteryLevel--;
        }
        return 100 - batteryLevel;
    }

    /**
     * A teleporter should need to recharge every
     * 100 times traveled. Once the battery is
     * charged, the teleporter may travel another 300
     * times before needing another battery charge.
     *
     * @return true if the battery needs to be charged
     */
    public Boolean needsBatteryCharge() {
        return batteryLevel == 0;
    }

    /**
     * This method should reset any flags set
     * from when an battery charge was needed. It
     * should also indicate that another 300
     * travels may be traveled before another battery
     * charge is needed.
     */
    public void chargeBattery() {
        batteryLevel = 100;
    }

    /**
     * the lower battery light should be on when
     * the teleporter is about to die. This method
     * simply turns on the light when an battery charge
     * is needed.
     * @return true if anything is wrong with the teleporter
     */
    public Boolean checkLowBatteryLight() {
        return needsBatteryCharge();
    }

    /**
     * This method should return the total times
     * traveled by the teleporter. This number can never
     * decrease, so every time it is called the newest
     * value returned should be equal to or higher
     * than all previous values.
     * @return total times as a Integer
     */
    public Integer getTimesTraveled() {
        return totalTravels;
    }

}
