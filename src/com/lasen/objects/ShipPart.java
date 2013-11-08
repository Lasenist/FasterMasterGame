package com.lasen.objects;

import com.lasen.game.Game;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author Lasen
 */
abstract public class ShipPart 
{
  private float x;
  private float y;
  private float rotation;
  private float xVelocity;
  private float yVelocity;
  
  
  ShipPart parents = null;
  ShipPart[] children = null;
  
  String name;
  int cost;
  int size;
  String ref;

  public float getX(){ return x; }
  public float getY(){ return y; }
  
  public float setX(float value){ return x = value; }
  public float setY(float value){ return y = value; }
  
  public float getXVelocity(){ return xVelocity; }
  public float getYVelocity(){ return yVelocity; }
  
  public float setXVelocity( float value ){ return xVelocity = value; };
  public float setYVelocity( float value ){ return yVelocity = value; };
  
  
  public String getName(){ return name; }
  public int getCost(){ return cost; }
  public int getSize(){ return size; }
  public String getRef(){ return ref; }    
  
  public ShipPart(String name, int cost, int size, String ref, float x, float y, float yVelocity)
  {
    this.name = name;
    this.cost = cost;
    this.size = size;
    this.ref = ref;
    
    this.x = x;
    this.y = y;
    this.yVelocity = yVelocity;
  }
  
  public Rectangle getCollisionBox()
  {
    Rectangle collisionBox = null;
    switch(getSize())
    {
      case 1: collisionBox = new Rectangle(getX(),getY(),32,32);
              break;
      case 2: collisionBox = new Rectangle(getX(),getY(),64,64);
              break;
      case 3: collisionBox = new Rectangle(getX(),getY(),128,128);
              break;
    }
    return collisionBox; 
  }
  
  public void processMovement(int delta)
  {
    Game.getRenderManager().getRelativeVelocity(this, getXVelocity(), getYVelocity(), delta);
    
    setX(  getX() + getXVelocity() );
    setY(  getY() + getYVelocity() );
  }
  
  public void draw(Graphics g) throws SlickException
  {    
    Game.getRenderManager().renderShipPart( this , getX(), getY() + getYVelocity(), g );
  }
  
  public Image getImage() throws SlickException
  {
    Image image = new Image( getRef() );
    return image;
  }
  
  
  
  
}
