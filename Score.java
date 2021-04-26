import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    private double score = 0;
    
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        SimulationWorld world = (SimulationWorld) getWorld();
        
        List<SpaceShip> ships = world.getObjects(SpaceShip.class);
        
        if (ships.size() <= 0)
        {
            return;
        }
                
        SimulationActor ship = world.getObjects(SpaceShip.class).get(0);
        
        if (ship != null)
        {
            score = ship.position.getY() + 5;
        }
        
        setImage(new GreenfootImage("Score: " + (int) score + " ",30 , Color.WHITE, Color.BLACK, Color.YELLOW));
        
    }  
    
    public double getScore()
    {
        return score;
    }

    
}
