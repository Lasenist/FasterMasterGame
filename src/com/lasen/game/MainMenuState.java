package com.lasen.game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Lasen
 */
public class MainMenuState extends BasicGameState 
{
    int stateID = -1;
    
    Image startGameOption = null;
    Image exitOption = null;
    Image menuImage;
    int menuX = 100;
    int menuY = 300;
    int startRotate = 1;
    
    float startGameScale = (float) 0.2;
    float exitScale = 1;
    
    MainMenuState( int stateID )
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
        Image menuImage = new Image("res/StartGame.png");
        startGameOption = menuImage.getSubImage(0,0,500,125);
        gc.setVSync(true);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException 
    {
        startGameOption.draw(menuX,menuY, startGameScale);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException 
    {
        Input input = gc.getInput();
        Boolean leftPressed = gc.getInput().isKeyDown(Input.KEY_LEFT);
        Boolean rightPressed = gc.getInput().isKeyDown(Input.KEY_RIGHT);
        
        
        int mouseX = input.getMouseX();
        int mouseY = input.getMouseY();
        
        boolean insideStartGame;
        //INSIDE START GAME OPTION
        if ( ( mouseX >= menuX  &&  mouseX <= menuX + 100 ) 
            && ( mouseY >= menuY  &&  mouseY <= menuY + 25 ) )
                    { insideStartGame = true; } else { insideStartGame = false; }
        
        if(insideStartGame == true)
        {
            startGameOption.setRotation(startRotate);
            
            if( input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON ) )
            {
                sbg.enterState(Game.UPGRADE_STATE);
            }
            
            
        } else{ startGameOption.setRotation(startRotate -1); }
    }
    
}
