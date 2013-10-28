package com.lasen.objects;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author Lasen
 */
public class PlayableObject extends Image
{
  ShipPart[] children;
  
  private float x = 600f;
  private float y = 400f;
  
  private float xVelocity = 0f;
  private float yVelocity = 0f;
  
  private float acceleration = 2f;
  private float friction = 50f;        
 
  public PlayableObject(String ref) throws SlickException
  {
    super(ref);       
  }
  
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
    x = -Float.parseFloat( tempX ) + 640;
    y = -Float.parseFloat( tempY ) + 400;   
  }
  
  public float processRotation(Boolean qPressed, Boolean ePressed, int delta) 
  {   
    
    //REWRITE THIS IN YOUR NEXT HEARTBEAT
    
    if( friction !=0 )
    {
      if( qPressed ){ return -( 0.5f ); }
      if( ePressed ){ return ( 0.5f ); }
      if( !qPressed && !ePressed){ return 0f; }
    } else if( friction == 0)
    {
      if( qPressed ){ return -0.1f; }
      if( ePressed ){ return 0.1f; }
      if( !qPressed && !ePressed){ return 0f; }
    }
    
    return 0f;
  }
  
  public Rectangle getBoundingBox()
  {
    Rectangle boundingBox = new Rectangle( getX(),getY(), 32, 32 );
    return boundingBox;
  }
  
  @Override
  public void draw(float x,float y)
  {
    this.x = x;
    this.y= y;
    super.draw(x, y);    
  }
  
  @Override
  public Image getSubImage(int x, int y, int width, int height)
  {
    return super.getSubImage(x, y, width, height);
  }


  
  
  
}
