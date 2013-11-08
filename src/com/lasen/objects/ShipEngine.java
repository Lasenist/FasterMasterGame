package com.lasen.objects;


/**
 *
 * @author Lasen
 */
public class ShipEngine extends ShipPart
{
  
  private int enginePower;
  private shipPart parent;
  private shipPart[] children;
  
  public ShipBattery(String name, int cost, int size, String ref, int acceleration, float x, float y, float yVelocity)
  {
    super(name,cost,size,ref, x, y, yVelocity);
    this.enginePower = enginePower;
  }
  
  
  
  
}
