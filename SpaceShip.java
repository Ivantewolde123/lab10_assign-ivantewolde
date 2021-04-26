import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class SpaceShip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpaceShip extends SimulationActor
{

    private static final double BULLET_VELOCITY = -10;
    private boolean destroyedShip = false;

    public SpaceShip()
    {
        super();

        alignWithVector(new Vector2D(0.0, -1.0));

        acceleration = new Vector2D(0.0, 0.4);
    }

    public void destroyShipOnCollision()
    {

        
    }

    public void act() 
    {
      
        
        
        destroyShipOnCollision();
    }    
}
