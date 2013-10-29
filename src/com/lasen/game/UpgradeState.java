/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lasen.game;

import com.lasen.objects.*;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Lasen
 */
public class UpgradeState extends BasicGameState
{

  int stateID = 3;
  ShipPart test;
  Pointer compass;
  ShipPart[] parts = new ShipPart[10];
  
  UpgradeState (int stateID)
  {
    this.stateID = stateID;
  }
  
  @Override
  public int getID() 
  {
    return stateID;  
  }

  @Override
  public void init(GameContainer gc, StateBasedGame sbg) throws SlickException 
  {
    Game.player = new PlayableObject();
    Game.renderManager = new RenderManager( Game.getPlayer() );

    test = new ShipBattery("Test",0,1,"res/player.png",0, 100, 100 , 2);
    parts[0] = test;
    compass = new Pointer(Game.getPlayer(), parts);    
  }

  @Override
  public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException 
  {
    Game.getPlayer().draw();
    getDebug(grphcs, gc);    
    test.draw();
    compass.draw();
  }

  @Override
  public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException 
  {
    movePlayer(gc,delta);
    rotatePlayer(gc,delta);    
    test.processMovement(delta);
    compass.processMovement();    
  }
  
  private void movePlayer(GameContainer gc, int delta)
  {
      Boolean leftPressed = gc.getInput().isKeyDown(Input.KEY_A);
      Boolean rightPressed = gc.getInput().isKeyDown(Input.KEY_D);
      Boolean upPressed = gc.getInput().isKeyDown(Input.KEY_W);
      Boolean downPressed = gc.getInput().isKeyDown(Input.KEY_S);      
      
      Game.getPlayer().processMovement(leftPressed, rightPressed, upPressed, downPressed, delta);      
    }
    
  private void rotatePlayer(GameContainer gc, int delta)
  {
      Boolean qPressed = gc.getInput().isKeyDown(Input.KEY_Q);
      Boolean ePressed = gc.getInput().isKeyDown(Input.KEY_E);
      
      float rotationSpeed = Game.getPlayer().processRotation(qPressed, ePressed, delta);
      Game.getPlayer().rotate( rotationSpeed );
  }
  
  private void getDebug(Graphics g, GameContainer gc) 
  {
    String playerStringX = Float.toString( Game.getPlayer().getX() );
    String playerStringY = Float.toString( Game.getPlayer().getY() );
    String playerStringXV = Float.toString( Game.getPlayer().getXVelocity() );
    String playerStringYV = Float.toString( Game.getPlayer().getYVelocity() );
    String mouseX = Integer.toString( gc.getInput().getMouseX() );
    String mouseY = Integer.toString( gc.getInput().getMouseY() );
       
    g.drawString( "Player:", 10f, 40f);
    g.drawString( "X: " + playerStringX, 10f, 60f);
    g.drawString( "Y: " + playerStringY, 10f, 80f);
    g.drawString( "xVel: " + playerStringXV, 10f, 100f);
    g.drawString( "yVel: " + playerStringYV, 10f, 120f);
    
    g.drawString( "Mouse X: " + mouseX, 10f, 160f );
    g.drawString( "Mouse Y: " + mouseY, 10f, 180f );
  }
  
  
}
