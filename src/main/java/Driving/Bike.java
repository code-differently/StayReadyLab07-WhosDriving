package Driving;

public abstract class Bike implements Drivable 
{
    protected Integer tirePressure = 0;
    protected Integer recommendedPressure = 0;
    protected Double distanceTraveled = 0.0;
    protected Double topSpeed = 0.0;

    /**
     * It is important on a bike that the tire pressure
     * is monitored closely. The getTirePressure method
     * should be used to detect if tire inflation is needed
     *
     * @return pressure in PSI
     */
    public abstract Integer getTirePressure();

    /**
     * When the inflateTires method is called the
     * tire pressure of the tires of the bike
     * should be reset to recommendedTirePressure
     */
    public abstract void inflateTires();

    /**
     * This method should return the recommended PSI
     * of the tires currently attached to the bike
     * @return PSI as an Integer
     */
    public abstract Integer recommendedTirePressure();

    public abstract Double getTopSpeed();

    public abstract Integer transport(Double distance);
}
