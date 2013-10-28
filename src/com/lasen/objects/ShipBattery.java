/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lasen.objects;

import org.newdawn.slick.Image;

/**
 *
 * @author Lasen
 */
public class ShipBattery extends ShipPart
{
  
  private int powerRadius;
  
  public ShipBattery(String name, int cost, int size, String ref, int powerRadius, float x, float y, float yVelocity)
  {
    super(name,cost,size,ref, x, y, yVelocity);
    this.powerRadius = powerRadius;
  }
  
  
  
  
}
