package com.lasen.objects;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author Lasen
 */
public class PlayableObject
{
  ShipPart[] children;
  
  private float x;
  private float y;
  
  private float xVelocity = 0f;
  private float yVelocity = 0f;
  
  private float acceleration = 2f;
  private float friction = 50f;        
 
  public PlayableObject() {}
  
  public float getX() { return x; }  
  public float getY() { return y; }
  public float getXVelocity(){ return xVelocity; }
  public float getYVelocity(){ return yVelocity; }
  public float getAcceleration(){ return acceleration; }
  public float getFriction(){ return friction; }
  
  public void setX( int x ) { this.x = x; }
  public void setY( int y ) { this.y = y; }
    
  public void processMovement(boolean leftPressed, boolean rightPressed, boolean upPressed, boolean downPressed, float delta)
  {
    String tempX;
    String tempY;
    float DELTA_DIV_ONEHUNDRED = delta/100;    
    
//MOVEMENT
    if ( leftPressed ) { xVelocity = xVelocity + acceleration * DELTA_DIV_ONEHUNDRED; }    
    if ( rightPressed ) { xVelocity = xVelocity - acceleration * DELTA_DIV_ONEHUNDRED; }    
    if( upPressed ) { yVelocity = yVelocity + acceleration * DELTA_DIV_ONEHUNDRED; }    
    if( downPressed ) { yVelocity = yVelocity - acceleration * DELTA_DIV_ONEHUNDRED; }    
 
//KEEP PLAYER ON THE SCREEN
    if(xVelocity > 200){ xVelocity = xVelocity - acceleration * DELTA_DIV_ONEHUNDRED; }
    if(xVelocity < -200){ xVelocity = xVelocity + acceleration * DELTA_DIV_ONEHUNDRED; }
    if(yVelocity > 200){ yVelocity = yVelocity - acceleration * DELTA_DIV_ONEHUNDRED; }
    if(yVelocity < -200){ yVelocity = yVelocity + acceleration * DELTA_DIV_ONEHUNDRED; }
    
//SOME MYSTICAL CODE THAT WORKS I CANT REMEMBER HOW
    tempX = String.format("%.0f", xVelocity -( xVelocity * DELTA_DIV_ONEHUNDRED ) );
    tempY = String.format("%.0f", yVelocity -( yVelocity * DELTA_DIV_ONEHUNDRED ) );
    
 //UPDATES X AND Y   
    this.x = -Float.parseFloat( tempX ) + 640;
    this.y = -Float.parseFloat( tempY ) + 400;
  }
  
  public float processRotation(Boolean qPressed, Boolean ePressed, int delta) 
  {
    return 0f;
  }

  public Image getImage()
  {
      Image player = null;
      try
      {
          player = new Image("res/player.png");
      } catch (SlickException e)
        {
          e.printStackTrace();
        }

      return player;

  }
  
  public Rectangle getBoundingBox()
  {

    return new Rectangle( getX(),getY(), 32, 32 );
  }
  

  public void draw(Graphics g)
  {
    g.drawImage(getImage(), this.getX(), this.getY() );
  }

  public void rotate(float angle)
  {
    getImage().rotate(angle);
  }



  
  
  
}
