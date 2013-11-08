package com.lasen.objects;



public class ShipWeapon extends ShipPart
{
  
  private int attackRadius;
  
  
    public ShipWeapon(String name, int cost, int size, String ref, int attackRadius, float x, float y, float yVelocity)
  {
    super(name,cost,size,ref, x, y, yVelocity);
    this.attackRadius = attackRadius;
  }
  
  
  
}
