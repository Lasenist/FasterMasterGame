package com.lasen.objects;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Lasen
 */
public class RenderManager 
{
 
  private PlayableObject player;
  private float playerXVelocity;
  private float playerYVelocity;
  
  public RenderManager(PlayableObject player)
  {
    this.player = player;
  }
  
  public void getRelativeVelocity(ShipPart shipPart, float xVelocity, float yVelocity, int delta)
  {
    float DELTA_DIV_ONEHUNDRED = delta/100;
    
    float relativeXVelocity = player.getXVelocity();
    float relativeYVelocity = yVelocity - player.getYVelocity();
    
    
    String tempX = String.format("%.0f", relativeXVelocity -( relativeXVelocity * DELTA_DIV_ONEHUNDRED ) );
    String tempY = String.format("%.0f", relativeYVelocity -( relativeYVelocity * DELTA_DIV_ONEHUNDRED ) );
    
    relativeXVelocity = Float.parseFloat(tempX);
    relativeYVelocity = Float.parseFloat(tempY);
   
    
    shipPart.setY( shipPart.getY() - relativeYVelocity );
    shipPart.setX( shipPart.getX() + relativeXVelocity );
    
    
  }
  
  
  public void renderShipPart(ShipPart shipPart, float x, float y) throws SlickException
  {        
    shipPart.getImage().draw(x, y);
    shipPart.setY(y);
  }
  
  
}
