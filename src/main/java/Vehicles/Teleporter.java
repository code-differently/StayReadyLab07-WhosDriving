package Vehicles;

import Driving.Drivable;

public class Teleporter implements Drivable {

  private double topSpeed; 

  public Teleporter(){
    this.topSpeed = 0; //instantanous arrival. Teleportation
  }

  public Double getTopSpeed(){
    return this.topSpeed; 
  }

  public Integer transport(Double distance) {
	  Double time = distance * getTopSpeed();
  	return time.intValue();
}



  
}