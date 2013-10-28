package com.lasen.game;

import com.lasen.objects.PlayableObject;
import com.lasen.objects.RenderManager;
import com.lasen.objects.ShipBattery;
import com.lasen.objects.ShipPart;
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
public class GameplayState extends BasicGameState 
{
  int stateID = -1;
  ShipPart test;
    
  GameplayState( int StateID)
  {
        this.stateID = StateID;
  }
    
    @Override
  public int getID() 
  {
        return stateID;
  }

    @Override
  public void init(GameContainer gc, StateBasedGame sbg) throws SlickException 
  {
      Game.player = new PlayableObject("res/player.png");
      Game.renderManager = new RenderManager( Game.getPlayer() );
  }

    @Override
  public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException 
  {
      getDebug(grphcs);
      
      
  }

    @Override
  public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException 
  {
      movePlayer(gc,delta);
      rotatePlayer(gc,delta);
  }
    
  private void movePlayer(GameContainer gc, int delta) throws SlickException
    {
      Boolean leftPressed = gc.getInput().isKeyDown(Input.KEY_A);
      Boolean rightPressed = gc.getInput().isKeyDown(Input.KEY_D);
      Boolean upPressed = gc.getInput().isKeyDown(Input.KEY_W);
      Boolean downPressed = gc.getInput().isKeyDown(Input.KEY_S);      
      
      Game.getPlayer().processMovement(leftPressed, rightPressed, upPressed, downPressed, delta);      
    }
    
  private void rotatePlayer(GameContainer gc, int delta) throws SlickException
    {
      Boolean qPressed = gc.getInput().isKeyDown(Input.KEY_Q);
      Boolean ePressed = gc.getInput().isKeyDown(Input.KEY_E);
      
      float rotationSpeed = Game.getPlayer().processRotation(qPressed, ePressed, delta);
      Game.getPlayer().rotate( rotationSpeed );
    }

  private void getDebug(Graphics g) throws SlickException 
  {
    String playerStringX = Float.toString( Game.getPlayer().getX() );
    String playerStringY = Float.toString( Game.getPlayer().getY() );
    String playerStringA = Float.toString( Game.getPlayer().getAcceleration() );
    String playerStringF = Float.toString( Game.getPlayer().getFriction() );
       
    g.drawString( "Player:", 10f, 40f);
    g.drawString( "X: " + playerStringX, 10f, 60f);
    g.drawString( "Y: " + playerStringY, 10f, 80f);
    g.drawString( "Acc: " + playerStringA, 10f, 100f);
    g.drawString( "Fct: " + playerStringF, 10f, 120f);   
  }
  
  private boolean objectOnScreen( float x, float y )
  {
  
    if( x < 0 || x > Game.getWindowWidth() || y<0 || y>Game.getWindowHeight() )
    {
      return false;
    } else { return true; }
    
  }
  
}
