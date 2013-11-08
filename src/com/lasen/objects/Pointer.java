/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lasen.objects;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Lasen
 */
public class Pointer 
{
  private float x;
  private float y;
  private float rotation;
  private PlayableObject player;
  private ShipPart[] parts;
  
  public Pointer( PlayableObject player, ShipPart[] parts)
  {
    this.player = player;
    this.parts = parts;
    this.x = player.getX();
    this.y = player.getY();
  }
  
  public float getRotation(){ return rotation; }
  
  public void processMovement()
  {
    this.x = player.getX()+11;
    this.y = player.getY()+5;
    pointToNearestShipPart();
  }
  
  public void draw(Graphics g) throws SlickException
  {
    Image image = new Image("res/shipCompass.png");   //Place this at the top of the screen
    image.setCenterOfRotation(5, 11);                 //Not the center of the ship
    image.setRotation(rotation);
    g.drawImage(image, x, y);
  }
  
  private void pointToNearestShipPart()
  {
    if( parts != null)
    {
    ShipPart closest = parts[0];
      
      for( int i = 1; i<1 ;i++ ) 
      {
        if( closest.getY() > parts[i].getY() &&  player.getY() < closest.getY() )
        {
          closest = parts[i];
        }  
      }  
    
    float deltaX = -( closest.getX() - player.getX() );
    float deltaY = -( closest.getY() - player.getY() );
    
    double inRads = Math.atan2(deltaX,deltaY);
    
    if( inRads < 0)
    {
     inRads = Math.abs(inRads);
    }
    else 
    {
     inRads = 2*Math.PI - inRads;
    }    
    rotation = (float) Math.toDegrees(inRads);
    }
    
  }
    
    
  
  
  
  
}
