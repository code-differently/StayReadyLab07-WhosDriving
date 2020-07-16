package Vehicles;

import Driving.Bike;

public class TandemBike extends Bike {

  private double topSpeed;
  static final double recTirePressure = 35; 
  private double tirePressure; 

  public TandemBike(){
      this.tirePressure = 35;
      this.topSpeed = 20.5;
  }

  public Double getTopSpeed() {
      return topSpeed;
  }

  public Integer transport(Double distance) {
      int limit = 25; //tire pressure limit
      int time  = 0; 
      if(distance - 20 < 0){
          return 3600;
      }
      while (distance - 20 >= 0 ){
          this.topSpeed --;
          if(this.tirePressure > limit){
              this.tirePressure--; 
          } 
          time += (distance / this.topSpeed);
          distance -=  20; 
      }
      return time *= 3600;
  }

  @Override
  public Integer getTirePressure() {
      return (int) tirePressure;
  }

  public void setTirePressure(Double psi){
      this.tirePressure = psi;
  }

  @Override
  public void inflateTires() {
      this.tirePressure = recTirePressure;
      this.topSpeed = 20.5;
  }

  @Override
  public Integer recommendedTirePressure() {
      return (int) recTirePressure;
  }
  
}