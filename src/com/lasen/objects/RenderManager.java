package com.lasen.objects;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Lasen
 */
public class RenderManager 
{
 
  private PlayableObject player;
  private int width;
  private int height;

  
  public RenderManager(PlayableObject player, int width, int height)
  {
    this.player = player;
    this.width = width;
    this.height = height;
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
  
  
  public void renderShipPart(ShipPart shipPart, float x, float y, Graphics g) throws SlickException
  {
    if( insideWindow(x,y) )
    {
     g.drawImage(shipPart.getImage(), x, y );
    }
    shipPart.setY(y);
  }

  private boolean insideWindow(float x, float y)
  {
    if( (x < width && x > 0)  ||  ( y < height && y > 0 ) )
    {
      return true;
    } else return false;
  }
  
  
}
