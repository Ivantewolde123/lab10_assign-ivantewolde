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
    super.act();
    MouseInfo mouse = Greenfoot.getMouseInfo();
       
    if (mouse != null)
    {
        Point2D mouseWindowPos = new Point2D(mouse.getX(), mouse.getY());
        Point2D mouseWorldPos = windowToWorld(mouseWindowPos);
        position.setX(mouseWorldPos.getX());
        
        Vector2D rocketToMouse = new Vector2D(mouse.getX() - getX(), mouse.getY() - getY());
        
        if (Greenfoot.mouseClicked(null))
        {
            // Calculate Velocity Vector
            rocketToMouse = windowToWorld(rocketToMouse);
            rocketToMouse.normalize();
            rocketToMouse = Vector2D.multiply(rocketToMouse, BULLET_VELOCITY);
            // Shoot bullet with velocity 
            Bullet bullet = new Bullet();
            bullet.setVelocity(rocketToMouse);
            SimulationWorld world = (SimulationWorld) getWorld();
            world.addObject(bullet, this.getX(), this.getY());
            bullet.setRotation(90);
        }
    }
            
    destroyShipOnCollision();    
   }   
}    
    
