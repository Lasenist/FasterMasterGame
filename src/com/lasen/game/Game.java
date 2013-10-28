package com.lasen.game;

import com.lasen.objects.PlayableObject;
import com.lasen.objects.RenderManager;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
/**
 *
 * @author Lasen
 */
public class Game extends StateBasedGame
{
    public static final int MAIN_MENU_STATE  = 0;
    public static final int GAMEPLAY_STATE   = 1;
    public static final int UPGRADE_STATE = 2;
    public static final int ACTION_STATE = 3;

    public static PlayableObject player;
    public static RenderManager renderManager;
    
    public static int width = 1280;
    public static int height = 800;
    

    public Game()
    {
        super("Faster,Master?");
    }
    
    public static int getWindowWidth(){ return width ; }
    public static int getWindowHeight(){ return height; }
    
    public static void main(String[] args) throws SlickException
    {
        AppGameContainer app = new AppGameContainer(new Game());
        
        app.setDisplayMode(width,height,false);
        app.start();     
    }
    
    @Override
    public void initStatesList(GameContainer gc) throws SlickException 
    {
        this.addState(new MainMenuState(MAIN_MENU_STATE));
        this.addState(new GameplayState(GAMEPLAY_STATE));
        this.addState(new UpgradeState(UPGRADE_STATE));
//        this.addState(new ActionState(ACTION_STATE));
    }
    
    public static PlayableObject getPlayer()
    {
      return player;
    }
    
    public static RenderManager getRenderManager()
    {
      return renderManager;
    }
    
}
